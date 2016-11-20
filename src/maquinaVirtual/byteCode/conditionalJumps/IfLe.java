package maquinaVirtual.byteCode.conditionalJumps;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;
import maquinaVirtual.byteCode.ConditionalJumps;

/**
 * Created by danie on 20/11/2016.
 */
public class IfLe extends ConditionalJumps {

	public IfLe(int param) {
		super("IFLE", param);
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		if (c < sc)
			return cpu.setProgramCounter(this.param);
		else
			return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("IFLE") == 0)
			return new IfLe(Integer.parseInt(s[1]));
		else
			return null;
	}

}
