package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Store extends ByteCodeOneParameter {

	public Store() {}
	
	public Store(int param) {
		super(param);
	}


	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.write(this.param);
	}

	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("STORE"))
			return new Store(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "STORE";
	}

}
