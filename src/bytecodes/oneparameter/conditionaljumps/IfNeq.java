package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfNeq extends ConditionalJumps {

	public IfNeq() {}
	
	public IfNeq(int param) {
		super(param);
	}
	
	@Override
	protected boolean compare(int n1, int n2) {
		return n1!=n2;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFNEQ"))
			return new IfNeq(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "IFNEQ";
	}

}
