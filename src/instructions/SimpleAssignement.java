package instructions;

import exceptions.ArrayException;
import terms.Term;
import terms.TermParser;

public class SimpleAssignement implements Instruction {

	private String varName;
	private Term rhs;
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3)
			return null;
		else {
			//...
			Term term = TermParser.parse(words[2]);
			lexParser.increaseProgramCounter();
			//...
		}
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
