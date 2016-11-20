package maquinaVirtual.byteCode.arithmetics;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;
import maquinaVirtual.byteCode.Arithmetics;

/**
 * Created by danie on 20/11/2016.
 */
public class Sub extends Arithmetics {

	public Sub() {
		super("SUB");
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		return cpu.push(this.op2 - this.op1);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("SUB") == 0)
			return new Sub();
		else
			return null;
	}

}
