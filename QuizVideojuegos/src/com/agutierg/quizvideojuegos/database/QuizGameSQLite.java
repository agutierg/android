package com.agutierg.quizvideojuegos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.agutierg.quizvideojuegos.constants.ConsultasSQL;

public class QuizGameSQLite extends SQLiteOpenHelper {

	public QuizGameSQLite(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// Se ejecuta la sentencia SQL de creación de las tablas
		db.execSQL(ConsultasSQL.CREATE_TABLA_NIVEL);
		db.execSQL(ConsultasSQL.CREATE_TABLA_JUEGO);
		db.execSQL(ConsultasSQL.CREATE_TABLA_JUGADOR);

		// Insertamos los niveles
		insertNiveles(db);

		// Insertamos los juegos del primer nivel
		insertJuegos1(db);
		insertJuegos2(db);
		insertJuegos3(db);
		insertJuegos4(db);
		insertJuegos5(db);
		insertJuegos6(db);
		insertJuegos7(db);
		insertJuegos8(db);
		insertJuegos9(db);
		insertJuegos10(db);
	}

	private void insertJuegos1(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_1_20);
	}

	private void insertJuegos2(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_2_20);
	}

	private void insertJuegos3(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_3_20);
	}

	private void insertJuegos4(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_4_20);
	}

	private void insertJuegos5(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_5_20);
	}

	private void insertJuegos6(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_6_20);
	}

	private void insertJuegos7(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_7_20);
	}

	private void insertJuegos8(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_8_20);
	}

	private void insertJuegos9(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_9_20);
	}

	private void insertJuegos10(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_1);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_2);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_3);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_4);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_5);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_6);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_7);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_8);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_9);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_10);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_11);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_12);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_13);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_14);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_15);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_16);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_17);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_18);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_19);
		db.execSQL(ConsultasSQL.INSERT_JUEGO_NIVEL_10_20);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL(ConsultasSQL.CREATE_TABLA_JUGADOR);
	}

	/**
	 * Método que inserta los Equipos en la base de datos
	 */
	private void insertNiveles(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_NIVEL_1);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_2);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_3);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_4);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_5);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_6);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_7);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_8);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_9);
		db.execSQL(ConsultasSQL.INSERT_NIVEL_10);
	}
}
