package maquinaVirtual.Commands;

import maquinaVirtual.Command;
import maquinaVirtual.CommandParser;
import maquinaVirtual.Engine;

public class Help extends Command {

	public Help() {
		super();
	}
	
	@Override
	public String textHelp() {
		return "HELP: Muestra esta ayuda." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("HELP") == 0 && s.length == 1 ) return new Help(); else return null;
	}

	@Override
	public boolean execute(Engine engine) {
		CommandParser.showHelp();
		return true;
	}

	@Override
	public String toString() {
		return "HELP";
	}
	
}
