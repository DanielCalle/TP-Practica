package commands;

import main.Engine;

/**
 * Comando que permite sustituir una instrucción de nuestro programa por otra nueva.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Replace extends Command {

	private int argument;
	
	/**
	 * Constructora por defecto de Replace.
	 */
	public Replace() {}
	
	/**
	 * Constructora de Replace con parámetro.
	 * @param argument argumento que se utiliza en este comando.
	 */
	public Replace(int argument) {
		this.argument = argument;
	}
	
	/**
	 * Texto de ayuda del comando.
	 * @return Deuvelve el texto de la ayuda correspondiente al comando.
	 */
	@Override
	public String textHelp() {
		return "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario." + System.getProperty("line.separator");
	}

	/**
	 * Parseador del comando.
	 * @param s Recive un array de strings que contiene lo introducido en el prompt.
	 * @return Devuelve un nuevo comando de este tipo si es posible parsearse, si no devuelve null.
	 */
	@Override
	public Command parse(String[] s) {
		if( s[0].equalsIgnoreCase("REPLACE") && s.length == 2 ) {
			return new Replace(Integer.parseInt(s[1])); 
		}
		else 
			return null;
	}

	/**
	 * Ejecutor del comando.
	 * @param engine Recive el motor del programa.
	 * @return Devuelve un booleano que indica si la ejecución del comando fue exitosa o no.
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(this.argument);
	}
	
	/**
	 * Nombre del comando.
	 * @return Devuelve el nombre del comando y su argumento en forma de cadena de texto.
	 */
	@Override
	public String toString() {
		return "REPLACE" + " " + this.argument;
	}
}
