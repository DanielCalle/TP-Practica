package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

abstract public class Arithmetics extends ByteCode {

	protected int n1;
	protected int n2;

	@Override
	public boolean execute(CPU cpu) {
		if(cpu.getSizeStack()>=2){ 
			cpu.increaseProgramCounter();
			n1 = cpu.pop();
			n2 = cpu.pop();
			return execute(n2, n1, cpu);
		}
		else
			return false;
		}

	abstract protected boolean execute(int n1, int n2, CPU cpu);

	@Override
	public ByteCode parse(String[] words) {
		if(words.length!=1) return null;
		else return this.parseAux(words[0]);
	}
	
	abstract public ByteCode parseAux(String string1);
}
