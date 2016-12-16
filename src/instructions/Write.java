package instructions;

public class Write implements Instruction {

	private String varName;
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		//...
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());
		
	}

}
