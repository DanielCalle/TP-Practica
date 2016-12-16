package instructions;

import compilation.ParsedProgram;
import conditions.Condition;

public class While implements Instruction {

	private Condition condition;
	private ParsedProgram whileBody;
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		//...
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDWHILE");
		lexParser.increasePrograCounter();
		//...
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
