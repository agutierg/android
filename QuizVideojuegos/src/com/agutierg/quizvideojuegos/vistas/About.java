package com.agutierg.quizvideojuegos.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;

public class About extends Activity {

	private TextView tvAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_about);

		tvAbout = (TextView) findViewById(R.id.tvAbout);

		tvAbout.setText(ConstantesParametros.TEXTO_ABOUT);
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
