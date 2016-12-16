package instructions;

import compilation.LexicalParser;
import exceptions.ArrayException;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(Compiler compiler) throws ArrayException;
}