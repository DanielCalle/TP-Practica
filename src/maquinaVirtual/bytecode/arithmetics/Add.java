package maquinaVirtual.bytecode.arithmetics;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Add extends Arithmetics {

	public Add() {
		super("ADD");
	}

	@Override
	public boolean execute(CPU cpu) {
		super.execute(cpu);
		return cpu.push(this.op2 + this.op1);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("ADD") == 0) {
			return new Add();
		}
		return null;
	}

}
