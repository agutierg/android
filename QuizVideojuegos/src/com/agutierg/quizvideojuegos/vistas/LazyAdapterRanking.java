package com.agutierg.quizvideojuegos.vistas;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.dto.Jugador;

public class LazyAdapterRanking extends BaseAdapter {

	private Activity activity;
	private List<Jugador> data;
	private static LayoutInflater inflater = null;

	public LazyAdapterRanking(Activity a, List<Jugador> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Jugador getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row_ranking, null);

		TextView tvPuesto = (TextView) vi.findViewById(R.id.tvPuesto);
		TextView tvNombreJR = (TextView) vi.findViewById(R.id.tvNombreJR);
		TextView tvScore = (TextView) vi.findViewById(R.id.tvScore);

		Jugador jugador = new Jugador();
		jugador = data.get(position);

		tvPuesto.setText(jugador.getPuesto().toString());
		tvNombreJR.setText(jugador.getNombreJugador());
		tvScore.setText(jugador.getAciertos().toString());

		return vi;
	}
}
