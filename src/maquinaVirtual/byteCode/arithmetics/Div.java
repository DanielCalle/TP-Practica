package maquinaVirtual.byteCode.arithmetics;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;
import maquinaVirtual.byteCode.Arithmetics;

/**
 * Created by danie on 20/11/2016.
 */
public class Div extends Arithmetics {

	public Div() {
		super("DIV");
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		if (op1 == 0)
			return false;
		else
			return cpu.push(this.op2 / this.op1);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("DIV") == 0)
			return new Div();
		else
			return null;
	}

}
