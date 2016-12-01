package commands;

import main.Engine;

public class Quit extends Command {
	
	@Override
	public String textHelp() {
		return "QUIT: Cierra la aplicación." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("QUIT") == 0 && s.length == 1 ) return new Quit(); else return null;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	@Override
	public String toString() {
		return "QUIT";
	}
	
}
