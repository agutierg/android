package com.agutierg.comuniopuntos.constants;

public class ConstantesParametros {

	// Constantes relativas a la consulta Web, PUNTOS
	public static final String FIN_PUNTOS = "</td>";
	public static final String FIN_JUGADOR = "\" style=\"";
	public static final String FIN_JUGADOR_INFO = "</a></td>";
	public static final String COMIENZO_PUNTOS = "<div class=\"puntos\"(.*)span>";
	public static final String COMIENZO_JUGADOR = "<a title=\"Ver estad�sticas de ";
	public static final String COMIENZO_Y_FIN_EQUIPOS = "grande/(.*).png\"  alt=";
	public static final String COMIENZO_EQUIPOS_INFO = "grande/(.*)";
	public static final String FIN_EQUIPOS_INFO = ".png' title=";
	public static final String COMIENZO_Y_FIN_JORNADA = "<a  class='jornadaActual'  href='index.php?idJornada=(.*)'>";
	public static final String DIRECCION_WEB = "http://www.calculapuntoscomunio.com/puntos/";
	public static final String CADENA_PARTIR_TEXTO_INICIAL = "<img width=\"50px\" src=\"../images/escudos/";
	public static final String CADENA_PARTIR_TEXTO_INICIAL_INFO = "<img src='http://s355609116.mialojamiento.es/primera/images/escudos/";
	public static final String SEPARADOR_APELLIDOS = "<br>";
	public static final String ETIQUETA_JUGADOR_ONCE_NEGRO = "negro_once";
	public static final String ETIQUETA_JUGADOR_ONCE_NONE = "none_once";
	public static final String ETIQUETA_JUGADOR_NEGRO = "negro";
	public static final String ETIQUETA_JUGADOR_NONE = "none";
	public static final String DESCARGANDO_PUNTOS = "Descargando Puntos...";

	// Para la JORNADA
	public static final String DIRECCION_WEB_JORNADA = "http://www.elpais.com/deportes/futbol/competicion/primera/";
	public static final String DESCARGANDO_INFO = "Descargando Informacion...";
	public static final String CLASIFICACION = "<div class=\"clasificacion-futbol\">(.*)<p class=\"vermas\">";
	public static final String RESULTADOS = "<div class=\"ultima-jornada\">(.*)<div class=\"proxima-jornada\">";
	public static final String PROX_JORNADA = "<div class=\"proxima-jornada\">(.*)<div class=\"bajo-proxima-jornada estirar\">";
	public static final String PATRON_NOMBRE = "<a class='nombreJugador' href='../estadisticas/jugador/";
	public static final String PATRON_ESTADO = "<img src='http://calculapuntoscomunio.com/images/estados/(.*)";
	public static final String PATRON_DESC1 = "<td class='descripcion' width='230px'>(.*)";
	public static final String PATRON_DESC2 = "<img  title='Detalles de la baja' src='../images/iconos/mini/lupa.png' /></td><td class='descripcion' width='230px'>(.*)";
	public static final String PATRON_FIN_ESTADO = ".png'";
	public static final String PATRON_FIN_DESC1 = "</td>";
	public static final String PATRON_FIN_DESC2 = "</td>";
	public static final String ESTADO_LESION = "lesion";
	public static final String ESTADO_DUDA = "molestias";
	public static final String ESTADO_ACUMULACION = "acum_tarjetas";
	public static final String ESTADO_DOBLE_AMARILLA = "doble_tarjeta";
	public static final String ESTADO_ROJA = "tarjeta_roja";
	public static final String ESTADO_NO_CONVOCADO = "no_convocado";
	public static final String ESTADO_FILIAL = "b";

	// Para la INFO DE JUGADORES
	public static final String DIRECCION_WEB_INFO_JUGADORES = "http://calculapuntoscomunio.com/estados/";
	public static final String DESCARGANDO_INFO_JUGADORES = "Descargando Informacion\nJugadores...";

	// Constantes paso par·metros activities
	public static final String EQUIPOS_Y_PUNTOS = "puntosYEquipos";
	public static final String EQUIPOS_Y_PUNTOS_JUGADOR = "EQUIPOS_Y_PUNTOS_JUGADOR";

