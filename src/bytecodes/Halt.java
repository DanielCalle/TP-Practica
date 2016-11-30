package bytecodes;

import cpu.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Halt extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.setHalt();
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else
			return null;
	}

	@Override
	public String toString() {
		return "HALT";
	}

}
