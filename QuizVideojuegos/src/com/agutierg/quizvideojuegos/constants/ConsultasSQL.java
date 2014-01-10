package com.agutierg.quizvideojuegos.constants;

public class ConsultasSQL {

	public static final String CREATE_TABLA_NIVEL = "CREATE TABLE [Nivel] ([idNivel] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[nombreNivel] VARCHAR(255) NOT NULL,[porcCompletado] VARCHAR(255) NOT NULL,[idDrawable] VARCHAR(255) NOT NULL,[isDesbloqueado] BOOLEAN NOT NULL)";
	public static final String CREATE_TABLA_JUEGO = "CREATE TABLE [Juego] ([idJuego] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[idNivelJuego] INTEGER NOT NULL REFERENCES Nivel(idNivel) ON DELETE CASCADE,[nombreJuego] VARCHAR(255) NOT NULL,[pistaJuego] VARCHAR(255) NOT NULL,[idDrawable] VARCHAR(255) NOT NULL,[isRespondido] BOOLEAN NOT NULL)";

	public static final String CREATE_TABLA_JUGADOR = "CREATE TABLE [Jugador] ([idJugador] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[nombreJugador] VARCHAR(255) NOT NULL,[aciertos] INTEGER)";

	// Inserts en la tabla nivel
	public static final String INSERT_NIVEL_1 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 1','0','level1',1)";
	public static final String INSERT_NIVEL_2 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 2','0','level2',0)";
	public static final String INSERT_NIVEL_3 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 3','0','level3',0)";
	public static final String INSERT_NIVEL_4 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 4','0','level4',0)";
	public static final String INSERT_NIVEL_5 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 5','0','level5',0)";
	public static final String INSERT_NIVEL_6 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 6','0','level6',0)";
	public static final String INSERT_NIVEL_7 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 7','0','level7',0)";
	public static final String INSERT_NIVEL_8 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 8','0','level8',0)";
	public static final String INSERT_NIVEL_9 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 9','0','level9',0)";
	public static final String INSERT_NIVEL_10 = "INSERT INTO Nivel (nombreNivel,porcCompletado,idDrawable,isDesbloqueado) VALUES ('Level 10','0','level10',0)";

