package com.agutierg.hits2013.vistas;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agutierg.hits2013.R;
import com.agutierg.hits2013.constants.ConstantesParametros;
import com.agutierg.hits2013.database.Temazos2013SQLite;
import com.agutierg.hits2013.dto.Cancion;
import com.agutierg.hits2013.utils.CancionFunctions;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private List<Cancion> data;
	private static LayoutInflater inflater = null;

	private DownloadFile downloadFile;
	private TareaInicialBDTask tarea;
	// declare the dialog as a member field of your activity
	private ProgressDialog mProgressDialog;
	private String nombreCancion;
	private Cancion cancion;

	private Cancion cancionSeleccionada;
	private View viewSel;
	private ProgressDialog pDialog;

	private HashMap<Integer, TextView> hashTVVotos = new HashMap<Integer, TextView>();

	public LazyAdapter(Activity a, List<Cancion> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Cancion getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView nombre = (TextView) vi.findViewById(R.id.tvNombreROW);
		TextView cantante = (TextView) vi.findViewById(R.id.tvCantanteROW);
		TextView duracion = (TextView) vi.findViewById(R.id.tvDurationROW);
		ImageView facebook = (ImageView) vi.findViewById(R.id.ivFacebookROW);
		ImageView ivYoutubeROW = (ImageView) vi.findViewById(R.id.ivYoutubeROW);
		ImageView ivLikeROW = (ImageView) vi.findViewById(R.id.ivLikeROW);
		Button download = (Button) vi.findViewById(R.id.ivDownloadROW);
		TextView tvVotosROW = (TextView) vi.findViewById(R.id.tvVotosROW);

		cancion = data.get(position);

		// Setting all values in listview
		nombre.setText(cancion.getTitulo());
		cantante.setText(cancion.getCantante());
		duracion.setText(cancion.getDuracion());
		tvVotosROW.setText(vi.getContext().getString(R.string.rates)
				+ cancion.getVotos().toString());

		hashTVVotos.put(cancion.getIdCancion(), tvVotosROW);
		// if (cancion.getUrlDescarga() == null
		// || ("").equals(cancion.getUrlDescarga())) {
		// download.setVisibility(View.INVISIBLE);
		// }

		ivLikeROW.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cancionSeleccionada = data.get(position);
				viewSel = v;

				// Creamos el menú contextual
				AlertDialog.Builder builder = new AlertDialog.Builder(v
						.getContext());
				builder.setMessage(v.getContext().getString(
						R.string.preguntavoto));
				builder.setCancelable(true);
				builder.setPositiveButton(ConstantesParametros.MENU_CONTEX_OK,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								/**
								 * 
								 * 
								 * TAREA
								 * 
								 */
								pDialog = new ProgressDialog(viewSel
										.getContext());
								pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
								pDialog.setMessage(viewSel.getContext()
										.getString(R.string.uploading));
								pDialog.setCancelable(false);
								pDialog.setMax(100);

								pDialog.setButton(
										DialogInterface.BUTTON_NEGATIVE,
										"Cancel",
										new DialogInterface.OnClickListener() {
											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												pDialog.dismiss();
											}
										});
								pDialog.show();

								tarea = new TareaInicialBDTask();
								tarea.execute();
								/**
								 * 
								 * 
								 * TAREA
								 * 
								 */
								// OK
								CharSequence text = viewSel.getContext()
										.getString(R.string.likemore);
								Toast toast = Toast.makeText(
										viewSel.getContext(), text,
										Toast.LENGTH_SHORT);
								toast.show();
							}
						});
				builder.setNegativeButton(
						ConstantesParametros.MENU_CONTEX_CANCEL,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

							}
						});
				AlertDialog alert = builder.create();
				alert.show();
			}

		});

		ivYoutubeROW.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String urlVisualizar = null;
				Cancion cancion = new Cancion();
				cancion = data.get(position);

				if (cancion != null && cancion.getUrlDescarga() != null
						&& !("").equals(cancion.getUrlDescarga())) {
					urlVisualizar = cancion.getUrlDescarga();

					Intent vistaPlay = new Intent(v.getContext(),
							VideoViewDemo.class);
					vistaPlay.putExtra(ConstantesParametros.URL_CANCION,
							urlVisualizar);
					v.getContext().startActivity(vistaPlay);
				} else {
					urlVisualizar = cancion.getUrl();
					v.getContext().startActivity(
							new Intent(Intent.ACTION_VIEW, Uri
									.parse(urlVisualizar)));
				}
			}

		});

		facebook.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Cancion cancion = new Cancion();
				cancion = data.get(position);

				final Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, cancion.getUrl());
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				v.getContext().startActivity(
						Intent.createChooser(intent, "Compartir con"));
			}
		});

		download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Cancion cancion = new Cancion();
				cancion = data.get(position);

				if (cancion.getUrlDescarga() != null
						&& !("").equals(cancion.getUrlDescarga())) {

					// instantiate it within the onCreate method
					mProgressDialog = new ProgressDialog(v.getContext());
					mProgressDialog.setMessage(v.getContext().getString(
							R.string.descargabreve));
					mProgressDialog.setIndeterminate(false);
					mProgressDialog.setMax(100);
					mProgressDialog.setCancelable(false);
					mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
							"Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									mProgressDialog.dismiss();
								}
							});
					mProgressDialog
							.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

					nombreCancion = cancion.getCantante() + "-"
							+ cancion.getTitulo();

					// execute this when the downloader must be fired
					downloadFile = new DownloadFile();
					downloadFile.execute(cancion.getUrlDescarga());
				} else {
					// NO HAY CANCION
					CharSequence text = v.getContext().getString(
							R.string.noavailable);
					Toast toast = Toast.makeText(v.getContext(), text,
							Toast.LENGTH_SHORT);
					toast.show();
				}

			}
		});

		return vi;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ------------------------------------------
	 * -------------------------------ASYNC TASK
	 * ------------------------------------------
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public class DownloadFile extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... sUrl) {

			try {
				URL url = new URL(sUrl[0]);
				URLConnection connection = url.openConnection();
				connection.connect();
				// this will be useful so that you can show a typical 0-100%
				// progress bar
				int fileLength = connection.getContentLength();

				// download the file
				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream(Environment
						.getExternalStorageDirectory().getPath()
						+ "/"
						+ nombreCancion + ".mp3");

				byte data[] = new byte[1024];
				long total = 0;
				int count;
				while ((count = input.read(data)) != -1) {
					total += count;
					// publishing the progress....
					publishProgress((int) (total * 100 / fileLength));
					output.write(data, 0, count);
				}

				output.flush();
				output.close();
				input.close();
			} catch (Exception e) {
				return "0";
			}

			return "1";
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			mProgressDialog.dismiss();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... progress) {
			super.onProgressUpdate(progress);
			mProgressDialog.setProgress(progress[0]);
		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ------------------------------------------
	 * -------------------------------ASYNC TASK
	 * ------------------------------------------
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public class TareaInicialBDTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... uri) {

			CancionFunctions cancionF = new CancionFunctions();
			cancionF.votarCancion(cancionSeleccionada.getIdCancion());
			return null;

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			// Actualizamos base de datos
			Temazos2013SQLite baseDatosTemazos = new Temazos2013SQLite(
					viewSel.getContext(), "DBTemazos", null, 2);
			SQLiteDatabase db = baseDatosTemazos.getWritableDatabase();
			db.execSQL("UPDATE Cancion SET votos=votos+1 WHERE idCancion="
					+ cancionSeleccionada.getIdCancion());
			db.close();
			// Cerramos
			pDialog.dismiss();

			cancionSeleccionada.setVotos(cancionSeleccionada.getVotos() + 1);
			TextView tvVotos = hashTVVotos.get(cancionSeleccionada
					.getIdCancion());
			tvVotos.setText("Rates: "
					+ cancionSeleccionada.getVotos().toString());
			notifyDataSetChanged();
		}

		@Override
		protected void onPreExecute() {
			pDialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			pDialog.setProgress(values[0]);
		}

	}

}
