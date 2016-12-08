package commands;

import main.Engine;

/**
 * Representa los distintos comandos que puede utilizar un usuario.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public abstract class Command {
	abstract public String textHelp();
	abstract public Command parse(String[] s);
	abstract public boolean execute(Engine engine);
}
