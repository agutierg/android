package com.agutierg.pollitopio.vistas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.agutierg.pollitopio.R;
import com.agutierg.pollitopio.constants.ConstantesParametros;

public class Main extends Activity {

	private Button btnPlay;
	private Button btnShare;
	private Button btnMore;
	private Button btnWall;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.layout_main);

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
						"http://www.youtube.com/watch?v=dhsy6epaJGs");
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
						Uri.parse("https://play.google.com/store/apps/details?id=com.agutierg.temas2013&feature=search_result#?t=W251bGwsMSwxLDEsImNvbS5hZ3V0aWVyZy50ZW1hczIwMTMiXQ..")));
			}
		});

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
