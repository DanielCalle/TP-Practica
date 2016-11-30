package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class GoTo extends ByteCodeOneParameter {
	
	public GoTo() {}
	
	public GoTo(int param) {
		super(param);
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.setProgramCounter(this.param);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("GOTO"))
			return new GoTo(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "GOTO";
	}

}
