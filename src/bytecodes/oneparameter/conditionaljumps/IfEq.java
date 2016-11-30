package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;

public class IfEq extends ConditionalJumps {

	public IfEq() {}
	
	public IfEq(int param) {
		super(param);
	}
	
	@Override
	protected boolean compare(int n1, int n2) {
		return n1==n2;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFEQ"))
			return new IfEq(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "IFEQ";
	}
	
}
