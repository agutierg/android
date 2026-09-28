package com.agutierg.pollitopio.vistas;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.agutierg.pollitopio.BuildConfig;
import com.agutierg.pollitopio.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class SetWallpaper extends Activity {

	// En debug se usan anuncios de prueba; en release, el bloque real "Pollito pio"
	// (bloque antiguo de tipo dual: sirve banner e intersticial)
	private static final String BANNER_AD_UNIT_ID = BuildConfig.DEBUG
			? "ca-app-pub-3940256099942544/6300978111"
			: "ca-app-pub-3391184176179743/1249072833";
	private static final String INTERSTITIAL_AD_UNIT_ID = BuildConfig.DEBUG
			? "ca-app-pub-3940256099942544/1033173712"
			: "ca-app-pub-3391184176179743/3153181446";

	private LinearLayout llWallpaper;
	private AdView adView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_wallpaper);

		llWallpaper = (LinearLayout) findViewById(R.id.llWallpaper);

		// Banner con el SDK moderno
		adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId(BANNER_AD_UNIT_ID);
		llWallpaper.addView(adView);
		adView.loadAd(new AdRequest.Builder().build());

		Button buttonSetWallpaper = (Button) findViewById(R.id.btnWall);
		ImageView imagePreview = (ImageView) findViewById(R.id.ivWall);
		imagePreview.setImageResource(R.drawable.wall);

		buttonSetWallpaper.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				WallpaperManager myWallpaperManager = WallpaperManager
						.getInstance(getApplicationContext());
				try {
					myWallpaperManager.setResource(R.drawable.wall);
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Intersticial con el SDK moderno: se carga y se muestra al estar listo
				InterstitialAd.load(SetWallpaper.this, INTERSTITIAL_AD_UNIT_ID,
						new AdRequest.Builder().build(),
						new InterstitialAdLoadCallback() {
							@Override
							public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
								interstitialAd.show(SetWallpaper.this);
								finish();
							}

							@Override
							public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
								finish();
							}
						});
			}
		});
	}

	@Override
	protected void onPause() {
		if (adView != null) {
			adView.pause();
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
