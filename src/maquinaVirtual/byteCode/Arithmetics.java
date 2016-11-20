package maquinaVirtual.byteCode;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
abstract public class Arithmetics extends ByteCode {

	protected int op1;
	protected int op2;

	public Arithmetics(String name) {
		super(name);
	}

	@Override
	public boolean execute(CPU cpu) {
		op1 = cpu.pop();
		op2 = cpu.pop();
		return true;
	}

}
