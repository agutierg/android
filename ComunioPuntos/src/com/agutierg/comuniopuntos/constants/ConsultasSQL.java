package com.agutierg.comuniopuntos.constants;

public class ConsultasSQL {

	// Tablas de la base de datos
	public static final String CREATE_EQU_JUG_FUTBOLISTA = "CREATE TABLE [EquJugFutbolista] ([equJugFutId] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,[equJugId] INTEGER  NOT NULL REFERENCES EquipoJugador(equJugId) ON DELETE CASCADE,[futbolistaId] INTEGER  NOT NULL REFERENCES Futbolista(futId) ON DELETE CASCADE)";
	public static final String CREATE_EQUIPO = "CREATE TABLE [Equipo] ([equId] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,[nombreEqu] VARCHAR(255)  NOT NULL,[aliasEqu] VARCHAR(255)  NOT NULL)";
	public static final String CREATE_EQUIPO_JUGADOR = "CREATE TABLE [EquipoJugador] ([equJugId] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,[nombreEJ] VARCHAR(255)  UNIQUE NOT NULL,[valorEJ] INTEGER  NULL)";
	public static final String CREATE_FUTBOLISTA = "CREATE TABLE [Futbolista] ([futId] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,[nombreFut] VARCHAR(255)  NOT NULL,[estadoFut] INTEGER  NULL,[equipoFut] INTEGER  NOT NULL REFERENCES Equipo(equId) ON DELETE CASCADE,[valorFut] VARCHAR(255)  NULL,[posFut] VARCHAR(255)  NOT NULL)";
	public static final String CREATE_PUNTOS = "CREATE TABLE [Puntos] ([puntosId] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,[futId] INTEGER  NOT NULL REFERENCES Futbolista(futId) ON DELETE CASCADE,[puntosFut] VARCHAR(255)  NOT NULL,[jornada] INTEGER  NOT NULL,[fechaInsert] DATE DEFAULT CURRENT_DATE NOT NULL)";

	// Inserts en la tabla equipos de Futbol
	public static final String INSERT_ATHLETIC = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Athletic de Bilbao', '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "')";
	public static final String INSERT_ATLETICO = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Atletico de Madrid', '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "')";
	public static final String INSERT_BARCELONA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Barcelona', '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "')";
	public static final String INSERT_BETIS = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Betis', '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "')";
	public static final String INSERT_CELTA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Celta', '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "')";
	public static final String INSERT_ESPANYOL = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Español', '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "')";
	public static final String INSERT_GETAFE = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Getafe', '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "')";
	public static final String INSERT_GRANADA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Granada', '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "')";
	public static final String INSERT_LEVANTE = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Levante', '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "')";
	public static final String INSERT_MALAGA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Málaga', '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "')";
	public static final String INSERT_OSASUNA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Osasuna', '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "')";
	public static final String INSERT_RAYO = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Rayo Vallecano', '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "')";
	public static final String INSERT_REAL_MADRID = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Real Madrid', '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "')";
	public static final String INSERT_REAL_SOCIEDAD = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Real Sociedad', '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "')";
	public static final String INSERT_SEVILLA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Sevilla', '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "')";
	public static final String INSERT_VALENCIA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Valencia', '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "')";
	public static final String INSERT_VALLADOLID = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Valladolid', '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID + "')";
	public static final String INSERT_ALMERIA = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Almería', '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "')";
	public static final String INSERT_ELCHE = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Elche', '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "')";
	public static final String INSERT_VILLAREAL = "INSERT INTO Equipo (nombreEqu,aliasEqu) VALUES ('Villarreal', '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL + "')";

