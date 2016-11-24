package maquinaVirtual.bytecode;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Halt extends ByteCode {

	/**
	 * Constructor para Halt
	 */
	public Halt() {
		super("HALT");
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.setHalt();
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("HALT") == 0)
			return new Halt();
		else
			return null;
	}

}
