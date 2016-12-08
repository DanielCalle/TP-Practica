package bytecodes;

import cpu.CPU;

/**
 * Implementacion de la clase Halt
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
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