	public static final String EQUIPO_SEL_ATHLETIC = "Athletic";
	public static final String EQUIPO_SEL_ATLETICO = "Atletico";
	public static final String EQUIPO_SEL_BARCELONA = "Barcelona";
	public static final String EQUIPO_SEL_CELTA = "celta";
	public static final String EQUIPO_SEL_ELCHE = "elche";
	public static final String EQUIPO_SEL_ESPANOL = "Espanyol";
	public static final String EQUIPO_SEL_GETAFE = "Getafe";
	public static final String EQUIPO_SEL_GRANADA = "Granada";
	public static final String EQUIPO_SEL_LEVANTE = "Levante";
	public static final String EQUIPO_SEL_MALAGA = "Malaga";
	public static final String EQUIPO_SEL_OSASUNA = "Osasuna";
	public static final String EQUIPO_SEL_RAYO = "rayo";
	public static final String EQUIPO_SEL_BETIS = "betis";
	public static final String EQUIPO_SEL_RMADRID = "R.Madrid";
	public static final String EQUIPO_SEL_VILLARREAL = "Villarreal";
	public static final String EQUIPO_SEL_RSOCIEDAD = "R.Sociedad";
	public static final String EQUIPO_SEL_VALLADOLID = "valladolid";
	public static final String EQUIPO_SEL_ALMERIA = "Almeria";
	public static final String EQUIPO_SEL_SEVILLA = "Sevilla";
	public static final String EQUIPO_SEL_VALENCIA = "Valencia";
	public static final String EQUIPO_ONCE_IDEAL = "Once Ideal";

	// Constantes relativas los CODES de las paginas
	public static final String CODE_VISTA_PUNTOS_GENERALES = "1";
	public static final String CODE_VISTA_PUNTOS_GENERALES_EQUIPOS = "2";
	public static final String CODE_VISTA_PUNTOS_ANADIR_EQUIPO = "3";
	public static final String CODE_VISTA_MIS_EQUIPOS = "4";
	public static final String CODE_VISTA_MODIFICAR_EQUIPO = "5";
	public static final String CODE_VISTA_ELIMINAR_EQUIPO = "6";
	public static final String CODE_VISTA_AYUDA = "7";
	public static final String CODE_VISTA_INFO_APLICACION = "8";
	public static final String CODE_VISTA_JORNADA = "9";
	public static final String CODE_VISTA_INFO_JUGADORES = "10";
	public static final String CODE_VISTA_RSS = "11";
	public static final String CODE_VISTA_POSIBLES_PUNT = "12";

	// Posiciones de los jugadores
	public static final String POSICION_PORTERO = "POR";
	public static final String POSICION_DEFENSA = "DEF";
	public static final String POSICION_MEDIO = "CEN";
	public static final String POSICION_DELANTERO = "DEL";
	public static final String POSICION_PORTERO_LONG = "Portero";
	public static final String POSICION_DEFENSA_LONG = "Defensa";
	public static final String POSICION_MEDIO_LONG = "Centrocampista";
	public static final String POSICION_DELANTERO_LONG = "Delantero";

	// Menu contextual boton jugador
	public static final String MENU_CONTEX_TEX = "Quieres eliminar el jugador?";
	public static final String MENU_CONTEX_OK = "Ok";
	public static final String MENU_CONTEX_CANCEL = "Cancel";

	// Menu contextual modificar jugador
	public static final String MENU_CONTEX_MOD = "Quieres modificar el jugador?";

	// El jugador no ha jugado aun
	public static final String NO_HA_JUGADO = "NO_HA_JUGADO";
	public static final String NO_JUGADO = "NO HA JUGADO";
	// Mensajes OK
	public static final String INSERT_EQUIPO_JUG_OK = "Equipo insertado correctamente";
	public static final String MODIF_EQUIPO_JUG_OK = "Equipo modificado correctamente";
	public static final String ELIMINAR_EQUIPO_JUG_OK = "Equipo eliminado correctamente";

