package maquinaVirtual;
import maquinaVirtual.enums.ENUM_COMMAND;

/**
 * Representa los distintos comandos que puede utilizar un usuario.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public abstract class Command {
	abstract public String textHelp();
	abstract public Command parse(String[] s);
	abstract public boolean execute(Engine engine);
}
