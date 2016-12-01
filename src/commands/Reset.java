package commands;

import main.Engine;

public class Reset extends Command {

	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("RESET") == 0 && s.length == 1 ) return new Reset(); else return null;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}
	
	@Override
	public String toString() {
		return "RESET";
	}

}
