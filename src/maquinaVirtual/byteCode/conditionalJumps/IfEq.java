package maquinaVirtual.byteCode.conditionalJumps;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;
import maquinaVirtual.byteCode.ConditionalJumps;

/**
 * Created by danie on 20/11/2016.
 */
public class IfEq extends ConditionalJumps {

	public IfEq(int param) {
		super("IFEQ", param);
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		if (c == sc)
			return cpu.setProgramCounter(this.param);
		else
			return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("IFEQ") == 0)
			return new IfEq(Integer.parseInt(s[1]));
		else
			return null;
	}

}