	// Inserts en la tabla Futbolista para el ATHLETIC DE BILBAO
	public static final String INSERT_ATHLETIC_IRAIZOZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iraizoz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','POR')";
	public static final String INSERT_ATHLETIC_Herrerin = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Herrerín',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','POR')";
	public static final String INSERT_ATHLETIC_Albizua = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Albizua',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_Balenziaga = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Balenziaga',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_EKIZA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ekiza',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_Etxeita = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Etxeita',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_GURPEGI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gurpegi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_IRAOLA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iraola',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_LAPORTE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Laporte',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_MIKELSJ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mikel San José',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_Saborit = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Saborit',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEF')";
	public static final String INSERT_ATHLETIC_ANDERH = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ander Herrera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_Benat = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Beñat',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_DEMARCOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('De Marcos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_Erik_Moran = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Erik Morán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_IBAI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ibai Gómez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_ITURRASPE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iturraspe',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_Mikel_Rico = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mikel Rico',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_MUNIAIN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Muniain',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_SUSAETA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Susaeta',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','CEN')";
	public static final String INSERT_ATHLETIC_ADURIZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Aduriz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEL')";
	public static final String INSERT_ATHLETIC_Kike_Sola = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Kike Sola',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEL')";
	public static final String INSERT_ATHLETIC_GAIZKATOQ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gaizka Toquero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEL')";

	public static final String INSERT_ATHLETIC_Guillermo_Fernandez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Guillermo Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATHLETIC + "'),'500.000','DEL')";

	public static final String DELETE_ATHLETIC_RAMALHO = "DELETE FROM Futbolista WHERE nombreFut = 'Ramalho'";
	public static final String DELETE_ATHLETIC_RUIZDG = "DELETE FROM Futbolista WHERE nombreFut = 'Ruiz de Galarreta'";
	public static final String DELETE_ATHLETIC_AURTENETXE = "DELETE FROM Futbolista WHERE nombreFut = 'Aurtenetxe'";
	public static final String DELETE_ATHLETIC_INIGOPER = "DELETE FROM Futbolista WHERE nombreFut = 'Iñigo Pérez'";

	// Inserts en la tabla Futbolista para el ATLETICO DE MADRID
	public static final String INSERT_ATLETICO_Aranzubia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Aranzubia',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','POR')";
	public static final String INSERT_ATLETICO_COURTOIS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Courtois',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','POR')";
	public static final String INSERT_ATLETICO_Alderweireld = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alderweireld',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_EMILIANO_INSUA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Emiliano Insúa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_FILI_LUIS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Filipe Luis',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_GODIN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Godín',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_Jose_Gimenez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('José Giménez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_JUANF_TORRES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juanfran Torres',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_MANQUILLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('manquillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_MIRANDA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Miranda',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEF')";
	public static final String INSERT_ATLETICO_ARDA_TURAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Arda Turan',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_CRISTIAN_RODRIGUEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cristian Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_GABI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gabi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_Jose_Sosa = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('José Sosa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_KADER = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Kader',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_KOKE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Koke',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_MARIO_SUAREZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mario Suárez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_RAUL_GARCIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Raúl García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_TIAGO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tiago',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";
	public static final String INSERT_ATLETICO_ADRIAN_LOPEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adrián López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEL')";
	public static final String INSERT_ATLETICO_DIEGO_COSTA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego Costa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEL')";
	public static final String INSERT_ATLETICO_David_Villa = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('David Villa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','DEL')";

	public static final String INSERT_ATLETICO_Diego = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ATLETICO + "'),'500.000','CEN')";

	public static final String DELETE_ATLETICO_OLIV_TORRES = "DELETE FROM Futbolista WHERE nombreFut = 'Óliver Torres'";
	public static final String DELETE_ATLETICO_Guilavogui = "DELETE FROM Futbolista WHERE nombreFut = 'Guilavogui'";

	// Inserts en la tabla Futbolista para el BARCELONA
	public static final String INSERT_BARCELONA_OIER = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Oier Olazábal',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','POR')";
	public static final String INSERT_BARCELONA_PINTO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pinto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','POR')";
	public static final String INSERT_BARCELONA_VICTOR_VALDES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Valdés',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','POR')";
	public static final String INSERT_BARCELONA_ADRIANO_CORR = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adriano Correia',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_DANI_ALVES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dani Alves',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_JORDI_ALBA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jordi Alba',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_MARC_BARTRA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marc Bartra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_MONTOYA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Martín Montoya',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_MASCHERANO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mascherano',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_PIQUE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Piqué',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_PUYOL = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Puyol',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEF')";
	public static final String INSERT_BARCELONA_Afellay = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Afellay',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_SONG = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alex Song',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_FABREGAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cesc Fàbregas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_INIESTA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iniesta',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_JONA_DOS_SANTOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonathan dos Santos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_SERGI_ROBERTO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergi Roberto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_BUSQUETS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Busquets',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_XAVI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Xavi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','CEN')";
	public static final String INSERT_BARCELONA_ALEXIS_SAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alexis Sánchez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_Neymar = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Neymar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_MESSI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Messi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_PEDRO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_TELLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tello',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_Isaac_Cuenca = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Isaac Cuenca',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";
	public static final String INSERT_BARCELONA_Adama_Traore = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adama Traore',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BARCELONA + "'),'500.000','DEL')";

	// Inserts en la tabla Futbolista para el BETIS
	public static final String INSERT_BETIS_Andersen = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Andersen',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','POR')";
	public static final String INSERT_BETIS_Guillermo_Sara = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Guillermo Sara',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','POR')";
	public static final String INSERT_BETIS_AMAYA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Antonio Amaya',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_Caro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Caro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_CHICA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Chica',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_Didac_Vila = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dídac Vilà',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_Jordi_Figueras = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jordi Figueras',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_NACHO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nacho',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_PAULAO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Paulão',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_PERQUIS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Perquis',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";
	public static final String INSERT_BETIS_C_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('C.García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Cedrick = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cedrick',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_JUAN_CP = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juan Carlos Pérez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Juanfran_Moreno = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juanfran Moreno',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Lorenzo_Reyes = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lorenzo Reyes',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Matilla = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Matilla',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_NONO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nono',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_NOSA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nosa Igiebor',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_SALVA_SEVILLA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Salva Sevilla',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_VADILLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Vadillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Verdu = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Verdú',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_VILARCHAO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Vilarchao',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Xavi_Torres = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Xavi Torres',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','CEN')";
	public static final String INSERT_BETIS_Braian_Rodriguez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Braian Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEL')";
	public static final String INSERT_BETIS_Chuli = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Chuli',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEL')";
	public static final String INSERT_BETIS_JORGE_MOLINA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jorge Molina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEL')";
	public static final String INSERT_BETIS_Leo_Baptistao = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Leo Baptistão',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEL')";
	public static final String INSERT_BETIS_RUBEN_CASTRO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Castro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEL')";

	public static final String INSERT_BETIS_Adan = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','POR')";
	public static final String INSERT_BETIS_Alfred_NDiaye = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alfred NDiaye',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_BETIS + "'),'500.000','DEF')";

	public static final String DELETE_BETIS_Steinhofer = "DELETE FROM Futbolista WHERE nombreFut = 'Steinhöfer'";
	public static final String DELETE_BETIS_SERGIO_ROD = "DELETE FROM Futbolista WHERE nombreFut = 'Sergio Rodríguez'";

	// Inserts en la tabla Futbolista para el CELTA
	public static final String INSERT_CELTA_Ruben_Blanco = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Blanco',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','POR')";
	public static final String INSERT_CELTA_SERGIO_ALVAREZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Álvarez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','POR')";
	public static final String INSERT_CELTA_Yoel = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Yoel',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','POR')";
	public static final String INSERT_CELTA_Aurtenetxe = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Aurtenetxe',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_CABRAL = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cabral',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_David_Costas = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('David Costas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_Fontas = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fontás',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_HUGO_MALLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Hugo Mallo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_JONNY = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonny',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_TONI_ROD = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Toni Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_ALEX_LOPEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álex López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_AUGUSTO_FERNANDEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Augusto Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_KROHN_DEHLI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Krohn-Dehli',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_Madinda = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Madinda',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_ORELLANA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Orellana',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_OUBINA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Oubiña',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_Rafinha = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rafinha',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','CEN')";
	public static final String INSERT_CELTA_Charles = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Charles',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEL')";
	public static final String INSERT_CELTA_MARIO_BER = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mario Bermejo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEL')";
	public static final String INSERT_CELTA_Nolito = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nolito',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEL')";
	public static final String INSERT_CELTA_Santi_Mina = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Santi Mina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEL')";

	public static final String INSERT_CELTA_Inigo_Lopez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Íñigo López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEF')";
	public static final String INSERT_CELTA_Welliton = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Welliton',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_CELTA + "'),'500.000','DEL')";

	public static final String DELETE_CELTA_BELLVIS = "DELETE FROM Futbolista WHERE nombreFut = 'Bellvís'";
	public static final String DELETE_CELTA_JONATHAN_VILA = "DELETE FROM Futbolista WHERE nombreFut = 'Jonathan Vila'";
	public static final String DELETE_CELTA_SAMUEL_LLORCA = "DELETE FROM Futbolista WHERE nombreFut = 'Samuel Llorca'";
	public static final String DELETE_CELTA_David_Rodriguez = "DELETE FROM Futbolista WHERE nombreFut = 'David Rodríguez'";

	// Inserts en la tabla Futbolista para el ALMERIA
	public static final String INSERT_ALMERIA_ESTEBAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Esteban',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','POR')";
	public static final String INSERT_ALMERIA_Julian = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Julián',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','POR')";
	public static final String INSERT_ALMERIA_Dubarbier = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dubarbier',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Hans_Martinez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Hans Martínez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Mane = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mané',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_MARCELO_SILVA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marcelo Silva',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_NELSON = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nelson',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Rafita = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rafita',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Torsiglieri = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Torsiglieri',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Trujillo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Trujillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";
	public static final String INSERT_ALMERIA_Aleix_Vidal = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Aleix Vidal',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Azeez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Azeez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Corona = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Corona',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Helder_Barbosa = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Hélder Barbosa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Jonathan_Zongo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonathan Zongo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Kiu = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Kiu',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Soriano = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Soriano',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Suso = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Suso',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Tebar = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tébar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Verza = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Verza',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','CEN')";
	public static final String INSERT_ALMERIA_Oscar_Diaz = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Óscar Díaz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEL')";
	public static final String INSERT_ALMERIA_Dani_Romera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dani Romera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEL')";
	public static final String INSERT_ALMERIA_Rodri = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rodri',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEL')";

	public static final String INSERT_ALMERIA_Raul_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Raúl García Carnero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ALMERIA + "'),'500.000','DEF')";

	public static final String DELETE_ALMERIA_USTARI = "DELETE FROM Futbolista WHERE nombreFut = 'Ustari'";
	public static final String DELETE_ALMERIA_Pellerano = "DELETE FROM Futbolista WHERE nombreFut = 'Pellerano'";

	// Inserts en la tabla Futbolista para el ESPAÑOL
	public static final String INSERT_ESPANOL_German = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Germán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','POR')";
	public static final String INSERT_ESPANOL_KIKO_CASILLA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Kiko Casilla',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','POR')";
	public static final String INSERT_ESPANOL_CAPDEVILA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Capdevila',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_COLOTTO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Colotto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_MATTIONI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Felipe Mattioni',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_Fuentes = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fuentes',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_HECTOR_MORENO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Héctor Moreno',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_JAVI_LOPEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javier López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_RAUL_ROD = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Raúl Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_Sidnei = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sidnei',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_VICTOR_ALVAREZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Álvarez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEF')";
	public static final String INSERT_ESPANOL_Alex_Fernandez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álex Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_Abraham_Gonzalez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Abraham González',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_David_Lopez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('David López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_Lanzarote = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lanzarote',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_SIMAO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Simão',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_VICTOR_SANCHEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Sánchez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','CEN')";
	public static final String INSERT_ESPANOL_Jhon_Cordoba = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jhon Córdoba',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEL')";
	public static final String INSERT_ESPANOL_Pizzi = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pizzi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEL')";
	public static final String INSERT_ESPANOL_SERGIO_GARCIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEL')";
	public static final String INSERT_ESPANOL_STUANI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Stuani',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEL')";
	public static final String INSERT_ESPANOL_Torje = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Torje',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ESPANOL + "'),'500.000','DEL')";

	public static final String DELETE_ESPANOL_SERGIO_TEJERA = "DELETE FROM Futbolista WHERE nombreFut = 'Sergio Tejera'";
	public static final String DELETE_ESPANOL_Thievy = "DELETE FROM Futbolista WHERE nombreFut = 'Thievy'";
	public static final String DELETE_ESPANOL_Clerc = "DELETE FROM Futbolista WHERE nombreFut = 'Clerc'";

	// Inserts en la tabla Futbolista para el GETAFE
	public static final String INSERT_GETAFE_CODINA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Codina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','POR')";
	public static final String INSERT_GETAFE_MOYA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Moyà',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','POR')";
	public static final String INSERT_GETAFE_ALEXIS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alexis',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_Arroyo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Arroyo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_Lisandro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lisandro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_RAFA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rafa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_Roberto_Lago = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Roberto Lago',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_SERGIO_ESCUDERO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Escudero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_VALERA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Valera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEF')";
	public static final String INSERT_GETAFE_BORJA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Borja',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_DIEGO_CASTRO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego Castro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_GAVILAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gavilán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_JUAN_ROD = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juan Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_LACEN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lacen',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_LAFITA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lafita',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_MICHEL_MADERA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Michel Madera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_PEDRO_LEON = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro León',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_Pedro_Mosquera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro Mosquera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_SARABIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sarabia',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";
	public static final String INSERT_GETAFE_COLUNGA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adrián Colunga',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEL')";
	public static final String INSERT_GETAFE_Ciprian_Marica = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ciprian Marica',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','DEL')";

	public static final String INSERT_GETAFE_Sammir = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sammir',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GETAFE + "'),'500.000','CEN')";

	public static final String DELETE_GETAFE_LOPO = "DELETE FROM Futbolista WHERE nombreFut = 'Lopo'";

	// Inserts en la tabla Futbolista para el GRANADA
	public static final String INSERT_GRANADA_ROBERTO_FERN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Roberto Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','POR')";
	public static final String INSERT_GRANADA_Karnezis = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Karnezis',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','POR')";
	public static final String INSERT_GRANADA_BRYAN_ANGULO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Brayan Angulo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_Coeff = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Coeff',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_DIAKHATE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diakhaté',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_Foulquier = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Foulquier',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_Jeison_Murillo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jeison Murillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_MAINZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mainz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_NYOM = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nyom',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_Tiago_Ilori = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tiago Ilori',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEF')";
	public static final String INSERT_GRANADA_Alvaro_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álvaro García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_BRAHIMI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Brahimi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_BUONANOTTE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Buonanotte',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_DANI_BENITEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dani Benítez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_Fatau = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fatau',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_FRAN_RICO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fran Rico',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_Iturra = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iturra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_M_Pereira = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('M. Pereira',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_Piti = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Piti',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_Recio = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Recio',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','CEN')";
	public static final String INSERT_GRANADA_EL_ARABI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('El-Arabi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEL')";
	public static final String INSERT_GRANADA_Ighalo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ighalo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEL')";
	public static final String INSERT_GRANADA_Riki = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Riki',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_GRANADA + "'),'500.000','DEL')";

	public static final String DELETE_GRANADA_SIQUEIRA = "DELETE FROM Futbolista WHERE nombreFut = 'Siqueira'";
	public static final String DELETE_GRANADA_YEBDA = "DELETE FROM Futbolista WHERE nombreFut = 'Yebda'";

	// Inserts en la tabla Futbolista para el LEVANTE
	public static final String INSERT_LEVANTE_Javi_Jimenez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Jiménez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','POR')";
	public static final String INSERT_LEVANTE_KEYLOR = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Keylor Navas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','POR')";
	public static final String INSERT_LEVANTE_DAVID_NAVARRO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('David Navarro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_El_Adoua = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('El Adoua',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_HECTOR_RODAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Héctor Rodas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_JUANFRAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juanfran',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_Nagore = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nagore',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_NIKOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nikos Karabelas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_PEDRO_LOPEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_VYNTRA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Vyntra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEF')";
	public static final String INSERT_LEVANTE_Camarasa = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Camarasa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_DIOP = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diop',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_HIGON = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Higón',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Ivanschitz = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ivanschitz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Pallardo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pallardó',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_PEDRO_RIOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro Ríos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_RUBEN_GARCIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Sergio_Pinto = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Pinto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Simao_Mate = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Simão Mate',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Xumetra = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Xumetra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Angel_Rodriguez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ángel Rodríguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";
	public static final String INSERT_LEVANTE_Baba = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Babá',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";
	public static final String INSERT_LEVANTE_David_Barral = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('David Barral',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";
	public static final String INSERT_LEVANTE_ZHAR = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('El Zhar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";
	public static final String INSERT_LEVANTE_Jason = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jason',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";

	public static final String INSERT_LEVANTE_M_Sissoko = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('M. Sissoko',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','CEN')";
	public static final String INSERT_LEVANTE_Victor_Casadesus = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Casadesús',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_LEVANTE + "'),'500.000','DEL')";

	public static final String DELETE_LEVANTE_LELL = "DELETE FROM Futbolista WHERE nombreFut = 'Lell'";
	public static final String DELETE_LEVANTE_Gomis = "DELETE FROM Futbolista WHERE nombreFut = 'Gomis'";
	public static final String DELETE_LEVANTE_Nong = "DELETE FROM Futbolista WHERE nombreFut = 'Nong'";

	// Inserts en la tabla Futbolista para el MALAGA
	public static final String INSERT_MALAGA_KAMENI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Kameni',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','POR')";
	public static final String INSERT_MALAGA_CABALLERO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Willy Caballero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','POR')";
	public static final String INSERT_MALAGA_Angeleri = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Angeleri',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_ANTUNES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Antunes',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_Casado = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Casado',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_Flavio_Ferreira = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Flavio Ferreira',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_GAMEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jesús Gámez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_SERGIO_SANCHEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Sánchez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_WELINGTON = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Weligton',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEF')";
	public static final String INSERT_MALAGA_CAMACHO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Camacho',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_DUDA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Duda',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_ELISEU = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Eliseu',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_PORTILLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Francisco Portillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_Sergi_Darder = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergi Darder',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_Tissone = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tissone',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_El_Hamdaoui = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('El Hamdaoui',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";
	public static final String INSERT_MALAGA_Juanmi_Jimenez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juanmi Jiménez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";
	public static final String INSERT_MALAGA_Pawlowski = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pawlowski',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";
	public static final String INSERT_MALAGA_Samu_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Samu García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";
	public static final String INSERT_MALAGA_Santa_Cruz = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Santa Cruz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";
	public static final String INSERT_MALAGA_Iakovenko = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iakovenko',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_Nordin_Amrabat = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nordin Amrabat',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_Rescaldani = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rescaldani',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','DEL')";

	public static final String INSERT_MALAGA_Pablo_Perez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pablo Pérez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";
	public static final String INSERT_MALAGA_PEDRO_MORALES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pedro Morales',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_MALAGA + "'),'500.000','CEN')";

	public static final String DELETE_MALAGA_Roberto_Chen = "DELETE FROM Futbolista WHERE nombreFut = 'Roberto Chen'";
	public static final String DELETE_MALAGA_Bobley_Anderson = "DELETE FROM Futbolista WHERE nombreFut = 'Bobley Anderson'";
	public static final String DELETE_MALAGA_Fabrice = "DELETE FROM Futbolista WHERE nombreFut = 'Fabrice'";
	public static final String DELETE_MALAGA_Pedro_Morales = "DELETE FROM Futbolista WHERE nombreFut = 'Pedro Morales'";

	// Inserts en la tabla Futbolista para el ELCHE
	public static final String INSERT_ELCHE_Manu_Herrera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Manu Herrera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','POR')";
	public static final String INSERT_ELCHE_Tono = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Toño',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','POR')";
	public static final String INSERT_ELCHE_Botia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Botía',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Damian_Suarez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Damián Suárez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Domingo_Cisma = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Domingo Cisma',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Edu_Albacar = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Edu Albacar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Lomban = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lombán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Pelegrin = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pelegrín',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Sapunaru = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sapunaru',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Aaron_Niguez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Aarón Ñíguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Carles_Gil = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carles Gil',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Carlos_Sanchez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carlos Sánchez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Fidel = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fidel',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Javi_Flores = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Flores',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Javi_Marquez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Márquez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Mantecon = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mantecón',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Rivera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rivera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Ruben_Perez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Pérez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";
	public static final String INSERT_ELCHE_Alvaro_Gimenez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álvaro Giménez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEL')";
	public static final String INSERT_ELCHE_Boakye = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Boakye',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEL')";
	public static final String INSERT_ELCHE_Coro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Coro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEL')";
	public static final String INSERT_ELCHE_Cristian_Herrera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cristian Herrera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEL')";
	public static final String INSERT_ELCHE_Manu_del_Moral = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Manu del Moral',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEL')";

	public static final String INSERT_ELCHE_Charlie_Dean = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Charlie Dean',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','DEF')";
	public static final String INSERT_ELCHE_Rodrigues = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rodrigues',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_ELCHE + "'),'500.000','CEN')";

	public static final String DELETE_ELCHE_Generelo = "DELETE FROM Futbolista WHERE nombreFut = 'Generelo'";
	public static final String DELETE_ELCHE_M_Stevanovic = "DELETE FROM Futbolista WHERE nombreFut = 'M. Stevanovic'";

	// Inserts en la tabla Futbolista para el OSASUNA
	public static final String INSERT_OSASUNA_ANDRES_FERNANDEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Andrés Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','POR')";
	public static final String INSERT_OSASUNA_RIESGO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Riesgo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','POR')";
	public static final String INSERT_OSASUNA_ARRIBAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Arribas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_DAMIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Damià',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_Joan_Oriol = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Joan Oriol',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_Loties = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lotiès',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_BERTRAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marc Bertrán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_FLANO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Miguel Flaño',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_Satrustegui = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Satrústegui',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_Unai_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Unai García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEF')";
	public static final String INSERT_OSASUNA_CEJUDO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álvaro Cejudo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_ARMENTEROS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Armenteros',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_DE_LAS_CUEVAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('De las Cuevas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_FRAN_SILVA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Francisco Silva',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_Jose_Garcia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('José García',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_Lobato = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lobato',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_LOLO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lolo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_Maikel = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Maikel',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_Oier = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Oier',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_PUNAL = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Puñal',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_RAUL_LOE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Raoul Loe',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_ROBERTO_TORRES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Roberto Torres',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_SISI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sisi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','CEN')";
	public static final String INSERT_OSASUNA_Acuna = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Acuña',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEL')";
	public static final String INSERT_OSASUNA_NINO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nino',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEL')";
	public static final String INSERT_OSASUNA_ONWU = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Onwu',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEL')";
	public static final String INSERT_OSASUNA_Oriol_Riera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Oriol Riera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_OSASUNA + "'),'500.000','DEL')";

	public static final String DELETE_OSASUNA_Echaide = "DELETE FROM Futbolista WHERE nombreFut = 'Echaide'";

	// Inserts en la tabla Futbolista para el RAYO
	public static final String INSERT_RAYO_COBENO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cobeño',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','POR')";
	public static final String INSERT_RAYO_RUBEN_MARTINEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Martínez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','POR')";
	public static final String INSERT_RAYO_ARBILLA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Arbilla',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_GALVEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gálvez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_Galeano = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Galeano',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_Johan_Mojica = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Johan Mojica',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_NACHO_MARTINEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nacho Martínez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_TITO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tito',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_Ze_Castro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Zé Castro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";
	public static final String INSERT_RAYO_ADRIAN_GONZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Adrián González',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_ALBERTO_PEREA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alberto Perea',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Baena = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Baena',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Christian_Cueva = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Christian Cueva',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Iago_Falque = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iago Falqué',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Jonathan_Viera = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonathan Viera',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_JOSE_CARLOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('José Carlos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Saul_Niguez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Saúl Ñíguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_TRASHORRAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Trashorras',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','CEN')";
	public static final String INSERT_RAYO_Bueno = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bueno',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_Embarba = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Embarba',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_Larrivey = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Larrivey',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_LASS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lass',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_Nery_Castillo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nery Castillo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_Rochina = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rochina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_RUBEN_RAMIRO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Ramiro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";
	public static final String INSERT_RAYO_Sebastian_Fernandez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sebastián Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEL')";

	public static final String INSERT_RAYO_Borja_Lopez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Borja López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RAYO + "'),'500.000','DEF')";

	public static final String DELETE_RAYO_Rodriguez = "DELETE FROM Futbolista WHERE nombreFut = 'Rodríguez'";

	// Inserts en la tabla Futbolista para el REAL MADRID
	public static final String INSERT_RMADRID_CASILLAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Casillas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','POR')";
	public static final String INSERT_RMADRID_DIEGO_LOPEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego López',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','POR')";
	public static final String INSERT_RMADRID_Jesus_Fernandez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jesús Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','POR')";
	public static final String INSERT_RMADRID_ARBELOA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Arbeloa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_Carvajal = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carvajal',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_Diego_Llorente = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego Llorente',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_COENTRAO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fábio Coentrão',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_MARCELO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marcelo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_NACHO_FERNANDEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nacho Fernández',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_PEPE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pepe',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_SERGIO_RAMOS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Ramos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_VARANE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Varane',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEF')";
	public static final String INSERT_RMADRID_Bale = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bale',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_Casemiro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Casemiro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_DI_MARIA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Di María',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_Illarramendi = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Illarramendi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_Isco = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Isco',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_KHEDIRA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Khedira',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_MODRIC = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Modric',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_Omar_Mascarell = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Omar Mascarell',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_XAVI_ALONSO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Xabi Alonso',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','CEN')";
	public static final String INSERT_RMADRID_BENZEMA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Benzema',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEL')";
	public static final String INSERT_RMADRID_CRISTIANO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cristiano Ronaldo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEL')";
	public static final String INSERT_RMADRID_JESE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jesé',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEL')";
	public static final String INSERT_RMADRID_MORATA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Morata',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RMADRID + "'),'500.000','DEL')";

	// Inserts en la tabla Futbolista para el REAL SOCIEDAD
	public static final String INSERT_RSOCIEDAD_BRAVO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Claudio Bravo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','POR')";
	public static final String INSERT_RSOCIEDAD_ZUBIKARAI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Zubikarai',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','POR')";
	public static final String INSERT_RSOCIEDAD_ANSOTEGI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ansotegi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_CARLOS_MARTINEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carlos Martínez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_ESTRADA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dani Estrada',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_DE_LA_BELLA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('De la Bella',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_INIGO_MARTINEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Íñigo Martínez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_JOSE_ANGEL = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('José Ángel',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_MIKEL_GONZALEZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mikel González',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_Zaldua = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Zaldua',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEF')";
	public static final String INSERT_RSOCIEDAD_CHORY = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Chory Castro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_ELUSTONDO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Elustondo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_Gaztanaga = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gaztañaga',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_Granero = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Granero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_GRIEZMANN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Griezmann',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_JAVI_ROS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Ros',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_BERGARA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Markel Bergara',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_RUBEN_PARDO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rubén Pardo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_XABI_PRIETO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Xabi Prieto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_ZURUTUZA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Zurutuza',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";
	public static final String INSERT_RSOCIEDAD_AGIRRETXE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Agirretxe',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEL')";
	public static final String INSERT_RSOCIEDAD_VELA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carlos Vela',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEL')";
	public static final String INSERT_RSOCIEDAD_IFRAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ifrán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEL')";
	public static final String INSERT_RSOCIEDAD_Sangalli = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sangalli',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEL')";
	public static final String INSERT_RSOCIEDAD_Seferovic = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Seferovic',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','DEL')";

	public static final String INSERT_RSOCIEDAD_Canales = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Canales',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_RSOCIEDAD + "'),'500.000','CEN')";

	public static final String DELETE_RSOCIEDAD_Cadamuro = "DELETE FROM Futbolista WHERE nombreFut = 'Cadamuro'";

	// Inserts en la tabla Futbolista para el SEVILLA
	public static final String INSERT_SEVILLA_BETO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Beto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','POR')";
	public static final String INSERT_SEVILLA_Javi_Varas = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Varas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','POR')";
	public static final String INSERT_SEVILLA_Alberto_Moreno = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alberto Moreno',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_Carrico = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carriço',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_CICINHO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cicinho',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_COKE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Coke',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_Diogo_Figueiras = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diogo Figueiras',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_FAZIO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fazio',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_FERNANDO_NAV = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fernando Navarro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_Israel_Puerto = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Israel Puerto',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_Nico_Pareja = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nico Pareja',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEF')";
	public static final String INSERT_SEVILLA_Cristoforo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cristóforo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Denis_Cheryshev = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Denis Cheryshev',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Iborra = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Iborra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Jairo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jairo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Marko_Marin = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marko Marin',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_MBia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('MBia',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_PEROTTI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Perotti',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_RAKITIC = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rakitic',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_REYES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Reyes',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_TROCHOWSKI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Trochowski',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Vitolo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Vitolo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','CEN')";
	public static final String INSERT_SEVILLA_Bacca = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bacca',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEL')";
	public static final String INSERT_SEVILLA_Gameiro = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gameiro',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_SEVILLA + "'),'500.000','DEL')";

	public static final String DELETE_SEVILLA_JULIAN = "DELETE FROM Futbolista WHERE nombreFut = 'Julián'";
	public static final String DELETE_SEVILLA_CALA = "DELETE FROM Futbolista WHERE nombreFut = 'Cala'";
	public static final String DELETE_SEVILLA_RABELLO = "DELETE FROM Futbolista WHERE nombreFut = 'Bryan Rabello'";
	public static final String DELETE_SEVILLA_ALEX_RUBIO = "DELETE FROM Futbolista WHERE nombreFut = 'Álex Rubio'";

	// Inserts en la tabla Futbolista para el VALENCIA
	public static final String INSERT_VALENCIA_DIEGO_ALVES = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego Alves',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','POR')";
	public static final String INSERT_VALENCIA_GUAITA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Guaita',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','POR')";
	public static final String INSERT_VALENCIA_BARRAGAN = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Barragán',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_BERNAT = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bernat',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_JOAO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('João Pereira',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_MATHIEU = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mathieu',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_Ruben_Vezo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rúben Vezo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_RICARDO_COSTA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ricardo Costa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_VICTOR_RUIZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Ruiz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_Fede_Cartabia = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fede Cartabia',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_FEGHOULI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Feghouli',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_Javi_Fuego = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Fuego',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_Michel_Herrero = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Michel Herrero',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_Oriol_Romeu = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Oriol Romeu',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_PAREJO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Parejo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_Alcacer = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Alcácer',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEL')";
	public static final String INSERT_VALENCIA_Eduardo_Vargas = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Eduardo Vargas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEL')";
	public static final String INSERT_VALENCIA_JONAS = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonas',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEL')";
	public static final String INSERT_VALENCIA_PIATTI = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Piatti',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEL')";

	public static final String INSERT_VALENCIA_Senderos = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Senderos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEF')";
	public static final String INSERT_VALENCIA_S_Keita = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('S. Keita',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','CEN')";
	public static final String INSERT_VALENCIA_Vinicius_Araujo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Vinícius Araújo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALENCIA + "'),'500.000','DEL')";

	public static final String DELETE_VALENCIA_GUARDADO = "DELETE FROM Futbolista WHERE nombreFut = 'Guardado'";
	public static final String DELETE_VALENCIA_BANEGA = "DELETE FROM Futbolista WHERE nombreFut = 'Éver Banega'";
	public static final String DELETE_VALENCIA_CANALES = "DELETE FROM Futbolista WHERE nombreFut = 'Canales'";
	public static final String DELETE_VALENCIA_Helder_Postiga = "DELETE FROM Futbolista WHERE nombreFut = 'Hélder Postiga'";
	public static final String DELETE_VALENCIA_Pabon = "DELETE FROM Futbolista WHERE nombreFut = 'Pabón'";

	// Inserts en la tabla Futbolista para el VALLADOLID
	public static final String INSERT_VALLADOLID_Diego_Marino = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Diego Mariño',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','POR')";
	public static final String INSERT_VALLADOLID_JAIME = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jaime',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','POR')";
	public static final String INSERT_VALLADOLID_CARLOS_PENA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Carlos Peña',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_Heinz = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Heinz',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_RUEDA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jesús Rueda',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_MARC_VALIENTE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Marc Valiente',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_Mitrovic = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mitrovic',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_RUKAVINA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Rukavina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEF')";
	public static final String INSERT_VALLADOLID_ALVARO_RUBIO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Álvaro Rubio',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_OSCAR = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Óscar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_Bergdich = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bergdich',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_EBERT = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Ebert',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_Fausto_Rossi = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Fausto Rossi',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_BARAJA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javier Baraja',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_LLUIS_SASTRE = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Lluis Sastre',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_OMAR = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Omar Ramos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_VICTOR_PEREZ = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Víctor Pérez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_VALDET_RAMA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Valdet Rama',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','CEN')";
	public static final String INSERT_VALLADOLID_GUERRA = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javi Guerra',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEL')";
	public static final String INSERT_VALLADOLID_LARSSON = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Larsson',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEL')";
	public static final String INSERT_VALLADOLID_MANUCHO = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Manucho',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEL')";
	public static final String INSERT_VALLADOLID_Osorio = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Osorio',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEL')";

	public static final String INSERT_VALLADOLID_Jeffren = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jeffrén',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VALLADOLID
			+ "'),'500.000','DEL')";

	public static final String DELETE_VALLADOLID_Gilberto_Garcia = "DELETE FROM Futbolista WHERE nombreFut = 'Gilberto García'";

	// Inserts en la tabla Futbolista para el VILLARREAL
	public static final String INSERT_VILLARREAL_Juan_Carlos = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Juan Carlos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','POR')";
	public static final String INSERT_VILLARREAL_Sergio_Asenjo = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Sergio Asenjo',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','POR')";
	public static final String INSERT_VILLARREAL_Dorado = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Dorado',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Gabriel_Paulista = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Gabriel Paulista',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Jaume_Costa = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jaume Costa',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Jokic = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jokic',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Mario_Gaspar = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Mario Gaspar',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Musacchio = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Musacchio',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Pablo_Iniguez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pablo Iñiguez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Pantic = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Pantic',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEF')";
	public static final String INSERT_VILLARREAL_Bruno_Soriano = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Bruno Soriano',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Cani = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Cani',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Edu_Ramos = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Edu Ramos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Javier_Aquino = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Javier Aquino',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Moi_Gomez = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Moi Gómez',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Nahuel = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Nahuel',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Tomas_Pina = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Tomás Pina',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Trigueros = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Trigueros',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Giovani = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Giovani dos Santos',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEL')";
	public static final String INSERT_VILLARREAL_Jonathan_Pereira = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Jonathan Pereira',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEL')";
	public static final String INSERT_VILLARREAL_Perbet = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Perbet',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEL')";
	public static final String INSERT_VILLARREAL_Uche = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Uche',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEL')";

	public static final String INSERT_VILLARREAL_Oliver_Torres = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Óliver Torres',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','CEN')";
	public static final String INSERT_VILLARREAL_Joan_Roman = "INSERT INTO Futbolista (nombreFut,estadoFut,equipoFut,valorFut,posFut) VALUES ('Joan Román',1,(SELECT equId FROM Equipo WHERE aliasEqu = '"
			+ ConstantesParametros.EQUIPO_SEL_VILLARREAL
			+ "'),'500.000','DEL')";

	public static final String DELETE_VILLARREAL_Hernan_Perez = "DELETE FROM Futbolista WHERE nombreFut = 'Hernán Pérez'";
	public static final String DELETE_VILLARREAL_Farinos = "DELETE FROM Futbolista WHERE nombreFut = 'Farinós'";

}
