package cpu;

import bytecodes.ByteCode;
import main.ByteCodeProgram;

/**
 * Es la unidad de procesamiento de nuestra máquina virtual. Contiene una
 * memoria, una pila de operandos y una varible booleana para determinar si la
 * ejecución ha terminado, es decir, si se ha ejecutado la instrucción HALT.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */

public class CPU {
	private boolean halt;
	private Memory memory;
	private OperandStack stack;
	private int programCounter = 0;
	private ByteCodeProgram bcProgram;

	public CPU() {
		this.halt = false;
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.bcProgram = new ByteCodeProgram();
	}

	public boolean run() {
		this.reset();
		this.programCounter = 0;
		boolean programStatusOkey = true;
		ByteCode currentInstruction;

		while (programStatusOkey && this.programCounter < this.bcProgram.getNumInstr() && !this.halt) {
			currentInstruction = this.bcProgram.getInstruction(this.programCounter);
			if (currentInstruction != null) {
				programStatusOkey = currentInstruction.execute(this);
				if (programStatusOkey) {
					System.out.println("El estado de la máquina tras ejecutar el bytecode "
							+ currentInstruction.toString() + " es:"
							+ System.getProperty("line.separator")
							+ System.getProperty("line.separator")
							+ this.toString()
							+ System.getProperty("line.separator"));
				}

			} else {
				programStatusOkey = false;
			}
		}

		return programStatusOkey;
	}

	public boolean push(int n) {
		return this.stack.push(n);
	}

	public int pop(){
		return this.stack.pop();
	}

	public int read(int n) {
		return this.memory.read(n);
	}

	public boolean write(int n) {
		return this.memory.write(n, this.stack.pop());
	}

	public boolean addByteCode(ByteCode bc) {
		return this.bcProgram.add(bc);
	}

	/**
	 * Borra los elementos de la pila y de la memoria.
	 */
	public void reset() {
		this.stack.reset();
		this.memory.reset();
	}

	public boolean setProgramCounter(int programCounter) {
		
		if( programCounter < this.bcProgram.getNumInstr() && programCounter >= 0) {
			this.programCounter = programCounter;
			return true;
		}
		else
			return false;
	}

	public void increaseProgramCounter(){
		this.programCounter++;
	}

	public ByteCodeProgram getBcProgram() {
		return this.bcProgram; 
	}

	public boolean isHalt() {
		return this.halt;
	}

	public void setHalt() {
		this.halt = true;
	}

	/**
	 * Devuelve un string con el estado de la CPU, los elementos de la memoria y de la pila.
	 * @return un string que describe el objeto
	 */
	public String toString() {
		return "Estado de la CPU:"
				+ System.getProperty("line.separator")
				+ "\tMemoria: " + this.memory.toString()
				+ System.getProperty("line.separator")
				+ "\tPila: " + this.stack.toString();
	}

	public int getSizeStack() {
		return this.stack.getNumElems();
	}

}