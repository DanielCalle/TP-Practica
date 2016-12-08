package main;

import bytecodes.ByteCode;

/**
 * Implementacion de la clase ByteCodeProgram
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class ByteCodeProgram {

	private int numInstr;
	private ByteCode[] program;
	private static int MAX_INSTR = 100;
	
	/**
	 * Constructor generico para ByteCodeProgram
	 */
	public ByteCodeProgram() {
		this.numInstr = 0;
		this.program = new ByteCode[ByteCodeProgram.MAX_INSTR];
	}
	
	/**
	 * Devuelve el numero de instrucciones que tiene el programa
	 * @return número de instrucciones
	 */
	public int getNumInstr() {
		return this.numInstr;
	}
	
	/**
	 * Devuelve la instruccion de una posicion determinada
	 * @param pos posicion de la instrucción
	 * @return si la instruccion existe devuelve esta y si no null 
	 */
	public ByteCode getInstruction(int pos) {
		if (0 <= pos && pos < this.numInstr)
			return program[pos];
		else
			return null;
	}

	/**
	 * Añade una instrucción al programa
	 * @param instruction instancia de la clase ByteCode
	 * @return devuelve true si la ejecucion es correcta o de lo contrario false
	 */
	public boolean add(ByteCode instruction) {
		if(this.numInstr >= ByteCodeProgram.MAX_INSTR)
			return false;
		else {
			this.program[this.numInstr] = instruction;
			this.numInstr++;
			return true;
		}
	}
	/**
	 * Remplaza una instrucción de una posición determinada
	 * @param instruction instancia de la clase ByteCode
	 * @param programLine posición de la isntrucción
	 * @return si la posición existe devuelve true si no devuelve false
	 */
	public boolean replace(ByteCode instruction, int programLine) {
		if (0 <= programLine && programLine < this.numInstr) {
			this.program[programLine] = instruction;
			return true;
		}
		else
			return false;
	}

	/**
	 * Cambia a null todos los elementos del programa
	 */
	public void reset() {
		this.numInstr = 0;
	}

	/**
	 * Devuelve un string con las instrucciones del programa
	 * @return un string que describe el objeto
	 */
	public String toString() {
		if (numInstr == 0)
			return "";
		else {
			String s = "Programa almacenado:" + System.getProperty("line.separator");
			for (int i = 0; i < this.numInstr; i++)
				s += i + ": " + this.program[i] + System.getProperty("line.separator");
	
			return s;
		}
	}

}