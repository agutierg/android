package com.agutierg.pollitopio.vistas;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.agutierg.pollitopio.R;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

public class SetWallpaper extends Activity implements AdListener {
	Bitmap bitmap;
	int lastImageRef;

	private InterstitialAd interstitial;
	private Activity actividad;

	private LinearLayout llWallpaper;
	private AdView adView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_wallpaper);

		llWallpaper = (LinearLayout) findViewById(R.id.llWallpaper);
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a1515dad15d68b1");
		adView.setGravity(Gravity.CENTER);

		// Añadirle la adView
		llWallpaper.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		Button buttonSetWallpaper = (Button) findViewById(R.id.btnWall);
		ImageView imagePreview = (ImageView) findViewById(R.id.ivWall);
		imagePreview.setImageResource(R.drawable.wall);

		actividad = this;

		buttonSetWallpaper.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				WallpaperManager myWallpaperManager = WallpaperManager
						.getInstance(getApplicationContext());
				try {
					myWallpaperManager.setResource(R.drawable.wall);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Create the interstitial
				interstitial = new InterstitialAd(actividad, "a1515dad15d68b1");

				// Create ad request
				AdRequest adRequest = new AdRequest();

				// Begin loading your interstitial
				interstitial.loadAd(adRequest);

				// Set Ad Listener to use the callbacks below
				interstitial.setAdListener((AdListener) actividad);

				finish();
			}
		});
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
	public void onPresentScreen(Ad ad) {
		if (ad == interstitial) {
			interstitial.show();
		}
	}

	@Override
	public void onReceiveAd(Ad ad) {
		if (ad == interstitial) {
			interstitial.show();
		}
	}
}
