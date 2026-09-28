package com.agutierg.pollitopio.vistas;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.agutierg.pollitopio.BuildConfig;
import com.agutierg.pollitopio.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class VideoViewDemo extends Activity {
	private static final String TAG = "VideoViewDemo";

	// En debug se usan anuncios de prueba; en release, el bloque real "Pollito pio"
	private static final String BANNER_AD_UNIT_ID = BuildConfig.DEBUG
			? "ca-app-pub-3940256099942544/6300978111"
			: "ca-app-pub-3391184176179743/1249072833";

	private VideoView mVideoView;
	private ImageButton mPlay;
	private ImageButton mPause;
	private ImageButton mReset;
	private ImageButton mStop;

	private LinearLayout llPlayer;
	private AdView adView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.ejemplo);

		llPlayer = (LinearLayout) findViewById(R.id.llPlayer);

		// Crear la adView con el SDK moderno
		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(BANNER_AD_UNIT_ID);
		llPlayer.addView(adView);
		adView.loadAd(new AdRequest.Builder().build());

		mVideoView = (VideoView) findViewById(R.id.surface_view);

		mPlay = (ImageButton) findViewById(R.id.play);
		mPause = (ImageButton) findViewById(R.id.pause);
		mReset = (ImageButton) findViewById(R.id.reset);
		mStop = (ImageButton) findViewById(R.id.stop);

		mPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				mVideoView.start();
			}
		});
		mPause.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView.isPlaying()) {
					mVideoView.pause();
				}
			}
		});
		mReset.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// Reiniciar desde el principio y reproducir
				mVideoView.seekTo(0);
				mVideoView.start();
			}
		});
		mStop.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// Cerrar el reproductor y volver a la pantalla principal
				mVideoView.stopPlayback();
				finish();
			}
		});

		prepararVideo();
		mVideoView.start();
	}

	private void prepararVideo() {
		try {
			mVideoView.setVideoURI(Uri.parse("android.resource://"
					+ getPackageName() + "/" + R.raw.pio));
			// Repetir el vídeo automáticamente al terminar
			mVideoView.setOnPreparedListener(mp -> mp.setLooping(true));
			mVideoView.requestFocus();
		} catch (Exception e) {
			Log.e(TAG, "error: " + e.getMessage(), e);
		}
	}

	@Override
	protected void onPause() {
		if (adView != null) {
			adView.pause();
		}
		if (mVideoView != null && mVideoView.isPlaying()) {
			mVideoView.pause();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (adView != null) {
			adView.resume();
		}
	}

	@Override
	protected void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}
}
