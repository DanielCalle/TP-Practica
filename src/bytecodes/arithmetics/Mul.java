package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public class Mul extends Arithmetics {

	public Mul() {}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("MUL"))
			return new Mul();
		else
			return null;
	}

	@Override
	protected boolean executeAux(int n1, int n2, CPU cpu) {
		return cpu.push(n1*n2);
	}
	
	@Override
	public String toString() {
		return "MUL";
	}
	
}
