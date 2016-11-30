package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

abstract public class Arithmetics extends ByteCode {

	protected int n1;
	protected int n2;

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		n1 = cpu.pop();
		n2 = cpu.pop();
		return executeAux(n2, n1, cpu);
	}

	abstract protected boolean executeAux(int n1, int n2, CPU cpu);
	
}
