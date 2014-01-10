package com.agutierg.quizvideojuegos.vistas;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agutierg.quizvideojuegos.R;
import com.agutierg.quizvideojuegos.constants.ConstantesParametros;
import com.agutierg.quizvideojuegos.dto.Nivel;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private List<Nivel> data;
	private static LayoutInflater inflater = null;

	public LazyAdapter(Activity a, List<Nivel> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Nivel getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView tvNombreN = (TextView) vi.findViewById(R.id.tvNombreN);
		TextView tvCompletadoN = (TextView) vi.findViewById(R.id.tvCompletadoN);
		ImageView ivPlayN = (ImageView) vi.findViewById(R.id.ivPlayN);
		ImageView ivNivel = (ImageView) vi.findViewById(R.id.ivNivel);

		Nivel nivel = new Nivel();
		nivel = data.get(position);

		// Setting all values in listview
		tvNombreN.setText(nivel.getNombreNivel());
		String porcentaje = nivel.getPorcCompletado();
		Integer real = Integer.valueOf(porcentaje);
		real = (real * 100) / 20;

		tvCompletadoN.setText(ConstantesParametros.LISTA_COMPLETADO
				+ real.toString() + ConstantesParametros.LISTA_PORCENTAJE);

		if (nivel.isDesbloqueado()) {
			ivNivel.setImageResource(vi.getResources().getIdentifier(
					nivel.getIdDrawable(), "drawable",
					vi.getContext().getPackageName()));
		} else {
			ivNivel.setImageResource(R.drawable.candado);
		}
		return vi;
	}
}
