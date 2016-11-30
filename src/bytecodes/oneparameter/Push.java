package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Push extends ByteCodeOneParameter {
	
	public Push() {}
	
	public Push(int param) {
		super(param);
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.push(this.param);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "PUSH";
	}

}
