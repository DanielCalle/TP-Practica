package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfLeq extends ConditionalJumps {

	public IfLeq() {}
	
	public IfLeq(int param) {
		super(param);
	}
	
	@Override
	protected boolean compare(int n1, int n2) {
		return n1<=n2;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFLEQ"))
			return new IfLeq(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "IFLEQ";
	}
	
}
