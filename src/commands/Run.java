package commands;

import main.Engine;

public class Run extends Command {

	public Run() {
		super();
	}
	
	@Override
	public String textHelp() {
		return "RUN: Ejecuta el programa." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("RUN") == 0 && s.length == 1 ) return new Run(); else return null;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeRun(); 
	}
	
	@Override
	public String toString() {
		return "RUN";
	}

}
