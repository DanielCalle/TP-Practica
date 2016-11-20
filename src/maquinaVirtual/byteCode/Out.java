package maquinaVirtual.byteCode;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Out extends ByteCode {

	/**
	 * Constructor para Out
	 */
	public Out() {
		super("OUT");
	}

	@Override
	public boolean execute(CPU cpu) {
		System.out.println(cpu.pop());
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("OUT") == 0)
			return new Out();
		else
			return null;
	}

}
