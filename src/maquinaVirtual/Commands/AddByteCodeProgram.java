package maquinaVirtual.Commands;

import maquinaVirtual.Command;
import maquinaVirtual.Engine;

public class AddByteCodeProgram extends Command {
	
	public AddByteCodeProgram() {
		super();
	}
	
	@Override
	public String textHelp() {
		return "BYTECODE: Instroduce una nueva instrucción al programa." + System.getProperty("line.separator");
	}

	@Override
	public Command parse(String[] s) {
		if( s[0].compareToIgnoreCase("BYTECODE") == 0 && s.length == 1 ) return new AddByteCodeProgram(); else return null;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.readByteCodeProgram();
	}
	
	@Override
	public String toString() {
		return "BYTECODE";
	}

}
