package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Load extends ByteCodeOneParameter {

	public Load() {}
	
	public Load(int param) {
		super(param);
	}
	
	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.push(cpu.read(this.param));
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "LOAD";
	}

}
