package com.agutierg.hits2013.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.agutierg.hits2013.constants.ConsultasSQL;

public class Temazos2013SQLite extends SQLiteOpenHelper {

	public Temazos2013SQLite(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// Se ejecuta la sentencia SQL de creación de las tablas
		db.execSQL(ConsultasSQL.CREATE_TABLA_CANCIONES);

		// Insertamos los datos en la tabla Cancion
		// insertCancionesFreaks(db);
		// insertCanciones(db);
		// insertCancionesNew(db);
		// insertCancionesLatin(db);
	}

	/**
	 * 
	 * Inserts de los Freaks
	 */
	private void insertCancionesFreaks(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_CHIP_TORRES);
		db.execSQL(ConsultasSQL.INSERT_CANCION_COBRA_TAKA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_GALLO_KENTUCKY);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PETER_ANGUILA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PIO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PSY);
		db.execSQL(ConsultasSQL.INSERT_CANCION_RAFA_MORA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_SOY_CANI);
		db.execSQL(ConsultasSQL.INSERT_CANCION_CACHICHURRIS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_COMO_SE_MATA_GUSANO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_CRL_ALT);
		db.execSQL(ConsultasSQL.INSERT_CANCION_KO);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LA_VACA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_MAZORKA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_OLA_KASE);
		db.execSQL(ConsultasSQL.INSERT_CANCION_PAJEA);
		db.execSQL(ConsultasSQL.INSERT_CANCION_SANTA_CLAUS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_TOCAME_EL_WINDOWS);
		db.execSQL(ConsultasSQL.INSERT_CANCION_UN_BYTE);
	}

	/**
	 * 
	 * Inserts de las Canciones
	 */
	private void insertCanciones(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_22);
		db.execSQL(ConsultasSQL.INSERT_CANCION_23);
		db.execSQL(ConsultasSQL.INSERT_CANCION_24);
		db.execSQL(ConsultasSQL.INSERT_CANCION_25);
		db.execSQL(ConsultasSQL.INSERT_CANCION_26);
		db.execSQL(ConsultasSQL.INSERT_CANCION_27);
		db.execSQL(ConsultasSQL.INSERT_CANCION_28);
		db.execSQL(ConsultasSQL.INSERT_CANCION_29);
		db.execSQL(ConsultasSQL.INSERT_CANCION_30);
		db.execSQL(ConsultasSQL.INSERT_CANCION_31);
		db.execSQL(ConsultasSQL.INSERT_CANCION_32);
	}

	/**
	 * 
	 * Inserts de las Canciones Nuevas
	 */
	private void insertCancionesNew(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_NEW_22);

	}

	/**
	 * 
	 * Inserts de las Canciones Nuevas
	 */
	private void insertCancionesLatin(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_1);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_2);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_3);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_4);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_5);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_6);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_7);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_8);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_9);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_10);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_11);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_12);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_13);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_14);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_15);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_16);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_17);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_18);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_19);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_20);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_21);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_22);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_23);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_24);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_25);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_26);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_27);
		db.execSQL(ConsultasSQL.INSERT_CANCION_LAT_28);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Se elimina la versión anterior de la tabla
		db.execSQL("DROP TABLE IF EXISTS Cancion");

		// Se crea la nueva versión de la tabla

		db.execSQL(ConsultasSQL.CREATE_TABLA_CANCIONES);

		// Insertamos los datos en la tabla Cancion
		// insertCancionesFreaks(db);
		// insertCanciones(db);
		// insertCancionesNew(db);
		// insertCancionesLatin(db);
	}

}
