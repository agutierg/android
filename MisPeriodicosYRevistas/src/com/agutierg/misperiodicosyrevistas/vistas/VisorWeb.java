package com.agutierg.misperiodicosyrevistas.vistas;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebIconDatabase;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.misperiodicosyrevistas.R;
import com.agutierg.misperiodicosyrevistas.constants.ConstantesParametros;
import com.agutierg.misperiodicosyrevistas.dto.Link;
import com.agutierg.misperiodicosyrevistas.dto.LinkHolder;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.InterstitialAd;

public class VisorWeb extends Activity implements AdListener {

	private WebView webview;
	private ProgressBar progressBar;
	private EditText urlEditText;
	private List<Link> historyStack;
	private ArrayAdapter<Link> dialogArrayAdapter;
	private Button stopButton;
	private static final Pattern urlPattern = Pattern
			.compile("^(https?|ftp|file)://(.*?)");

	private Activity actividad;
	private InterstitialAd interstitial;

	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_visor_web);

		actividad = this;

		// Recogemos LA URL a visualizar que nos viene por
		// parámetro
		Bundle bundle = getIntent().getExtras();

		if (bundle != null
				&& bundle.getString(ConstantesParametros.URL_VISUALIZAR) != null) {
			url = (String) bundle
					.getString(ConstantesParametros.URL_VISUALIZAR);
		}

		// Cargamos la página
		historyStack = new LinkedList<Link>();
		webview = (WebView) findViewById(R.id.webkit);

		urlEditText = (EditText) findViewById(R.id.url);
		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		stopButton = ((Button) findViewById(R.id.stopButton));
		// favicon
		WebIconDatabase.getInstance().open(
				getDir("icons", MODE_PRIVATE).getPath());

		// javascript and zoom
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setBuiltInZoomControls(true);

		if (Build.VERSION.SDK_INT >= 8) {
			webview.getSettings().setPluginState(PluginState.ON);
		} else {
			webview.getSettings().setPluginsEnabled(true);
		}

		// downloads
		webview.setDownloadListener(new CustomDownloadListener());

		webview.setWebViewClient(new CustomWebViewClient());

		webview.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int progress) {
				progressBar.setProgress(0);
				FrameLayout progressBarLayout = (FrameLayout) findViewById(R.id.progressBarLayout);
				progressBarLayout.setVisibility(View.VISIBLE);
				VisorWeb.this.setProgress(progress * 1000);

				TextView progressStatus = (TextView) findViewById(R.id.progressStatus);
				progressStatus.setText(progress + " %");
				progressBar.incrementProgressBy(progress);

				if (progress == 100) {
					progressBarLayout.setVisibility(View.GONE);
				}
			}

			@Override
			public void onReceivedTitle(WebView view, String title) {
				VisorWeb.this.setTitle(getString(R.string.app_name) + " - "
						+ VisorWeb.this.webview.getTitle());
			}

		});

		webview.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_UP:
					if (!v.hasFocus()) {
						v.requestFocus();
					}
					break;
				}
				return false;
			}

		});

		webview.loadUrl(url);

		webview.requestFocus();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						// Crear la adView
						// Create the interstitial
						interstitial = new InterstitialAd(actividad,
								"a1511f65de95788");

						// Create ad request
						AdRequest adRequest = new AdRequest();

						// Begin loading your interstitial
						interstitial.loadAd(adRequest);

						// Set Ad Listener to use the callbacks below
						interstitial.setAdListener((AdListener) actividad);
					}
				});
			}
		}).start();

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle(getString(R.string.history));
		builder.setPositiveButton(getString(R.string.clear),
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						historyStack.clear();
					}
				});

		builder.setNegativeButton(R.string.close, null);

		dialogArrayAdapter = new ArrayAdapter<Link>(this, R.layout.history,
				historyStack) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// holder pattern
				LinkHolder holder = null;
				if (convertView == null) {
					LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					convertView = inflater.inflate(R.layout.history, null);
					holder = new LinkHolder();
					holder.setUrl((TextView) convertView
							.findViewById(R.id.textView1));
					holder.setImageView((ImageView) convertView
							.findViewById(R.id.favicon));

					convertView.setTag(holder);
				} else {
					holder = (LinkHolder) convertView.getTag();
				}

				holder.getUrl().setText(historyStack.get(position).getUrl());
				Bitmap favicon = historyStack.get(position).getFavicon();
				if (favicon == null) {
					holder.getImageView().setImageDrawable(
							super.getContext().getResources()
									.getDrawable(R.drawable.estrella2));
				} else {
					holder.getImageView().setImageBitmap(favicon);
				}

				return convertView;
			}
		};

		builder.setAdapter(dialogArrayAdapter,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						webview.loadUrl(historyStack.get(item).getUrl());
						stopButton.setEnabled(true);
					}

				});

		return builder.create();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		dialogArrayAdapter.notifyDataSetChanged();
		super.onPrepareDialog(id, dialog);
	}

	// back button
	@Override
	public void onBackPressed() {
		if (webview.canGoBack()) {
			webview.goBack();
		} else {
			super.onBackPressed();
		}
	}

	class CustomWebViewClient extends WebViewClient {
		// the current WebView will handle the url
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (url.endsWith(".mp3") || url.endsWith(".aac")) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.parse(url), "audio/mpeg");
				startActivity(intent);
				return true;
			}
			return false;
		}

		// history and navigation buttons
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			if (checkConnectivity()) {

				// shows the current url
				VisorWeb.this.urlEditText.setText(url);

				// only one occurrence
				boolean b = false;
				ListIterator<Link> listIterator = historyStack.listIterator();
				while (listIterator.hasNext() && !b) {
					if (listIterator.next().getUrl().equals(url)) {
						b = true;
						listIterator.remove();
					}
				}
				Link link = new Link(url, favicon);
				historyStack.add(0, link);

				stopButton.setEnabled(true);
				updateButtons();
			}
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			stopButton.setEnabled(false);
			updateButtons();
		}

		// handles unrecoverable errors
		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			AlertDialog.Builder builder = new AlertDialog.Builder(VisorWeb.this);
			builder.setMessage(description)
					.setPositiveButton((R.string.ok), null)
					.setTitle("onReceivedError");
			builder.show();
		}

	}

	public void go(View view) {
		// hides the keyboard
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(
				urlEditText.getWindowToken(), 0);

		if (checkConnectivity()) {
			stopButton.setEnabled(true);

			// http protocol by default
			if (!urlPattern.matcher(urlEditText.getText().toString()).matches()) {
				urlEditText.setText("http://"
						+ urlEditText.getText().toString());
			}
			webview.loadUrl(urlEditText.getText().toString());
		}
	}

	public void back(View view) {
		if (checkConnectivity()) {
			webview.goBack();
		}
	}

	public void forward(View view) {
		if (checkConnectivity()) {
			webview.goForward();
		}
	}

	public void stop(View view) {
		webview.stopLoading();
		Toast.makeText(this, getString(R.string.stopping), Toast.LENGTH_LONG)
				.show();
	}

	public void history(View view) {
		// showDialog(0);
		if (urlEditText.getText() != null) {
			final Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, urlEditText.getText().toString());
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(Intent.createChooser(intent, "Compartir usando"));
		}
	}

	private void updateButtons() {
		Button backButton = (Button) VisorWeb.this
				.findViewById(R.id.backButton);

		if (webview.canGoBack()) {
			backButton.setEnabled(true);
		} else {
			backButton.setEnabled(false);
		}

		Button forwardButton = (Button) VisorWeb.this
				.findViewById(R.id.forwardButton);

		if (webview.canGoForward()) {
			forwardButton.setEnabled(true);
		} else {
			forwardButton.setEnabled(false);
		}
	}

	// DOWNLOAD MANAGER WITH ASYNCTASK

	class CustomDownloadListener implements DownloadListener {
		public void onDownloadStart(final String url, String userAgent,
				String contentDisposition, String mimetype, long contentLength) {
			AlertDialog.Builder builder = new AlertDialog.Builder(VisorWeb.this);

			builder.setTitle(getString(R.string.download));
			builder.setMessage(getString(R.string.question));
			builder.setCancelable(false)
					.setPositiveButton((R.string.ok),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									new DownloadAsyncTask().execute(url);
								}

							})
					.setNegativeButton((R.string.cancel),
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});

			builder.create().show();

		}

	}

	private class DownloadAsyncTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {
			String result = "";
			String url = arg0[0];

			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(url);
				InputStream inputStream = null;
				try {
					HttpResponse httpResponse = httpClient.execute(httpGet);

					BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(
							httpResponse.getEntity());

					inputStream = bufferedHttpEntity.getContent();

					String fileName = android.os.Environment
							.getExternalStorageDirectory().getAbsolutePath()
							+ "/webviewdemo";
					File directory = new File(fileName);
					File file = new File(directory, url.substring(url
							.lastIndexOf("/")));
					directory.mkdirs();

					// commons-io, I miss you :(
					FileOutputStream fileOutputStream = new FileOutputStream(
							file);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len = 0;

					while (inputStream.available() > 0
							&& (len = inputStream.read(buffer)) != -1) {
						byteArrayOutputStream.write(buffer, 0, len);
					}

					fileOutputStream.write(byteArrayOutputStream.toByteArray());
					fileOutputStream.flush();

					result = getString(R.string.result)
							+ file.getAbsolutePath();
				} catch (Exception ex) {
					Log.e(VisorWeb.class.toString(), ex.getMessage(), ex);
					result = ex.getClass().getSimpleName() + " "
							+ ex.getMessage();
				} finally {
					if (inputStream != null) {
						try {
							inputStream.close();
						} catch (IOException ex) {
							Log.e(VisorWeb.class.toString(), ex.getMessage(),
									ex);
							result = ex.getClass().getSimpleName() + " "
									+ ex.getMessage();
						}
					}
				}
			} else {
				result = getString(R.string.nosd);
			}

			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			AlertDialog.Builder builder = new AlertDialog.Builder(VisorWeb.this);
			builder.setMessage(result).setPositiveButton((R.string.ok), null)
					.setTitle(getString(R.string.download));
			builder.show();

		}

	}

	/**
	 * Checks networking status.
	 */
	private boolean checkConnectivity() {
		boolean enabled = true;

		ConnectivityManager connectivityManager = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();

		if ((info == null || !info.isConnected() || !info.isAvailable())) {
			enabled = false;
			Builder builder = new Builder(this);
			builder.setIcon(android.R.drawable.ic_dialog_alert);
			builder.setMessage(getString(R.string.noconnection));
			builder.setCancelable(false);
			builder.setNeutralButton(R.string.ok, null);
			builder.setTitle(getString(R.string.error));
			builder.create().show();
		}
		return enabled;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDismissScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLeaveApplication(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPresentScreen(Ad arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReceiveAd(Ad ad) {
		// TODO Auto-generated method stub
		if (ad == interstitial) {
			interstitial.show();
		}
	}
}
