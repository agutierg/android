package com.agutierg.misperiodicosyrevistaspro.constants;

public class ConsultasSQL {

	// Tablas de la base de datos
	public static final String CREATE_TABLA_PUBLICACION = "CREATE TABLE [Publicacion] ([idPublicacion] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,[descripcion] VARCHAR(255)  NOT NULL,[url] VARCHAR(255)  NOT NULL,[tipoPublicacion] VARCHAR(20)  NOT NULL,[isFavorito] BOOLEAN  NOT NULL)";

	// Insert para los PERIODICOS (tipoPublicacion = 1)
	public static final String INSERT_PERIODICO_EL_MUNDO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Mundo','http://www.elmundo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_PAIS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El País','http://elpais.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_ABC = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('ABC','http://www.abc.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_20_MINUTOS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('20 Minutos','http://m.20minutos.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_QUE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Qué','http://www.que.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_RAZON = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Razón','http://www.larazon.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_VANGUARDIA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Vanguardia','http://www.lavanguardia.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_CORREO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Correo','http://www.elcorreo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_PERIODICO_COM = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('elPeriódico.com','http://www.elperiodico.com/es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_HERALDO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Heraldo','http://www.heraldo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_GACETA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Gaceta','http://www.intereconomia.com/la-gaceta',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_VOZ_DE_GALICIA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Voz de Galicia','http://www.lavozdegalicia.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_CANARIAS_7 = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Canarias 7','http://www.canarias7.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_DIARIO_VASCO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Diario Vasco','http://www.diariovasco.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_DIARIO_DE_SEVILLA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Diario de Sevilla','http://www.diariodesevilla.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_COMERCIO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Comercio','http://www.elcomercio.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_DIARIO_MONTANES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Diario Montañés','http://www.eldiariomontanes.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_MEDITERRANEO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mediterráneo','http://www.elperiodicomediterraneo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_PERIODICO_ARAGON = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Periódico de Aragón','http://www.elperiodicodearagon.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_FARO_DE_VIGO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Faro de Vigo','http://www.farodevigo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_NUEVA_ESPANA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Nueva España','http://www.lne.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_REGION = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Región','http://www.laregion.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LEVANTE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Levante','http://www.levante-emv.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_ATLANTICO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Atlántico','http://www.atlantico.net/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_DEIA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Deia','http://www.deia.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_ALTO_ARAGON = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Alto Aragón','http://www.diariodelaltoaragon.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_PERIODICO_CAT = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('elPeriódico.cat','http://www.elperiodico.cat/ca/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_PERIODICO_EXTREMADURA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Periódico Extremadura','http://www.elperiodicoextremadura.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_PUNT_AVUI = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Punt Avui','http://www.elpuntavui.cat/barcelona/nacional.html',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_LA_VANGUARDIA_CAT = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Vanguardia Catalunya','http://www.lavanguardia.com/edicioimpresa/index.html',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_VILA_WEB = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Vila Web','http://www.vilaweb.cat/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_CINCO_DIAS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Cinco Días','http://www.cincodias.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EL_ECONOMISTA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Economista','http://www.eleconomista.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";
	public static final String INSERT_PERIODICO_EXPANSION = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Expansión','http://www.expansion.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO + ",0)";

	// Insert para las REVISTAS (tipoPublicacion = 2)
	public static final String INSERT_REVISTA_INTERVIEW = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Interview','http://www.interviu.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_EMPRENDEDORES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Emprendedores','http://www.emprendedores.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_ACTUALIDAD_ECONOMICA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Actualidad Económica','http://www.actualidadeconomica.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_CLIO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Clio','http://www.cliorevista.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_CRECER_FELIZ = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Crecer Feliz','http://www.crecerfeliz.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_SER_PADRES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Ser Padres','http://www.serpadres.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_DISENO_INTERIOR = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Diseño Interior','http://www.disenointerior.es/Diseno_Interior_Arquitectura_interiorismo_y_diseno.htm',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_CASA_DIEZ = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Casa Diez','http://casadiez.elle.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_CASA_ESTILO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Casa y Estilo','http://www.casaestilo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_MI_CASA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mi Casa','http://www.micasarevista.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_CASA_CAMPO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Casa y Campo','http://www.globuscom.es/CASAampCAMPO.htm',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_ELLE_DECOR = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Elle Decor','http://www.elle.es/elledeco',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_NUEVO_ESTILO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Nuevo Estilo','http://www.nuevo-estilo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_EL_JUEVES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Jueves','http://www.eljueves.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_EL_RELLANO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Rellano','http://www.elrellano.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_FHM = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('FHM','http://www.fhm.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_GQ = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('GQ Men Style','http://www.revistagq.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_VIDA_PREMIUM = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Vida Premium','http://www.vidapremium.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_MAXWELL = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Maxwell','http://www.grupomaxwell.com.mx/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_SOHO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Soho','http://www.soho.com.co/home',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_VAVEL = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Vavel','http://www.vavel.com/es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_FUTBOL_TOTAL = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Futbol Total','http://www.futboltotal.com.mx/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";
	public static final String INSERT_REVISTA_WINDSURF = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Windsurf','http://www.windsurfesp.com/default.asp',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA + ",0)";

