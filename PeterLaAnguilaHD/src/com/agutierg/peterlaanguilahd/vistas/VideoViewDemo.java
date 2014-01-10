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
package com.agutierg.peterlaanguilahd.vistas;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.agutierg.peterlaanguilahd.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class VideoViewDemo extends Activity {
	private static final String TAG = "VideoViewDemo";

	private VideoView mVideoView;

	private LinearLayout llPlayer;
	private AdView adView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.ejemplo);

		llPlayer = (LinearLayout) findViewById(R.id.llPlayer);
		// Crear la adView
		adView = new AdView(this, AdSize.BANNER, "a151c4368c2bec7");
		adView.setGravity(Gravity.CENTER);

		// Añadirle la adView
		llPlayer.addView(adView);

		// Iniciar una solicitud genérica para cargarla con un anuncio
		adView.loadAd(new AdRequest());

		mVideoView = (VideoView) findViewById(R.id.surface_view);

		runOnUiThread(new Runnable() {
			public void run() {
				playVideo();

			}

		});
	}

	private void playVideo() {
		try {
			mVideoView.setVideoURI(Uri
					.parse("android.resource://com.agutierg.peterlaanguilahd/"
							+ R.raw.anguila_hd));
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
