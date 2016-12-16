package compilation;

import bytecodes.ByteCode;
import main.ByteCodeProgram;

public class Compiler {
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVars;
	
	public void compile(ParsedProgram pProgram) throws ... {
		int i = 0;
		try {
			while (i < pProgram.getNumInstr()) {
				Instruction inst = pProgram.getInstruction(i);
				instr.compile(this);
				i++;
			}
		}
		catch ...
	}
	
	public void addByteCode(ByteCode bc) throws ... {
		//...
	}
	
	public int getIndex(String varName) {
		//...
	}
}
