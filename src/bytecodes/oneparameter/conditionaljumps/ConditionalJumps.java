package bytecodes.oneparameter.conditionaljumps;

import bytecodes.oneparameter.ByteCodeOneParameter;
import cpu.CPU;

abstract public class ConditionalJumps extends ByteCodeOneParameter {
	
	public ConditionalJumps() {}

	public ConditionalJumps(int j) {
		super(j);
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getSizeStack() >= 2){
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			if (!compare(n2,n1))
				cpu.setProgramCounter(this.param);
			else
				cpu.increaseProgramCounter();
			return true;
		}
		else
			return false;
	}

	abstract protected boolean compare(int n1, int n2);
}
