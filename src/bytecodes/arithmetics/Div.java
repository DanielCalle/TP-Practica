package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Div extends Arithmetics {

	public Div() {}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("DIV"))
			return new Div();
		else
			return null;
	}

	@Override
	protected boolean executeAux(int n1, int n2, CPU cpu) {
		if (n2 == 0)
			return false;
		else
			return cpu.push(n1 / n2);
	}

	@Override
	public String toString() {
		return "DIV";
	}
	
}
