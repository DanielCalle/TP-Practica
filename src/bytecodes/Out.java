package bytecodes;

import cpu.CPU;

/**
 * Implementacion de la clase Out
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Out extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		System.out.println(cpu.pop());
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else
			return null;
	}

	@Override
	public String toString() {
		return "OUT";
	}
	
}