	// Inserts en la tabla juego (NIVEL 1)
	public static final String INSERT_JUEGO_NIVEL_1_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'ANGRY WORDS','Famous game to build words','apalabrados',0)";
	public static final String INSERT_JUEGO_NIVEL_1_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'ABE''S ODDYSEE','PlayStation game very hard, trying to escape','abees',0)";
	public static final String INSERT_JUEGO_NIVEL_1_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'ANGRY BIRDS','Famous mobile game','angry_birds',0)";
	public static final String INSERT_JUEGO_NIVEL_1_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'ASSASSINS CREED','Platform action game, set in medieval times','assassins_creed',0)";
	public static final String INSERT_JUEGO_NIVEL_1_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'BATMAN ARKHAM ASYLUM','Superhero bat, first game','batman',0)";
	public static final String INSERT_JUEGO_NIVEL_1_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'COUNTER STRIKE','Famous game of terrorists against police','counter',0)";
	public static final String INSERT_JUEGO_NIVEL_1_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'FIFA 99','Soccer game of 1999','fifa99',0)";
	public static final String INSERT_JUEGO_NIVEL_1_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'FINAL FANTASY I','First Fantasy','final_1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'GEARS OF WAR','Action game alien invasion','gears1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'GRAN TURISMO','Driving Simulator PlayStation 1','gt1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'HERCULES','Disney platform game','hercules1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'THE LEGEND OF ZELDA','Adventure game Nintendo','zelda1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'CRASH BANDICOOT','Famous game platforms with a fox','crash1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'METAL SLUG','Arcade game for Neo Geo','metal_slug',0)";
	public static final String INSERT_JUEGO_NIVEL_1_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'METAL GEAR SOLID','Game infiltration PlayStation 1','metal1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'PACMAN','Famous arcade game','pacman',0)";
	public static final String INSERT_JUEGO_NIVEL_1_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'SONIC THE HEDGEHOG','Platform game a hedgehog, Sega','sonic',0)";
	public static final String INSERT_JUEGO_NIVEL_1_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'SUPER MARIO BROS','The first game of the most famous plumber','mario1',0)";
	public static final String INSERT_JUEGO_NIVEL_1_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'TRIVIADOS','Celebrity trivia game for Android','triviados',0)";
	public static final String INSERT_JUEGO_NIVEL_1_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_1
			+ "'),'WIPEOUT','Craft Racing Game','wipeout1',0)";

	// Inserts en la tabla juego (NIVEL 2)
	public static final String INSERT_JUEGO_NIVEL_2_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'AGE OF EMPIRES','Famous strategy game for PC','aoe1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'DEAD SPACE','Horror game in a spaceship','deadspace1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'DIABLO','First version of this RPG','diablo1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'DINO CRISIS 2','Action game where you kill dinosaurs, Play 1','dinocrisis2',0)";
	public static final String INSERT_JUEGO_NIVEL_2_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'DONKEY KONG','Nintendo platform game about a monkey','donkeykong1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'FORZA MOTORSPORT 3','Third driving game, Xbox 360','forza3',0)";
	public static final String INSERT_JUEGO_NIVEL_2_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'GOD OF WAR','Action game in which you kill gods','god_of_war_1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'MEDIEVIL','Platform game about dead, Play 1','medievil1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'NBA LIVE 2013','2013 Basketball Game','nba13',0)";
	public static final String INSERT_JUEGO_NIVEL_2_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'POKEMON','Famous RPG for Game Boy','pokemon',0)";
	public static final String INSERT_JUEGO_NIVEL_2_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'PLANTS VS ZOMBIES','Mobile game plants and ...','pvz',0)";
	public static final String INSERT_JUEGO_NIVEL_2_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'QUAKE 2','Second version of this action game, 1997','quake2',0)";
	public static final String INSERT_JUEGO_NIVEL_2_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'RESIDENT EVIL 1','Second version of the famous saga of horror games','resident1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'THE SIMPSONS SPRINGFIELD','Mobile game of the Simpsons','springfield',0)";
	public static final String INSERT_JUEGO_NIVEL_2_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'STAR WARS THE PHANTOM MENACE','Game of Star Wars, Episode 1','starwarsamenaza',0)";
	public static final String INSERT_JUEGO_NIVEL_2_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'STREET FIGHTER','Capcom fighting game','streetfighter1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'TEKKEN 1','First version of this fighting game','tekken1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'THE LORD OF THE RINGS THE TWO TOWERS','Game of the second film of The Lord of the Rings','tlotr2torres',0)";
	public static final String INSERT_JUEGO_NIVEL_2_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'TOMB RAIDER','Famous action game about a girl, Play 1','tombraider1',0)";
	public static final String INSERT_JUEGO_NIVEL_2_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_2
			+ "'),'UNCHARTED','Action and platforms game like Indiana Jones, Play 3','uncharted_1',0)";

	// Inserts en la tabla juego (NIVEL 3)
	public static final String INSERT_JUEGO_NIVEL_3_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'AGE OF MYTHOLOGY','Famous game of mythology','agemito1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'ASTERIX & OBELIX XXL','Year: 2003','asterixxxl',0)";
	public static final String INSERT_JUEGO_NIVEL_3_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'CONTRA','Arcade game: 1987','contra2',0)";
	public static final String INSERT_JUEGO_NIVEL_3_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'CRAZY TAXI','Driving game with a taxi','crazytaxi1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'DRAGON BALL Z BUDOKAI TENKAICHI 3','Third in this saga','dbzbudotenk3',0)";
	public static final String INSERT_JUEGO_NIVEL_3_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'DEVIL MAY CRY','Action game where you kill demons','dmycry1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'FIFA 13','This year...','fifa13',0)";
	public static final String INSERT_JUEGO_NIVEL_3_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'GRAN THEFT AUTO 2','Second version of this saga','gta2',0)";
	public static final String INSERT_JUEGO_NIVEL_3_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'MARIO KART 64','Game for Nintendo 64','mariokart64',0)";
	public static final String INSERT_JUEGO_NIVEL_3_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'PANDEMONIUM','Platform game, 1996, Play 1','pandemonium',0)";
	public static final String INSERT_JUEGO_NIVEL_3_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'PRINCE OF PERSIA','First version about the prince...','prince_of_persia1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'RED DEAD REDEMPTION','Western from the creators of GTA','readdead',0)";
	public static final String INSERT_JUEGO_NIVEL_3_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'THE SIMS','Social skill game for PC','sims',0)";
	public static final String INSERT_JUEGO_NIVEL_3_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'SONIC THE HEDGEHOG 2','Second...','sonic2',0)";
	public static final String INSERT_JUEGO_NIVEL_3_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'SOUL CALIBUR 3','Fighting game with weapons, actual generation','soulcalibur3',0)";
	public static final String INSERT_JUEGO_NIVEL_3_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'SPIDERMAN 3','3rd of this super hero','spiderman3',0)";
	public static final String INSERT_JUEGO_NIVEL_3_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'SPLINTER CELL','Stealth and action game, Play 1','splintercell1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'SPYRO THE DRAGON','Platform game about a dragon, Play 1','spyro1',0)";
	public static final String INSERT_JUEGO_NIVEL_3_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'TEKKEN 3','Third of Namco','tekken3',0)";
	public static final String INSERT_JUEGO_NIVEL_3_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_3
			+ "'),'WARCRAFT 3','Third version of this RPG, of heroes and magic','warcraft3',0)";

	// Inserts en la tabla juego (NIVEL 4)
	public static final String INSERT_JUEGO_NIVEL_4_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'BIOSHOCK','First person shooter in an underwater city','bioshock1',0)";
	public static final String INSERT_JUEGO_NIVEL_4_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'CIVILIZATION 2','Build an empire, second game','civilization2',0)";
	public static final String INSERT_JUEGO_NIVEL_4_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'COMMANDOS','Strategy game made ​​by a Spanish team','comandos',0)";
	public static final String INSERT_JUEGO_NIVEL_4_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'CRASH TEAM RACING','Kart racing game','crashteam',0)";
	public static final String INSERT_JUEGO_NIVEL_4_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'CRYSIS','Shooter release on 2007','crysis1',0)";
	public static final String INSERT_JUEGO_NIVEL_4_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'DARKSIDERS','Game about the four riders of the apocalypse','darksiders1',0)";
	public static final String INSERT_JUEGO_NIVEL_4_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'FINAL FANTASY X','10th of this RPG saga','final10',0)";
	public static final String INSERT_JUEGO_NIVEL_4_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'MEDIEVIL 2','The second game...','medievil2',0)";
	public static final String INSERT_JUEGO_NIVEL_4_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'METAL GEAR SOLID 3','Action game in a jungle','metal3',0)";
	public static final String INSERT_JUEGO_NIVEL_4_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'CALL OF DUTY MODERN WARFARE 3','Shooter, third of the saga','modernwarfare3',0)";
	public static final String INSERT_JUEGO_NIVEL_4_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'NEED FOR SPEED MOST WANTED','Most wanted...','nfsmostwanted',0)";
	public static final String INSERT_JUEGO_NIVEL_4_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'PRO EVOLUTION SOCCER 3','Alternative to Fifa, Play 2','pes3',0)";
	public static final String INSERT_JUEGO_NIVEL_4_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'007 QUANTUM OF SOLACE','Year: 2008','quantumsolace',0)";
	public static final String INSERT_JUEGO_NIVEL_4_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'RAYMAN','Designed and published by Ubisoft, 1995','rayman1',0)";
	public static final String INSERT_JUEGO_NIVEL_4_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'RESIDENT EVIL 3','3rd of this horror saga','resident3',0)";
	public static final String INSERT_JUEGO_NIVEL_4_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'SHADOW OF THE COLOSSUS','Game for Play 2, 2006 about colossus','shadowcolosus',0)";
	public static final String INSERT_JUEGO_NIVEL_4_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'STAR WARS BATTLEFRONT 2','FPS developed by Pandemic Studios','starwarsbatt2',0)";
	public static final String INSERT_JUEGO_NIVEL_4_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'SUPER MARIO LAND','Super Mario for Game Boy','super_mario_land',0)";
	public static final String INSERT_JUEGO_NIVEL_4_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'WII SPORTS','Sports...','wiisports',0)";
	public static final String INSERT_JUEGO_NIVEL_4_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_4
			+ "'),'WORLD RALLY CHAMPIONSHIP','Rally driving game','worlrallychamp',0)";

	// Inserts en la tabla juego (NIVEL 5)
	public static final String INSERT_JUEGO_NIVEL_5_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'BATTLEFIELD 3','First person shooter, 3rd version','battlefield3',0)";
	public static final String INSERT_JUEGO_NIVEL_5_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'COMMANDOS 2','Second version of this spanish game','commandos2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'DIABLO 2','Blizzard Entertainment game','diablo2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'F1 2013','Of this year','f12013',0)";
	public static final String INSERT_JUEGO_NIVEL_5_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'GEARS OF WAR 2','Second version of this action game for Xbox 360','gears2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'KILLZONE 2','Sci-fi shooter in first person for Play 3','killzone2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'LEFT FOR DEAD','Four people have to survive the zombies','leftfordead',0)";
	public static final String INSERT_JUEGO_NIVEL_5_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'MAFIA 2','Similar to GTA, 2nd','mafia2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'SUPER MARIO GALAXY','Mario in 3D','mariogalaxy',0)";
	public static final String INSERT_JUEGO_NIVEL_5_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'MEGAMAN 2','A platform game developed and published by Capcom, 2nd version','megaman2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'METAL GEAR SOLID 2','Raiden...','metal2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'PROTOTYPE 2','2nd version of this action game for Play 3','prototype2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'SACRED 2 FALLEN ANGEL','It is an action role-playing game for PC, Xbox360 and PlayStation 3','sacred2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'SCARFACE','A film of Al Pacino','scarface',0)";
	public static final String INSERT_JUEGO_NIVEL_5_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'SONIC 3D BLAST','Sonic in 3D','sonic3dblast',0)";
	public static final String INSERT_JUEGO_NIVEL_5_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'THE HOUSE OF THE DEAD','House...and dead','thotd1',0)";
	public static final String INSERT_JUEGO_NIVEL_5_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'TIME CRISIS 2','Arcade action game, 2nd version','timecrisis2',0)";
	public static final String INSERT_JUEGO_NIVEL_5_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'TOP SPIN 3','3rd version','topsping3',0)";
	public static final String INSERT_JUEGO_NIVEL_5_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'WORLD OF WARCRAFT','Wow...','wow1',0)";
	public static final String INSERT_JUEGO_NIVEL_5_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_5
			+ "'),'THE LEGEND OF ZELDA OCARINA OF TIME','For Nintendo 64','zeldaocarina',0)";

	// Inserts en la tabla juego (NIVEL 6)
	public static final String INSERT_JUEGO_NIVEL_6_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'ANGRY BIRDS SPACE','In the space...','angry_space',0)";
	public static final String INSERT_JUEGO_NIVEL_6_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'ANIMAL CROSSING','Life simulation by Nintendo','animal_crossing',0)";
	public static final String INSERT_JUEGO_NIVEL_6_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'ARMY OF TWO','Action title based on cooperative strategies','armytwo',0)";
	public static final String INSERT_JUEGO_NIVEL_6_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'ASSASSINS CREED 2','Venecia...','assassinscreed2',0)";
	public static final String INSERT_JUEGO_NIVEL_6_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'CAPCOM VS SNK PRO','Pro version of this game, Capcom','capcom_vs_snk_pro',0)";
	public static final String INSERT_JUEGO_NIVEL_6_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'DARK SOULS','RPG exclusive for Play 3','dark_souls_1',0)";
	public static final String INSERT_JUEGO_NIVEL_6_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'DRAGON AGE ORIGINS','About dragons, 1st game','dragon_age_origins',0)";
	public static final String INSERT_JUEGO_NIVEL_6_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'FINAL FANTASY IX','The last of Play 1','ff9',0)";
	public static final String INSERT_JUEGO_NIVEL_6_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'GAME OF THRONES','A famous serie...magic and adventures','game_of_thrones',0)";
	public static final String INSERT_JUEGO_NIVEL_6_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'MASS EFFECT','Action and science fiction game for Xbox 360','masseffect',0)";
	public static final String INSERT_JUEGO_NIVEL_6_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'MAX PAYNE','First version of this action game for PC','max_payne',0)";
	public static final String INSERT_JUEGO_NIVEL_6_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'MONSTER HUNTER','Series of action adventure video game developed and published by Capcom','monster_hunter',0)";
	public static final String INSERT_JUEGO_NIVEL_6_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'PARASITE EVE','Strategy game, horror and action, with some touches RPG, Play 1','parasite_eve',0)";
	public static final String INSERT_JUEGO_NIVEL_6_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'RATCHET AND CLANK','Platform game','ratchetampclank1',0)";
	public static final String INSERT_JUEGO_NIVEL_6_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'RESIDENT EVIL 4','4th of this saga','residentevil4',0)";
	public static final String INSERT_JUEGO_NIVEL_6_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'SINGSTAR','Sing?','singstar',0)";
	public static final String INSERT_JUEGO_NIVEL_6_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'SPLATTERHOUSE','Namco video game genre, wrestling / horror','splatterhouse',0)";
	public static final String INSERT_JUEGO_NIVEL_6_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'SYPHON FILTER','Espionage and action game in the third person, Play 1','syphon_filter',0)";
	public static final String INSERT_JUEGO_NIVEL_6_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'TOMB RAIDER 3','3rd...','tomb3',0)";
	public static final String INSERT_JUEGO_NIVEL_6_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_6
			+ "'),'X-MEN ORIGINS WOLVERINE','Of the wolverine','xmenoriginswolverine',0)";

	// Inserts en la tabla juego (NIVEL 7)
	public static final String INSERT_JUEGO_NIVEL_7_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'AGE OF EMPIRES 2','Second version of this strategy game','age_of_empires_2',0)";
	public static final String INSERT_JUEGO_NIVEL_7_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'ALONE IN THE DARK','You should not be alone','aloneinthedark',0)";
	public static final String INSERT_JUEGO_NIVEL_7_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'ASTROBOY','Is a manga game, created by Osamu Tezuka','astroboy',0)";
	public static final String INSERT_JUEGO_NIVEL_7_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'BORDERLANDS 2','Video game first-person shooter with RPG elements','borderlands2',0)";
	public static final String INSERT_JUEGO_NIVEL_7_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'DISHONORED','Action-adventure video game and first-person stealth developed by Arkane Studios','dishonored',0)";
	public static final String INSERT_JUEGO_NIVEL_7_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'DRIVER','You Are the Wheelman in North America','driver1',0)";
	public static final String INSERT_JUEGO_NIVEL_7_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'FIFA 2008','Year: 2008','fifa08',0)";
	public static final String INSERT_JUEGO_NIVEL_7_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'GARFIELD 2','2nd version','garfield2',0)";
	public static final String INSERT_JUEGO_NIVEL_7_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'GOD OF WAR 2','2nd version','godofwar2',0)";
	public static final String INSERT_JUEGO_NIVEL_7_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'GUITAR HERO','Play the guitar','guitarhero',0)";
	public static final String INSERT_JUEGO_NIVEL_7_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'HALO','From Microsoft','halo1',0)";
	public static final String INSERT_JUEGO_NIVEL_7_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'HELL YEAH!','Wrath of the Dead Rabbit','hellyeah',0)";
	public static final String INSERT_JUEGO_NIVEL_7_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'HITMAN','Game of a stealthy killer','hitman1',0)";
	public static final String INSERT_JUEGO_NIVEL_7_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'MADDEN NNFL 2013','Year: 2013','maddennfl13',0)";
	public static final String INSERT_JUEGO_NIVEL_7_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'MARIO POWER TENNIS','Mario and tennis...','mario_power_tennis',0)";
	public static final String INSERT_JUEGO_NIVEL_7_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'MARIO VS DONKEY KONG','Mario and...','mario_vs_donkey',0)";
	public static final String INSERT_JUEGO_NIVEL_7_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'OF ORCS AND MEN','RPG exclusive for Play 3. Orcs.','of_orcs_and_men',0)";
	public static final String INSERT_JUEGO_NIVEL_7_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'OKAMI','Action-adventure video game developed by Clover Studio and published by Capcom','okami',0)";
	public static final String INSERT_JUEGO_NIVEL_7_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'SSX 3','3rd version','ssx3',0)";
	public static final String INSERT_JUEGO_NIVEL_7_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_7
			+ "'),'THE ELDER SCROLLS OBLIVION','Action role-playing game at an open world developed by Bethesda Game Studios','tesoblivion',0)";

	// Inserts en la tabla juego (NIVEL 8)
	public static final String INSERT_JUEGO_NIVEL_8_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'CALL OF DUTY BLACK OPS','Videogame FPS war style developed by Treyarch and published by Activision','cod_black_ops',0)";
	public static final String INSERT_JUEGO_NIVEL_8_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'DJ HERO','Be a DJ','djhero',0)";
	public static final String INSERT_JUEGO_NIVEL_8_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'DRIVER PARALLEL LINES','The game was released on March 14 (March 17 in Europe), 2006','driver_parallel_lines',0)";
	public static final String INSERT_JUEGO_NIVEL_8_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'GEARS OF WAR 3','3rd version','gow3',0)";
	public static final String INSERT_JUEGO_NIVEL_8_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'GRAN TURISMO 2','Second version of this game','gt2',0)";
	public static final String INSERT_JUEGO_NIVEL_8_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'HALO 2','Shooter for Microsoft, 2nd version','halo2',0)";
	public static final String INSERT_JUEGO_NIVEL_8_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'JUST DANCE','Dance...','justdance',0)";
	public static final String INSERT_JUEGO_NIVEL_8_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'MEDAL OF HONOR WAR FIGHTER','Video game first-person shooter developed by Danger Close and distributed by Electronic Arts','medalofhonorwarfighter',0)";
	public static final String INSERT_JUEGO_NIVEL_8_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'METROID','Chronicles the missions of bounty hunter Samus Aran','metroid1',0)";
	public static final String INSERT_JUEGO_NIVEL_8_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'NEED FOR SPEED UNDERCOVER','Under...','needforspeedundercover',0)";
	public static final String INSERT_JUEGO_NIVEL_8_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'RESIDENT EVIL 5','5th...','re5',0)";
	public static final String INSERT_JUEGO_NIVEL_8_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'SEGA BASS FISHING','Sega...and fish','segabassfishing',0)";
	public static final String INSERT_JUEGO_NIVEL_8_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'SHENMUE 2','For Dreamcast','shenmue2',0)";
	public static final String INSERT_JUEGO_NIVEL_8_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'SONIC ADVENTURE 2','Second version game','sonicadventure2',0)";
	public static final String INSERT_JUEGO_NIVEL_8_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'SUPER SMASH BROS BRAWL','Fighting game distributed by Nintendo for Wii console','super_smash_bros_brawl',0)";
	public static final String INSERT_JUEGO_NIVEL_8_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'THE LAST STORY','Action role-playing video game developed by Mistwalker and published by Nintendo for the Wii console','thelaststory',0)";
	public static final String INSERT_JUEGO_NIVEL_8_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'TOMB RAIDER UNDERWORLD','Eighth game of the saga','tombr_underworld',0)";
	public static final String INSERT_JUEGO_NIVEL_8_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'VALKYRIE PROFILE 2 SILMERIA','RPG. Silmeria...','valkyrie_profile2_silmeria',0)";
	public static final String INSERT_JUEGO_NIVEL_8_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'VIRTUA FIGHTER 5','Latest release in the saga','virtuafighter5',0)";
	public static final String INSERT_JUEGO_NIVEL_8_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_8
			+ "'),'WWE 2013','Year: 2013','wwe13',0)";

	// Inserts en la tabla juego (NIVEL 9)
	public static final String INSERT_JUEGO_NIVEL_9_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'BATEN KAITOS ORIGINS','Is a 2006 role-playing video game, Gamecube','baten_kaitos_origins',0)";
	public static final String INSERT_JUEGO_NIVEL_9_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'BATMAN ARKHAM CITY','2nd...','batman2',0)";
	public static final String INSERT_JUEGO_NIVEL_9_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'DEAD ISLAND','Survival and shooter','dead_island',0)";
	public static final String INSERT_JUEGO_NIVEL_9_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'DEAD RISING','Is funny kill zombies','deadrising',0)";
	public static final String INSERT_JUEGO_NIVEL_9_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'DUST 514','Ppcoming free-to-play first-person shooter developed by CCP Games, Play 3','dust514',0)";
	public static final String INSERT_JUEGO_NIVEL_9_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'ENSLAVED','Platform and adventures game','enslaved',0)";
	public static final String INSERT_JUEGO_NIVEL_9_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'FINAL FANTASY VII','The most famous of this saga','ffvii',0)";
	public static final String INSERT_JUEGO_NIVEL_9_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'GOD OF WAR 3','3rd...','godofwar3',0)";
	public static final String INSERT_JUEGO_NIVEL_9_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'GRAND THEFT AUTO 4','4th...','gta4',0)";
	public static final String INSERT_JUEGO_NIVEL_9_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'GUNBIRD 2','2D scrolling shooter developed by Psikyo and released by Capcom in 1998','gunbird2',0)";
	public static final String INSERT_JUEGO_NIVEL_9_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'IKARUGA','Is a shootem up video game developed by Treasure','ikaruga',0)";
	public static final String INSERT_JUEGO_NIVEL_9_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'JET SET RADIO',' Video game for the Dreamcast, developed by Smilebit and published by Sega on June 29','jetsetradio',0)";
	public static final String INSERT_JUEGO_NIVEL_9_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'L.A. NOIRE','Video game developed by Team Bondi for Rockstar Games','lanoire',0)";
	public static final String INSERT_JUEGO_NIVEL_9_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'MASS EFFECT 3','3rd...','masseffect3',0)";
	public static final String INSERT_JUEGO_NIVEL_9_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'METROID PRIME 3 CORRUPTION','First-person action-adventure game developed by Retro Studios and published by Nintendo for the Wii video game console','metroid_prime_3',0)";
	public static final String INSERT_JUEGO_NIVEL_9_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'PRINCE OF PERSIA 3','3rd...','prince3',0)";
	public static final String INSERT_JUEGO_NIVEL_9_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'RYGAR','Action-platformer video game developed and published by Tecmo','rygar',0)";
	public static final String INSERT_JUEGO_NIVEL_9_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'THE LEGEND OF ZELDA WIND WAKER','Action-adventure video game developed by 2002, the subsidiary and distributed by Nintendo EAD','tloz_windwaker',0)";
	public static final String INSERT_JUEGO_NIVEL_9_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'VIEWTIFUL JOE','video game developed by Capcoms Production Studio 4 for the Nintendo GameCube','viewtifuljoe',0)";
	public static final String INSERT_JUEGO_NIVEL_9_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_9
			+ "'),'VIRTUA TENNIS','Virtua...','virutatennis',0)";

	// Inserts en la tabla juego (NIVEL 10)
	public static final String INSERT_JUEGO_NIVEL_10_1 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'CREEBIES','No clues on this level. Beat the challenge','creebies',0)";
	public static final String INSERT_JUEGO_NIVEL_10_2 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'DONKEY KONG 64','No clues on this level. Beat the challenge','donkey64',0)";
	public static final String INSERT_JUEGO_NIVEL_10_3 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'DUCK DODGERS','No clues on this level. Beat the challenge','duckdogers',0)";
	public static final String INSERT_JUEGO_NIVEL_10_4 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'FINAL FANTASY XII','No clues on this level. Beat the challenge','ffxii',0)";
	public static final String INSERT_JUEGO_NIVEL_10_5 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'GLIMMERATI','No clues on this level. Beat the challenge','glimmerati',0)";
	public static final String INSERT_JUEGO_NIVEL_10_6 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'GUITAR HERO METALLICA','No clues on this level. Beat the challenge','guitarherometallica',0)";
	public static final String INSERT_JUEGO_NIVEL_10_7 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'HALO 4','No clues on this level. Beat the challenge','hlao4',0)";
	public static final String INSERT_JUEGO_NIVEL_10_8 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'LEGEND OF THE DRAGON','No clues on this level. Beat the challenge','legendotdragon',0)";
	public static final String INSERT_JUEGO_NIVEL_10_9 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'MARIO POWER TENNIS','No clues on this level. Beat the challenge','mariopowertennis',0)";
	public static final String INSERT_JUEGO_NIVEL_10_10 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'MERCENARIES 2','No clues on this level. Beat the challenge','mercenaries2',0)";
	public static final String INSERT_JUEGO_NIVEL_10_11 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'METAL GEAR SOLID 4','No clues on this level. Beat the challenge','metal4',0)";
	public static final String INSERT_JUEGO_NIVEL_10_12 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'MICROMACHINES 64','No clues on this level. Beat the challenge','micromachines64',0)";
	public static final String INSERT_JUEGO_NIVEL_10_13 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'MORTAL KOMBAT 4','No clues on this level. Beat the challenge','mortal_kombat_4',0)";
	public static final String INSERT_JUEGO_NIVEL_10_14 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'NBA 2K12','No clues on this level. Beat the challenge','nba2k12',0)";
	public static final String INSERT_JUEGO_NIVEL_10_15 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'PAPER MARIO','No clues on this level. Beat the challenge','papermario',0)";
	public static final String INSERT_JUEGO_NIVEL_10_16 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'PERSONA 4','No clues on this level. Beat the challenge','persona4',0)";
	public static final String INSERT_JUEGO_NIVEL_10_17 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'PRO EVOLUTION SOCCER 6','No clues on this level. Beat the challenge','pes6',0)";
	public static final String INSERT_JUEGO_NIVEL_10_18 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'SPYRO 3 YEAR OF THE DRAGON','No clues on this level. Beat the challenge','spyro3yearofthedragon',0)";
	public static final String INSERT_JUEGO_NIVEL_10_19 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'TALES OF PHANTASIA','No clues on this level. Beat the challenge','talesofphantasia',0)";
	public static final String INSERT_JUEGO_NIVEL_10_20 = "INSERT INTO Juego (idNivelJuego,nombreJuego,pistaJuego,idDrawable,isRespondido) VALUES ((SELECT idNivel FROM Nivel WHERE nombreNivel = '"
			+ ConstantesParametros.LEVEL_10
			+ "'),'TEKKEN 6','No clues on this level. Beat the challenge','tekken6',0)";

}
