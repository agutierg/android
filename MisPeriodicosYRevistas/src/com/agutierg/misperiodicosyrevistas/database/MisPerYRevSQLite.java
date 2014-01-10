package com.agutierg.misperiodicosyrevistas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.agutierg.misperiodicosyrevistas.constants.ConsultasSQL;

public class MisPerYRevSQLite extends SQLiteOpenHelper {

	public MisPerYRevSQLite(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// Se ejecuta la sentencia SQL de creación de las tablas
		db.execSQL(ConsultasSQL.CREATE_TABLA_PUBLICACION);

		// Insertamos los datos en la tabla Publicacion
		// PERIODICOS
		insertPeriodicos(db);

		// Insertamos los datos en la tabla Publicacion
		// PERIODICOS DEPORTIVOS
		insertPeriodicosDeportivos(db);

		// Insertamos los datos en la tabla Publicacion
		// REVISTAS CORAZON
		insertRevistasCorazon(db);

		// Insertamos los datos en la tabla Publicacion
		// REVISTAS
		insertRevistas(db);

		// Insertamos los datos en la tabla Publicacion
		// REVISTAS CIENTIFICAS
		insertRevistasCientificas(db);

		// Insertamos los datos en la tabla Publicacion
		// PRENSA EXTRANJERA
		insertPrensaExtranjera(db);

	}

	/**
	 * 
	 * Inserts de los Periodicos
	 */
	private void insertPeriodicos(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_PERIODICO_VILA_WEB);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_20_MINUTOS);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_QUE);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_ABC);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_ALTO_ARAGON);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_ATLANTICO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_CANARIAS_7);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEIA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DIARIO_DE_SEVILLA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DIARIO_MONTANES);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DIARIO_VASCO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_COMERCIO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_CORREO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_MUNDO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_PAIS);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_PERIODICO_CAT);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_PERIODICO_COM);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_PERIODICO_EXTREMADURA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_PUNT_AVUI);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_FARO_DE_VIGO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_HERALDO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_GACETA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_NUEVA_ESPANA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_RAZON);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_REGION);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_VANGUARDIA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_VANGUARDIA_CAT);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LA_VOZ_DE_GALICIA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_LEVANTE);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_MEDITERRANEO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_PERIODICO_ARAGON);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EXPANSION);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_EL_ECONOMISTA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_CINCO_DIAS);
	}

	/**
	 * 
	 * Inserts de los Periodicos
	 */
	private void insertPeriodicosDeportivos(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_AS);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_CANAL_DEPORTIVO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_ESTADO_DEPORTIVO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_MARCA);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_MUNDO_ATLETIC);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_MUNDO_ATLETICO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_MUNDO_DEPORTIVO);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_MUNDO_REAL_SOCIEDAD);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_SPORT);
		db.execSQL(ConsultasSQL.INSERT_PERIODICO_DEPORTIVO_SUPERDEPORTE);
	}

	/**
	 * 
	 * Inserts de las Revistas Corazon
	 */
	private void insertRevistasCorazon(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_AR);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_COSMOPOLITAN);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_CUORE);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_DIEZ_MINUTOS);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_ELLE);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_HOLA);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_LOVE);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_MARIE_CLAIRE);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_SALVAME);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_SEMANA);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_SUPER_POP);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CORAZON_VOGUE);
	}

	/**
	 * 
	 * Inserts de las Revistas
	 */
	private void insertRevistas(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_REVISTA_ACTUALIDAD_ECONOMICA);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CASA_CAMPO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CASA_DIEZ);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CASA_ESTILO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CLIO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CRECER_FELIZ);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_WINDSURF);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_VIDA_PREMIUM);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_VAVEL);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_SOHO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_SER_PADRES);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_NUEVO_ESTILO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_MI_CASA);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_MAXWELL);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_INTERVIEW);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_GQ);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_FUTBOL_TOTAL);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_FHM);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_EMPRENDEDORES);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_ELLE_DECOR);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_EL_RELLANO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_EL_JUEVES);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_DISENO_INTERIOR);

	}

	/**
	 * 
	 * Inserts de las Revistas Cientificas
	 */
	private void insertRevistasCientificas(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CIENTIFICA_COMPUTING);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CIENTIFICA_MUNDO_GEO);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CIENTIFICA_MUY_INTERESANTE);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CIENTIFICA_PC_WORLD);
		db.execSQL(ConsultasSQL.INSERT_REVISTA_CIENTIFICA_QUO);
	}

	/**
	 * 
	 * Inserts de las Revistas Cientificas
	 */
	private void insertPrensaExtranjera(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_CNN);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_CORRIERE);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_COURRIER_PICARD);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_DIA_EL_PAIS);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_EL_DIARIO);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_EL_PERIODICO_MEX);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_EL_TIEMPO);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_EL_UNI_VENEZUELA);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_EL_UNIVERSAL);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_JAPAN_TIMES);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_LA_NACION);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_LA_NACION_PA);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_LA_REPUBLICA);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_LE_MONDE);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_MORGEN_POST);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_O_GLOBO);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_TGAM);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_THE_INDEPENDENT);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_THE_SUN);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_THE_TELEGRAPH);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_THE_TIMES);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_THE_TIMES_INDIA);
		db.execSQL(ConsultasSQL.INSERT_PRENSA_EXT_WASHINGTON);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
