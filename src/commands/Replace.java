package commands;

import main.Engine;

public class Replace extends Command {

	private int argument;
	
	public Replace() {}
	
	public Replace(int argument) {
		this.argument = argument;
	}
	
	@Override
	public String textHelp() {
		return "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("REPLACE") == 0 && s.length == 2 ) {
			return new Replace(Integer.parseInt(s[1])); 
		}
		else 
			return null;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(this.argument);
	}
	
	@Override
	public String toString() {
		return "REPLACE" + " " + this.argument;
	}
}
