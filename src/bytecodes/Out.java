package bytecodes;

import cpu.CPU;

/**
 * Created by danie on 20/11/2016.
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
