package commands;

import main.Engine;

/**
 * Representa los distintos comandos que puede utilizar un usuario.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public interface Command {
	public String textHelp();
	public Command parse(String[] s);
	public boolean execute(Engine engine);
}
