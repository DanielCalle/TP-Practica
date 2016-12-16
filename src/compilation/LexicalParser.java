package compilation;

import exceptions.LexicalAnalysisException;

public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey)
					throws LexicalAnalysisException {
		//...
		While (this.programCounter < sProgram.getNumInstr()&&...){
			String instr = sProgram.getInstruction(this.programCounter);
			if (instr.equalsIgnoreCase(stopKey)) {
				stop = true;
			}
			else {
				Instruction instruction = ParserInstrucion.parse(instr, this);
				//Añadir instruccion a pProgram
			}
		}
		//...
	}
	
	public void increaseProgramCounter(){
		this.programCounter++;
	}
	//...
}
