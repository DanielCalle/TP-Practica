package commands;

import main.Engine;

/**
 * Comando que muestra por pantalla la ayuda del intérprete de comandos.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Help extends Command {

	/**
	 * Texto de ayuda del comando.
	 * @return Deuvelve el texto de la ayuda correspondiente al comando.
	 */
	@Override
	public String textHelp() {
		return "HELP: Muestra esta ayuda." + System.getProperty("line.separator");
	}

	/**
	 * Parseador del comando.
	 * @param s Recive un array de strings que contiene lo introducido en el prompt.
	 * @return Devuelve un nuevo comando de este tipo si es posible parsearse, si no devuelve null.
	 */
	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("HELP") == 0 && s.length == 1 ) return new Help(); else return null;
	}

	/**
	 * Ejecutor del comando.
	 * @param engine Recive el motor del programa.
	 * @return Devuelve un booleano que indica si la ejecución del comando fue exitosa o no.
	 */
	@Override
	public boolean execute(Engine engine) {
		CommandParser.showHelp();
		return true;
	}

	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando en forma de cadena de texto.
	 */
	@Override
	public String toString() {
		return "HELP";
	}
	
}