	// Insert para los PERIÓDICOS DEPORTIVOS (tipoPublicacion = 3)
	public static final String INSERT_PERIODICO_DEPORTIVO_MARCA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Marca','http://www.marca.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_AS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('As','http://www.as.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_MUNDO_DEPORTIVO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mundo Deportivo','http://www.mundodeportivo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_SUPERDEPORTE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Superdeporte','http://www.superdeporte.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_SPORT = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Sport','http://www.sport.es/es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_CANAL_DEPORTIVO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Canal Deportivo','http://www.canaldeportivo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_MUNDO_ATLETICO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mundo Deportivo Atletico Madrid','http://www.mundodeportivo.com/atletico-madrid/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_MUNDO_ATLETIC = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mundo Deportivo Athletic Bilbao','http://www.mundodeportivo.com/athletic-bilbao/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_MUNDO_REAL_SOCIEDAD = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mundo Deportivo Real Sociedad','http://www.mundodeportivo.com/real-sociedad/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";
	public static final String INSERT_PERIODICO_DEPORTIVO_ESTADO_DEPORTIVO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Estadio Deportivo','http://www.estadiodeportivo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PERIODICO_DEPORTIVO + ",0)";

	// Insert para las REVISTAS DEL CORAZÓN (tipoPublicacion = 4)
	public static final String INSERT_REVISTA_CORAZON_AR = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('AR','http://www.ar-revista.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_CUORE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Cuore','http://www.revistacuore.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_HOLA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Hola','http://www.hola.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_COSMOPOLITAN = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Cosmopolitan','http://www.cosmohispano.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_ELLE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Elle','http://www.elle.es/revista-elle',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_LOVE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Love','http://www.revistalove.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_MARIE_CLAIRE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Marie Claire','http://www.marie-claire.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_SEMANA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Semana','http://www.semana.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_SUPER_POP = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Super Pop','http://www.superpop.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_DIEZ_MINUTOS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Diez Minutos','http://www.diezminutos.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_SALVAME = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Sálvame','http://www.telecinco.es/salvame/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";
	public static final String INSERT_REVISTA_CORAZON_VOGUE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Vogue','http://www.vogue.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CORAZON + ",0)";

	// Insert para las PRENSA EXTRAJERA (tipoPublicacion = 5)
	public static final String INSERT_PRENSA_EXT_LA_NACION = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Nación (Argentina)','http://www.lanacion.com.ar/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_EL_DIARIO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Diario (Bolivia)','http://www.eldiario.net/noticias/2013/2013_02/nt130218/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_TGAM = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Globe And Mail (Canadá)','http://www.theglobeandmail.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_EL_TIEMPO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Tiempo (Colombia)','http://www.eltiempo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_EL_PERIODICO_MEX = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Periódico de México (México)','http://www.elperiodicodemexico.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_EL_UNIVERSAL = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Universal (México)','http://www.eluniversal.com.mx/noticias.html',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_LA_NACION_PA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La Nación (Paraguay)','http://www.lanacion.com.py/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_LA_REPUBLICA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('La República (Perú)','http://www.larepublica.pe/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_DIA_EL_PAIS = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El País (Uruguay)','http://www.elpais.com.uy/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_TNYT = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The New York Times (USA)','http://www.nytimes.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_EL_UNI_VENEZUELA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('El Universal (Venezuela)','http://www.eluniversal.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_CNN = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('CNN (Español)','http://cnnespanol.cnn.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_THE_TIMES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Times (Inglaterra)','http://www.thetimes.co.uk/tto/news/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_THE_SUN = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Sun (Inglaterra)','http://www.thesun.co.uk/sol/homepage/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_THE_INDEPENDENT = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Independent (Inglaterra)','http://www.independent.co.uk/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_CORRIERE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Corriere (Italia)','http://www.corriere.it/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_THE_TIMES_INDIA = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Times Of India (India)','http://timesofindia.indiatimes.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_MORGEN_POST = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Berliner Morgenpost (Alemania)','http://www.morgenpost.de/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_WASHINGTON = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Washington Post (USA)','http://www.washingtonpost.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_THE_TELEGRAPH = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Telegraph (Inglaterra)','http://www.telegraph.co.uk/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_LE_MONDE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Le Monde (Francia)','http://www.lemonde.fr/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_COURRIER_PICARD = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Courrier Picard (Francia)','http://www.courrier-picard.fr/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_JAPAN_TIMES = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('The Japan Times (Japón)','http://www.japantimes.co.jp/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";
	public static final String INSERT_PRENSA_EXT_O_GLOBO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('O Globo (Brasil)','http://oglobo.globo.com/',"
			+ ConstantesVariables.TIPO_PUBLICACION_PRENSA_EXTRAJERA + ",0)";

	// Insert para las REVISTAS CIENTIFICAS (tipoPublicacion = 6)
	public static final String INSERT_REVISTA_CIENTIFICA_MUY_INTERESANTE = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Muy Interesante','http://www.muyinteresante.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA + ",0)";
	public static final String INSERT_REVISTA_CIENTIFICA_QUO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Quo','http://www.quo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA + ",0)";
	public static final String INSERT_REVISTA_CIENTIFICA_PC_WORLD = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('PC World','http://www.idg.es/pcworld/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA + ",0)";
	public static final String INSERT_REVISTA_CIENTIFICA_COMPUTING = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Computing','http://www.computing.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA + ",0)";
	public static final String INSERT_REVISTA_CIENTIFICA_MUNDO_GEO = "INSERT INTO Publicacion (descripcion,url,tipoPublicacion,isFavorito) VALUES ('Mundo Geo','http://www.mundo-geo.es/',"
			+ ConstantesVariables.TIPO_PUBLICACION_REVISTA_CIENTIFICA + ",0)";

}
