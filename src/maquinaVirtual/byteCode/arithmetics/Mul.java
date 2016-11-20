package maquinaVirtual.byteCode.arithmetics;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;
import maquinaVirtual.byteCode.Arithmetics;

/**
 * Created by danie on 20/11/2016.
 */
public class Mul extends Arithmetics {

	public Mul() {
		super("MUL");
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		return cpu.push(this.op2 * this.op1);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("MUL") == 0)
			return new Mul();
		else
			return null;
	}

}
