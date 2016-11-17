package maquinaVirtual;
import maquinaVirtual.enums.ENUM_COMMAND;

/**
 * Representa los distintos comandos que puede utilizar un usuario.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class Command {

	private int replace;
	private ENUM_COMMAND command;
	
	/**
	 * Constructora para QUIT, HELP, RUN, BYTECODE y RESET.
	 * @param command constante que representa al comando
	 */
	public Command(ENUM_COMMAND command) {
		this.command = command;
		this.replace = -1;
	}

	/**
	 * Constructora para REPLACE.
	 * @param command constante que representa al comando
	 * @param replace instancia de la clase ByteCode
	 */
	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}

	/**
	 * Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
	 * En caso de que la ejecución del comando sea incorrecta, el método devuelve false.
	 * En otro caso devuelve true.
	 * @param engine una instancia de la clase Engine
	 * @return si la ejecucion es correcta, retorna true, si no, retorna false.
	 */
	public boolean execute(Engine engine) {

		switch (this.command) {
	
			case HELP:
				return Engine.executeHelp();
	
			case QUIT:
				return engine.executeQuit();

			case RESET:
				return engine.executeReset();
	
			case RUN:
				return engine.executeRun();

			case BYTECODE:
				return engine.readByteCodeProgram();

			case REPLACE:
				return engine.executeReplace(this.replace); 

			default:
				return false;

		}

	}

	/**
	 * Devuelve el string del comando junto a sus atributos
	 * @return un string que describe el objeto 
	 */
	public String toString() {
		return this.command.name();
	}

}
