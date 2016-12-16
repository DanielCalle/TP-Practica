package instructions;

import compilation.LexicalParser;
import compilation.ParsedProgram;
import conditions.Condition;
import exceptions.ArrayException;


public class IfThen implements Instruction {

	private Condition condition;
	private ParsedProgram ifBody;
	
	@Override
	public Instruction lexParse(String[] words, instructions.LexicalParser lexParser) {
		//...
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		this.condition.compile(compiler);
		compiler.compile(this.ifBody);
		this.condition.setJump(compiler.getProgramCounter());
		
	}

}
