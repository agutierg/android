/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agutierg.hits2013.vistas;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.agutierg.hits2013.R;
import com.agutierg.hits2013.constants.ConstantesParametros;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class VideoViewDemo extends Activity {
	private static final String TAG = "VideoViewDemo";

	private VideoView mVideoView;
	private ImageButton mPlay;
	private ImageButton mPause;
	private ImageButton mReset;

	private String current;

	private LinearLayout llPlayer;
	private AdView adView;

	private String urlVisualizar;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.ejemplo);

		llPlayer = (LinearLayout) findViewById(R.id.llPlayer);
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER,
				"ca-app-pub-3391184176179743/8651174511");
		adView.setGravity(Gravity.CENTER);

		// Añadirle la adView
		llPlayer.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		// Recogemos el boton pulsado
		Bundle bundle = getIntent().getExtras();
		if (bundle.getSerializable(ConstantesParametros.URL_CANCION) != null) {
			urlVisualizar = (String) bundle
					.getSerializable(ConstantesParametros.URL_CANCION);
		}

		mVideoView = (VideoView) findViewById(R.id.surface_view);

		mPlay = (ImageButton) findViewById(R.id.play);
		mPause = (ImageButton) findViewById(R.id.pause);
		mReset = (ImageButton) findViewById(R.id.reset);

		mPlay.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				playVideo();
			}
		});
		mPause.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView != null) {
					mVideoView.pause();
				}
			}
		});
		mReset.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if (mVideoView != null) {
					mVideoView.seekTo(0);
				}
			}
		});
		runOnUiThread(new Runnable() {
			public void run() {
				playVideo();

			}

		});
	}

	private void playVideo() {
		try {
			mVideoView.setVideoURI(Uri.parse(urlVisualizar));
			mVideoView.start();
			mVideoView.requestFocus();
		} catch (Exception e) {
			Log.e(TAG, "error: " + e.getMessage(), e);
			if (mVideoView != null) {
				mVideoView.stopPlayback();
			}
		}
	}
}
