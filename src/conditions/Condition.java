package conditions;

import bytecodes.oneparameter.conditionaljumps.ConditionalJumps;
import compilation.LexicalParser;
import exceptions.ArrayException;
import terms.Term;

public abstract class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition; //para la compilacion
	
	public Condition parse(String t1, String op, String t2,
			LexicalParser parser) {
		//...
		return null;
	}
	
	public void compile(Compiler compiler) throws ArrayException {
		//...
	}
	
	//Otros metodos abstractos
	
}
