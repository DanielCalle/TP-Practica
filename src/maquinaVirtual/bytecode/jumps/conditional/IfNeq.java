package maquinaVirtual.bytecode.jumps.conditional;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class IfNeq extends ConditionalJumps {

	public IfNeq(int param) {
		super("INEQ", param);
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		if (c != sc)
			return cpu.setProgramCounter(this.param);
		else
			return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("IFNEQ") == 0)
			return new IfNeq(Integer.parseInt(s[1]));
		else
			return null;
	}

}
