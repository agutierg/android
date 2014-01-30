package com.agutierg.comuniopuntos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.agutierg.comuniopuntos.constants.ConsultasSQL;

public class PuntosComunioSQLite extends SQLiteOpenHelper {

	public PuntosComunioSQLite(Context contexto, String nombre,
			CursorFactory factory, int version) {
		super(contexto, nombre, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Se ejecuta la sentencia SQL de creación de las tablas
		db.execSQL(ConsultasSQL.CREATE_EQUIPO);
		db.execSQL(ConsultasSQL.CREATE_FUTBOLISTA);
		db.execSQL(ConsultasSQL.CREATE_EQUIPO_JUGADOR);
		db.execSQL(ConsultasSQL.CREATE_EQU_JUG_FUTBOLISTA);
		db.execSQL(ConsultasSQL.CREATE_PUNTOS);

		// Insertamos los datos en la tabla Equipo
		insertEquipos(db);

		// Insertamos los datos en la tabla Futbolista
		insertFutAthlectic(db);
		insertFutAtlectico(db);
		insertFutBarcelona(db);
		insertFutBetis(db);
		insertFutCelta(db);
		insertFutAlmeria(db);
		insertFutEspanol(db);
		insertFutGetafe(db);
		insertFutGranada(db);
		insertFutLevante(db);
		insertFutMalaga(db);
		insertFutElche(db);
		insertFutOsasuna(db);
		insertFutRayo(db);
		insertFutRMadrid(db);
		insertFutRSociedad(db);
		insertFutSevilla(db);
		insertFutValencia(db);
		insertFutValladolid(db);
		insertFutVillarreal(db);

		// Insertamos los nuevos tambien
		insertNewFutAthlectic(db);
		insertNewFutAthlectico(db);
		insertNewFutAlmeria(db);
		insertNewFutBarcelona(db);
		insertNewFutBetis(db);
		insertNewFutCelta(db);
		insertNewFutElche(db);
		insertNewFutEspanol(db);
		insertNewFutGetafe(db);
		insertNewFutGranada(db);
		insertNewFutLevante(db);
		insertNewFutMalaga(db);
		insertNewFutOsasuna(db);
		insertNewFutRayo(db);
		insertNewFutRMadrid(db);
		insertNewFutRSociedad(db);
		insertNewFutSevilla(db);
		insertNewFutValencia(db);
		insertNewFutValladolid(db);
		insertNewFutVillarreal(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior,
			int versionNueva) {

		if (versionAnterior == 10) {

			// Borramos
			deleteFutAthlectic(db);
			deleteFutAthlectico(db);
			deleteFutAlmeria(db);
			deleteFutBarcelona(db);
			deleteFutBetis(db);
			deleteFutCelta(db);
			deleteFutElche(db);
			deleteFutEspanol(db);
			deleteFutGetafe(db);
			deleteFutGranada(db);
			deleteFutLevante(db);
			deleteFutMalaga(db);
			deleteFutOsasuna(db);
			deleteFutRayo(db);
			deleteFutRMadrid(db);
			deleteFutRSociedad(db);
			deleteFutSevilla(db);
			deleteFutValencia(db);
			deleteFutValladolid(db);
			deleteFutVillarreal(db);
		} else {
			// Se elimina la versión anterior de la tabla
			db.execSQL("DROP TABLE IF EXISTS Equipo");
			db.execSQL("DROP TABLE IF EXISTS EquJugFutbolista");
			db.execSQL("DROP TABLE IF EXISTS EquipoJugador");
			db.execSQL("DROP TABLE IF EXISTS Futbolista");
			db.execSQL("DROP TABLE IF EXISTS Puntos");

			// Se crea la nueva versión de la tabla
			// Se ejecuta la sentencia SQL de creación de las tablas
			db.execSQL(ConsultasSQL.CREATE_EQUIPO);
			db.execSQL(ConsultasSQL.CREATE_FUTBOLISTA);
			db.execSQL(ConsultasSQL.CREATE_EQUIPO_JUGADOR);
			db.execSQL(ConsultasSQL.CREATE_EQU_JUG_FUTBOLISTA);
			db.execSQL(ConsultasSQL.CREATE_PUNTOS);

			// Insertamos los datos en la tabla Equipo
			insertEquipos(db);

			// Insertamos los datos en la tabla Futbolista
			insertFutAthlectic(db);
			insertFutAtlectico(db);
			insertFutBarcelona(db);
			insertFutBetis(db);
			insertFutCelta(db);
			insertFutAlmeria(db);
			insertFutEspanol(db);
			insertFutGetafe(db);
			insertFutGranada(db);
			insertFutLevante(db);
			insertFutMalaga(db);
			insertFutElche(db);
			insertFutOsasuna(db);
			insertFutRayo(db);
			insertFutRMadrid(db);
			insertFutRSociedad(db);
			insertFutSevilla(db);
			insertFutValencia(db);
			insertFutValladolid(db);
			insertFutVillarreal(db);
		}
		// Insertamos los nuevos tambien
		insertNewFutAthlectic(db);
		insertNewFutAthlectico(db);
		insertNewFutAlmeria(db);
		insertNewFutBarcelona(db);
		insertNewFutBetis(db);
		insertNewFutCelta(db);
		insertNewFutElche(db);
		insertNewFutEspanol(db);
		insertNewFutGetafe(db);
		insertNewFutGranada(db);
		insertNewFutLevante(db);
		insertNewFutMalaga(db);
		insertNewFutOsasuna(db);
		insertNewFutRayo(db);
		insertNewFutRMadrid(db);
		insertNewFutRSociedad(db);
		insertNewFutSevilla(db);
		insertNewFutValencia(db);
		insertNewFutValladolid(db);
		insertNewFutVillarreal(db);
	}

	/**
	 * Método que inserta los Equipos en la base de datos
	 */
	private void insertEquipos(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA);
		db.execSQL(ConsultasSQL.INSERT_BETIS);
		db.execSQL(ConsultasSQL.INSERT_CELTA);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA);
		db.execSQL(ConsultasSQL.INSERT_ESPANYOL);
		db.execSQL(ConsultasSQL.INSERT_GETAFE);
		db.execSQL(ConsultasSQL.INSERT_GRANADA);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE);
		db.execSQL(ConsultasSQL.INSERT_MALAGA);
		db.execSQL(ConsultasSQL.INSERT_ELCHE);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA);
		db.execSQL(ConsultasSQL.INSERT_RAYO);
		db.execSQL(ConsultasSQL.INSERT_REAL_MADRID);
		db.execSQL(ConsultasSQL.INSERT_REAL_SOCIEDAD);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID);
		db.execSQL(ConsultasSQL.INSERT_VILLAREAL);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: ATHLETIC
	 */
	private void insertFutAthlectic(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_IRAIZOZ);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Balenziaga);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_EKIZA);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_GURPEGI);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_IRAOLA);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_LAPORTE);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Benat);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_ANDERH);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_DEMARCOS);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_IBAI);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Erik_Moran);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_ITURRASPE);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_MIKELSJ);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_MUNIAIN);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_SUSAETA);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_ADURIZ);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Etxeita);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_GAIZKATOQ);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Herrerin);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Kike_Sola);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Saborit);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Mikel_Rico);
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Albizua);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * ATHLETIC
	 */
	private void insertNewFutAthlectic(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ATHLETIC_Guillermo_Fernandez);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: ATHLETIC
	 */
	private void deleteFutAthlectic(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: ATHLETICO
	 */
	private void insertFutAtlectico(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_ATLETICO_ADRIAN_LOPEZ);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_ARDA_TURAN);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_COURTOIS);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_CRISTIAN_RODRIGUEZ);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_DIEGO_COSTA);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_David_Villa);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_EMILIANO_INSUA);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_FILI_LUIS);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_GABI);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_GODIN);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_JUANF_TORRES);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_KADER);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_KOKE);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_MANQUILLO);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_MARIO_SUAREZ);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_MIRANDA);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_OLIV_TORRES);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_RAUL_GARCIA);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_TIAGO);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_Jose_Gimenez);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_Alderweireld);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_Guilavogui);
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_Aranzubia);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * ATHLETICO
	 */
	private void insertNewFutAthlectico(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ATLETICO_Jose_Sosa);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: ATHLETICO
	 */
	private void deleteFutAthlectico(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_ATLETICO_Leo_Baptistao);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: BARCELONA
	 */
	private void insertFutBarcelona(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_BARCELONA_Afellay);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_ADRIANO_CORR);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_ALEXIS_SAN);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_BUSQUETS);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_DANI_ALVES);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_FABREGAS);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_INIESTA);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_JONA_DOS_SANTOS);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_JORDI_ALBA);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_MARC_BARTRA);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_MASCHERANO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_MESSI);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_MONTOYA);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_OIER);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_PEDRO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_PINTO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_PIQUE);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_PUYOL);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_SERGI_ROBERTO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_SONG);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_TELLO);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_Isaac_Cuenca);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_VICTOR_VALDES);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_Neymar);
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_XAVI);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Barcelona
	 */
	private void insertNewFutBarcelona(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_BARCELONA_Adama_Traore);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Barcelona
	 */
	private void deleteFutBarcelona(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: BETIS
	 */
	private void insertFutBetis(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_BETIS_AMAYA);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Andersen);
		db.execSQL(ConsultasSQL.INSERT_BETIS_CHICA);
		db.execSQL(ConsultasSQL.INSERT_BETIS_JORGE_MOLINA);
		db.execSQL(ConsultasSQL.INSERT_BETIS_JUAN_CP);
		db.execSQL(ConsultasSQL.INSERT_BETIS_NACHO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_NONO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_NOSA);
		db.execSQL(ConsultasSQL.INSERT_BETIS_PAULAO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_PERQUIS);
		db.execSQL(ConsultasSQL.INSERT_BETIS_RUBEN_CASTRO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Braian_Rodriguez);
		db.execSQL(ConsultasSQL.INSERT_BETIS_SALVA_SEVILLA);
		db.execSQL(ConsultasSQL.INSERT_BETIS_SERGIO_ROD);
		db.execSQL(ConsultasSQL.INSERT_BETIS_VADILLO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_VILARCHAO);
		db.execSQL(ConsultasSQL.INSERT_BETIS_C_Garcia);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Cedrick);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Chuli);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Didac_Vila);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Guillermo_Sara);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Juanfran_Moreno);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Lorenzo_Reyes);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Matilla);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Verdu);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Xavi_Torres);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Jordi_Figueras);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Steinhofer);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Betis
	 */
	private void insertNewFutBetis(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_BETIS_Caro);
		db.execSQL(ConsultasSQL.INSERT_BETIS_Leo_Baptistao);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Betis
	 */
	private void deleteFutBetis(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: CELTA
	 */
	private void insertFutCelta(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_CELTA_ALEX_LOPEZ);
		db.execSQL(ConsultasSQL.INSERT_CELTA_AUGUSTO_FERNANDEZ);
		db.execSQL(ConsultasSQL.INSERT_CELTA_BELLVIS);
		db.execSQL(ConsultasSQL.INSERT_CELTA_CABRAL);
		db.execSQL(ConsultasSQL.INSERT_CELTA_ORELLANA);
		db.execSQL(ConsultasSQL.INSERT_CELTA_HUGO_MALLO);
		db.execSQL(ConsultasSQL.INSERT_CELTA_JONATHAN_VILA);
		db.execSQL(ConsultasSQL.INSERT_CELTA_JONNY);
		db.execSQL(ConsultasSQL.INSERT_CELTA_KROHN_DEHLI);
		db.execSQL(ConsultasSQL.INSERT_CELTA_MARIO_BER);
		db.execSQL(ConsultasSQL.INSERT_CELTA_OUBINA);
		db.execSQL(ConsultasSQL.INSERT_CELTA_SAMUEL_LLORCA);
		db.execSQL(ConsultasSQL.INSERT_CELTA_SERGIO_ALVAREZ);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Charles);
		db.execSQL(ConsultasSQL.INSERT_CELTA_David_Rodriguez);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Fontas);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Madinda);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Nolito);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Rafinha);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Ruben_Blanco);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Santi_Mina);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Yoel);
		db.execSQL(ConsultasSQL.INSERT_CELTA_Aurtenetxe);
		db.execSQL(ConsultasSQL.INSERT_CELTA_David_Costas);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Celta
	 */
	private void insertNewFutCelta(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_CELTA_TONI_ROD);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Celta
	 */
	private void deleteFutCelta(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_CELTA_TUNEZ);
		db.execSQL(ConsultasSQL.DELETE_CELTA_TONI_ROD);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: ALMERIA
	 */
	private void insertFutAlmeria(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Aleix_Vidal);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Azeez);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Corona);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Dubarbier);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_ESTEBAN);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Jonathan_Zongo);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_MARCELO_SILVA);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_NELSON);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Oscar_Diaz);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Pellerano);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Rafita);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Rodri);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Soriano);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Suso);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Tebar);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Trujillo);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_USTARI);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Verza);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Torsiglieri);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Kiu);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Helder_Barbosa);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Almeria
	 */
	private void insertNewFutAlmeria(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Julian);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Hans_Martinez);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Mane);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Raul_Garcia);
		db.execSQL(ConsultasSQL.INSERT_ALMERIA_Dani_Romera);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Almeria
	 */
	private void deleteFutAlmeria(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_ALMERIA_CHRI_FERN);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: ESPAÑOL
	 */
	private void insertFutEspanol(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_ESPANOL_CAPDEVILA);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_COLOTTO);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_HECTOR_MORENO);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_JAVI_LOPEZ);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_KIKO_CASILLA);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_MATTIONI);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_RAUL_ROD);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_SERGIO_GARCIA);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_SERGIO_TEJERA);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_SIMAO);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_STUANI);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_VICTOR_ALVAREZ);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_VICTOR_SANCHEZ);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Abraham_Gonzalez);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_David_Lopez);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Fuentes);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Lanzarote);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Pizzi);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Sidnei);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Thievy);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_German);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Alex_Fernandez);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Torje);
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Jhon_Cordoba);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Espanol
	 */
	private void insertNewFutEspanol(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ESPANOL_Clerc);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Espanol
	 */
	private void deleteFutEspanol(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_ESPANOL_Adrian_Luna);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: GETAFE
	 */
	private void insertFutGetafe(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_GETAFE_ALEXIS);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_BORJA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_CODINA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_COLUNGA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_DIEGO_CASTRO);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_GAVILAN);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_JUAN_ROD);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_LACEN);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_LAFITA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_LOPO);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_MICHEL_MADERA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_MOYA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_PEDRO_LEON);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_RAFA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_SARABIA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_SERGIO_ESCUDERO);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_VALERA);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_Pedro_Mosquera);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_Roberto_Lago);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_Arroyo);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_Lisandro);
		db.execSQL(ConsultasSQL.INSERT_GETAFE_Ciprian_Marica);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Getafe
	 */
	private void insertNewFutGetafe(SQLiteDatabase db) {

	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Getafe
	 */
	private void deleteFutGetafe(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: GRANADA
	 */
	private void insertFutGranada(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_GRANADA_BRAHIMI);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_BRYAN_ANGULO);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_BUONANOTTE);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_DANI_BENITEZ);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_DIAKHATE);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_EL_ARABI);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_FRAN_RICO);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_MAINZ);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_NYOM);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_ROBERTO_FERN);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_SIQUEIRA);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_YEBDA);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Coeff);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Iturra);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Jeison_Murillo);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Karnezis);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Piti);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Riki);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Alvaro_Garcia);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Fatau);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Foulquier);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Recio);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Ighalo);
		db.execSQL(ConsultasSQL.INSERT_GRANADA_M_Pereira);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Granada
	 */
	private void insertNewFutGranada(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_GRANADA_Tiago_Ilori);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Granada
	 */
	private void deleteFutGranada(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_GRANADA_Matias_Campos);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: LEVANTE
	 */
	private void insertFutLevante(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_LEVANTE_DAVID_NAVARRO);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_DIOP);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_HECTOR_RODAS);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_HIGON);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_JUANFRAN);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_KEYLOR);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_LELL);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_NIKOS);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_PEDRO_LOPEZ);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_PEDRO_RIOS);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_RUBEN_GARCIA);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_ZHAR);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_VYNTRA);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Angel_Rodriguez);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_David_Barral);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_El_Adoua);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Ivanschitz);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Javi_Jimenez);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Nong);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Pallardo);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Sergio_Pinto);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Simao_Mate);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Xumetra);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Gomis);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Jason);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Baba);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Levante
	 */
	private void insertNewFutLevante(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Nagore);
		db.execSQL(ConsultasSQL.INSERT_LEVANTE_Camarasa);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Levante
	 */
	private void deleteFutLevante(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: MALAGA
	 */
	private void insertFutMalaga(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_MALAGA_CABALLERO);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_CAMACHO);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_ELISEU);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_FABRICE);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_GAMEZ);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_KAMENI);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_DUDA);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_PORTILLO);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_SERGIO_SANCHEZ);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_WELINGTON);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_ANTUNES);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_PEDRO_MORALES);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Angeleri);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Bobley_Anderson);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Flavio_Ferreira);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Juanmi_Jimenez);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Pawlowski);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Roberto_Chen);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Santa_Cruz);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Tissone);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Samu_Garcia);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Sergi_Darder);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_El_Hamdaoui);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Malaga
	 */
	private void insertNewFutMalaga(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Casado);
		db.execSQL(ConsultasSQL.INSERT_MALAGA_Pablo_Perez);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Malaga
	 */
	private void deleteFutMalaga(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: ELCHE
	 */
	private void insertFutElche(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_ELCHE_Aaron_Niguez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Botia);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Carles_Gil);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Coro);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Carlos_Sanchez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Damian_Suarez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Domingo_Cisma);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Edu_Albacar);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Fidel);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Generelo);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Javi_Flores);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Lomban);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_M_Stevanovic);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Mantecon);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Manu_del_Moral);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Manu_Herrera);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Pelegrin);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Rivera);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Ruben_Perez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Sapunaru);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Tono);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Javi_Marquez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Alvaro_Gimenez);
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Boakye);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Elche
	 */
	private void insertNewFutElche(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_ELCHE_Cristian_Herrera);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Elche
	 */
	private void deleteFutElche(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: OSASUNA
	 */
	private void insertFutOsasuna(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_OSASUNA_ANDRES_FERNANDEZ);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_ARMENTEROS);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_ARRIBAS);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_BERTRAN);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_CEJUDO);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_DAMIA);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_DE_LAS_CUEVAS);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_FLANO);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_FRAN_SILVA);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_NINO);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_ONWU);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_PUNAL);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_RAUL_LOE);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_RIESGO);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_ROBERTO_TORRES);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_SISI);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Echaide);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Joan_Oriol);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Loties);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Maikel);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Oier);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Oriol_Riera);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Satrustegui);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Unai_Garcia);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * Osasuna
	 */
	private void insertNewFutOsasuna(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_LOLO);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Jose_Garcia);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Lobato);
		db.execSQL(ConsultasSQL.INSERT_OSASUNA_Acuna);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Osasuna
	 */
	private void deleteFutOsasuna(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_OSASUNA_Ariel_Nunez);
		db.execSQL(ConsultasSQL.DELETE_OSASUNA_LOLO);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: RAYO
	 * VALLECANO
	 */
	private void insertFutRayo(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_RAYO_ADRIAN_GONZ);
		db.execSQL(ConsultasSQL.INSERT_RAYO_ALBERTO_PEREA);
		db.execSQL(ConsultasSQL.INSERT_RAYO_ARBILLA);
		db.execSQL(ConsultasSQL.INSERT_RAYO_COBENO);
		db.execSQL(ConsultasSQL.INSERT_RAYO_GALVEZ);
		db.execSQL(ConsultasSQL.INSERT_RAYO_JOSE_CARLOS);
		db.execSQL(ConsultasSQL.INSERT_RAYO_LASS);
		db.execSQL(ConsultasSQL.INSERT_RAYO_NACHO_MARTINEZ);
		db.execSQL(ConsultasSQL.INSERT_RAYO_RODRIGUEZ);
		db.execSQL(ConsultasSQL.INSERT_RAYO_RUBEN_MARTINEZ);
		db.execSQL(ConsultasSQL.INSERT_RAYO_RUBEN_RAMIRO);
		db.execSQL(ConsultasSQL.INSERT_RAYO_TITO);
		db.execSQL(ConsultasSQL.INSERT_RAYO_TRASHORRAS);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Baena);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Bueno);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Galeano);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Johan_Mojica);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Larrivey);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Nery_Castillo);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Saul_Niguez);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Christian_Cueva);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Iago_Falque);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Sebastian_Fernandez);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Ze_Castro);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Jonathan_Viera);
		db.execSQL(ConsultasSQL.INSERT_RAYO_Embarba);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del: Rayo
	 */
	private void insertNewFutRayo(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_RAYO_Rochina);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: Rayo
	 */
	private void deleteFutRayo(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: REAL MADRID
	 * 
	 */
	private void insertFutRMadrid(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_RMADRID_ARBELOA);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_BENZEMA);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_CASILLAS);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_COENTRAO);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_CRISTIANO);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_DI_MARIA);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_DIEGO_LOPEZ);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_JESE);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_KHEDIRA);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_MARCELO);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_MODRIC);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_MORATA);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_NACHO_FERNANDEZ);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_PEPE);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_SERGIO_RAMOS);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_VARANE);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_XAVI_ALONSO);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Carvajal);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Casemiro);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Diego_Llorente);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Illarramendi);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Isco);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Jesus_Fernandez);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Omar_Mascarell);
		db.execSQL(ConsultasSQL.INSERT_RMADRID_Bale);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * RMadrid
	 */
	private void insertNewFutRMadrid(SQLiteDatabase db) {

	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: RMadrid
	 */
	private void deleteFutRMadrid(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: REAL SOCIEDAD
	 * 
	 */
	private void insertFutRSociedad(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_AGIRRETXE);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_ANSOTEGI);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_BERGARA);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_BRAVO);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_CADAMURO);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_CARLOS_MARTINEZ);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_CHORY);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_DE_LA_BELLA);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_ELUSTONDO);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_ESTRADA);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_GRIEZMANN);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_IFRAN);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_INIGO_MARTINEZ);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_JAVI_ROS);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_JOSE_ANGEL);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_MIKEL_GONZALEZ);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_RUBEN_PARDO);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_VELA);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_XABI_PRIETO);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_ZUBIKARAI);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_ZURUTUZA);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_Seferovic);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_Granero);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_Gaztanaga);
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_Sangalli);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * RSociedad
	 */
	private void insertNewFutRSociedad(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_RSOCIEDAD_Zaldua);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: RSociedad
	 */
	private void deleteFutRSociedad(SQLiteDatabase db) {

	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: SEVILLA
	 * 
	 */
	private void insertFutSevilla(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_SEVILLA_ALEX_RUBIO);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_BETO);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_CALA);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_COKE);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_FAZIO);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_FERNANDO_NAV);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_JULIAN);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_PEROTTI);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_RABELLO);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_RAKITIC);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_REYES);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_TROCHOWSKI);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Alberto_Moreno);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Bacca);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Carrico);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Cristoforo);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Diogo_Figueiras);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Gameiro);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Israel_Puerto);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Jairo);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Marko_Marin);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Nico_Pareja);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Vitolo);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Javi_Varas);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_CICINHO);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Iborra);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_MBia);
		db.execSQL(ConsultasSQL.INSERT_SEVILLA_Denis_Cheryshev);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * SEVILLA
	 */
	private void insertNewFutSevilla(SQLiteDatabase db) {

	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: SEVILLA
	 */
	private void deleteFutSevilla(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_SEVILLA_Rusescu);
		db.execSQL(ConsultasSQL.DELETE_SEVILLA_MADURO);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: VALENCIA
	 * 
	 */
	private void insertFutValencia(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_VALENCIA_BANEGA);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_BARRAGAN);

		db.execSQL(ConsultasSQL.INSERT_VALENCIA_CANALES);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_DIEGO_ALVES);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_FEGHOULI);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_GUAITA);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_GUARDADO);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_JOAO);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_JONAS);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_MATHIEU);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_PAREJO);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_PIATTI);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_RICARDO_COSTA);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_VICTOR_RUIZ);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Alcacer);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Fede_Cartabia);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Helder_Postiga);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Javi_Fuego);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Michel_Herrero);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Oriol_Romeu);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Pabon);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * VALENCIA
	 */
	private void insertNewFutValencia(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_BERNAT);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Ruben_Vezo);
		db.execSQL(ConsultasSQL.INSERT_VALENCIA_Eduardo_Vargas);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: VALENCIA
	 */
	private void deleteFutValencia(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_VALENCIA_RAMI);
		db.execSQL(ConsultasSQL.DELETE_VALENCIA_BERNAT);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: VALLADOLID
	 * 
	 */
	private void insertFutValladolid(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_ALVARO_RUBIO);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_BARAJA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_CARLOS_PENA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_EBERT);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_GUERRA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_JAIME);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_LARSSON);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_LLUIS_SASTRE);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_MANUCHO);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_MARC_VALIENTE);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_OMAR);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_OSCAR);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_RUEDA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_RUKAVINA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_VICTOR_PEREZ);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_VALDET_RAMA);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Diego_Marino);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Gilberto_Garcia);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Heinz);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Osorio);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Fausto_Rossi);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * VALLADOLID
	 */
	private void insertNewFutValladolid(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Bergdich);
		db.execSQL(ConsultasSQL.INSERT_VALLADOLID_Mitrovic);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: VALLADOLID
	 */
	private void deleteFutValladolid(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.DELETE_VALLADOLID_Bergdich);
	}

	/**
	 * Método que inserta los Futbolistas en la base de datos del: VILLARREAL
	 * 
	 */
	private void insertFutVillarreal(SQLiteDatabase db) {

		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Bruno_Soriano);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Cani);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Giovani);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Hernan_Perez);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Jaume_Costa);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Javier_Aquino);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Jokic);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Jonathan_Pereira);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Juan_Carlos);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Mario_Gaspar);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Moi_Gomez);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Musacchio);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Pablo_Iniguez);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Pantic);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Farinos);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Perbet);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Sergio_Asenjo);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Tomas_Pina);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Trigueros);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Uche);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Gabriel_Paulista);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Dorado);
	}

	/**
	 * Método que inserta los NUEVOS Futbolistas en la base de datos del:
	 * VILLARREAL
	 */
	private void insertNewFutVillarreal(SQLiteDatabase db) {
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Edu_Ramos);
		db.execSQL(ConsultasSQL.INSERT_VILLARREAL_Nahuel);
	}

	/**
	 * Método que borra los Futbolistas en la base de datos del: VILLARREAL
	 */
	private void deleteFutVillarreal(SQLiteDatabase db) {

	}
}
