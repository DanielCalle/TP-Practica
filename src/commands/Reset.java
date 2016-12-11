package commands;

import main.Engine;

/**
 * Comando que vacía el programa actual.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Reset extends Command {

	/**
	 * Texto de ayuda del comando.
	 * @return Deuvelve el texto de la ayuda correspondiente al comando.
	 */
	@Override
	public String textHelp() {
		return "RESET: Vacía el programa actual." + System.getProperty("line.separator");
	}

	/**
	 * Parseador del comando.
	 * @param s Recive un array de strings que contiene lo introducido en el prompt.
	 * @return Devuelve un nuevo comando de este tipo si es posible parsearse, si no devuelve null.
	 */
	@Override
	public Command parse(String[] s) {
		if( s[0].equalsIgnoreCase("RESET") && s.length == 1 ) return new Reset(); else return null;
	}

	/**
	 * Ejecutor del comando.
	 * @param engine Recive el motor del programa.
	 * @return Devuelve un booleano que indica si la ejecución del comando fue exitosa o no.
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}
	
	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando en forma de cadena de texto.
	 */
	@Override
	public String toString() {
		return "RESET";
	}

}
