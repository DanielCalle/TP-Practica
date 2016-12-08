package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Implementacion de la clase Mul
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Mul extends Arithmetics {

	@Override
	public ByteCode parseAux(String s) {
		if (s.equalsIgnoreCase("MUL"))
			return new Mul();
		else
			return null;
	}

	@Override
	protected boolean execute(int n1, int n2, CPU cpu) {
		return cpu.push(n1*n2);
	}
	
	@Override
	public String toString() {
		return "MUL";
	}
	
}