	// Mensajes de error
	public static final String ERROR_MAX_PORTEROS = "Ya tienes un portero";
	public static final String ERROR_MAX_DEFENSAS = "Ya tienes 5 defensas";
	public static final String ERROR_MAX_CENTRO = "Ya tienes 5 medios";
	public static final String ERROR_MAX_DELANTEROS = "Ya tienes 3 delanteros";
	public static final String ERROR_JUGADOR_YA_ANADIDO = "Jugador ya agregado";
	public static final String EQUIPO_NO_JUGADO = "Aun no ha jugado";
	public static final String ERROR_ONCE_JUGADORES = "Ya has agregado 11 jugadores";
	public static final String ERROR_FALTAN_JUG = "Debes agregar 11 jugadores";
	public static final String ERROR_NOMBRE_EQUIPO = "Falta el nombre del equipo";
	public static final String ERROR_NOMBRE_EQUIPO_REPETIDO = "Nombre de equipo ya insertado";
	public static final String ERROR_ANADE_EQUIPO = "Primero agrega un equipo";
	public static final String ERROR_NO_JUG_NINGUN_EQUIPO = "No ha jugado ningun equipo";
	public static final String ERROR_NO_EQU_ELIMINAR = "No hay equipos que eliminar";

	public static final String EQUIPO_DESC = "Equipo: ";

	// DescripciÛn de la ayuda
	public static final String AYUDA_MIS_EQUIPOS = "Pantalla de Mis Equipos:\n\n - Visualiza la puntuacion de tus equipos insertados.\n - Para cambiar de equipo desliza a derecha o izquierda.\n - En la parte inferior, visualiza el nombre de tu equipo y la puntuacion total.";
	public static final String AYUDA_PUNTUACIONES_GENERALES = "Pantalla de Puntuaciones Generales:\n\n - Visualiza la puntuacion los equipos de la Liga.\n - Visualiza la puntuacion y el Once Ideal. \n - Elige el equipo del cual quieres visualizar la puntuacion.\n - Si el equipo aun no ha jugado, la aplicacion te informara.";
	public static final String AYUDA_ANADIR_EQUIPO = "Pantalla de Agregar Equipo:\n\n - Agrega tus equipos personalizados para despues poder verlos en \"Mis Equipos\".\n - Elige un nombre para tu equipo y agrega los jugadores.\n - Para eliminar un futbolista insertado manten presionado el icono hasta que te pregunte si quieres borrarlo. \n- No podras agregar mas de 11 futbolistas.";
	public static final String AYUDA_MODIFICAR_EQUIPO = "Pantalla de Modificar Equipo:\n\n - Modifica las alineaciones de tus equipos personalizados para despues poder verlos en \"Mis Equipos\".\n - Elige uno de tus equipos ya insertados.\n - Para modificar un futbolista pulsa el icono que quieras modificar y elige el nuevo futbolista.\n - Para eliminar un futbolista insertado manten presionado el icono hasta que te pregunte si quieres borrarlo. \n - No podras agregar mas de 11 futbolistas.";
	public static final String AYUDA_ELIMINAR_EQUIPO = "Pantalla de Eliminar Equipo:\n\n - Elimina uno de los equipos ya insertados.\n - Elige el equipo que quieres eliminar.\n - Eliminalo para que no salga en \"Mis Equipos\"";
	public static final String AYUDA_CAMPO = "Pantalla Informacion Jugadores:\n\n - Jugadores lesionados, sancionados o no convocados.\n\n\n Submenu\n\n - Accede a las Puntuaciones Instantaneas.\n - Accede a la Ultima hora de los equipos.\n - Accede a la Ultima hora de la Jornada.\n - Ayuda de la aplicacion.\n - Informacion de la Aplicacion.";

	// Descripcion de la informacion de la aplicacion
	public static final String INFO_APLICACION_MIO = "- App desarrollada por\n---GUTSAPPS---\n\n- Si te gusta y la utilizas agradeceria que la votaras y la recomendaras.\n\n-- GRACIAS POR HABERLA DESCARGADO!!! --";
	public static final String INFO_APLICACION_AGRADECIMIENTOS = "\n\n\n- Informacion y puntos extraidos de:\n\n --- http://calculapuntoscomunio.com/ ---\n\n --- http://www.futbolparacomunio.com/ ---";

	// Para la Rss
	public static final String WEB_RSS = "http://www.futbolparacomunio.com/ultimas-noticias/";

	// Para las posibles puntuaciones
	public static final String WEB_POSIBLES_PUNTUACIONES = "http://www.futbolparacomunio.com/puntos-comunio/";
}
