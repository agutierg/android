package com.agutierg.peterlaanguilahd.vistas;

import com.agutierg.peterlaanguilahd.R;
import com.agutierg.peterlaanguilahd.constants.ConstantesParametros;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;


public class Main extends Activity {

	private Button btnPlay;
	private Button btnShare;
	private Button btnMore;
	private Button btnWall;
	
	private Context contexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.layout_main);
		
		contexto = this;

		btnPlay = (Button) findViewById(R.id.btnPlay);
		btnShare = (Button) findViewById(R.id.btnShare);
		btnMore = (Button) findViewById(R.id.btnMore);
		btnWall = (Button) findViewById(R.id.btnWallpaper);

		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaPlayer = new Intent(view.getContext(),
						VideoViewDemo.class);
				startActivityForResult(vistaPlayer,
						Integer.valueOf(ConstantesParametros.VISTA_PLAYER));
			}
		});

		btnShare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				final Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT,
						"http://www.youtube.com/watch?v=u4jLZxmRy1s");
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				view.getContext().startActivity(
						Intent.createChooser(intent, "Compartir con"));
			}
		});

		btnWall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent vistaWall = new Intent(view.getContext(),
						SetWallpaper.class);
				startActivityForResult(vistaWall,
						Integer.valueOf(ConstantesParametros.VISTA_WALL));
			}
		});

		btnMore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.hits2013")));
			}
		});

	}
	
	@Override
	public void onBackPressed() {

		// Creamos el menú contextual
		AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
		builder.setMessage(getApplicationContext().getString(
				R.string.preguntaapp));
		builder.setCancelable(true);
		builder.setPositiveButton(ConstantesParametros.MENU_CONTEX_OK,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.peterlaanguilahd&feature=search_result#?t=W251bGwsMSwxLDEsImNvbS5hZ3V0aWVyZy5wZXRlcmxhYW5ndWlsYWhkIl0.")));
					}
				});
		builder.setNegativeButton(ConstantesParametros.MENU_CONTEX_CANCEL,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finish();
						System.exit(0);
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
