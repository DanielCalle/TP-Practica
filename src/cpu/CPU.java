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
 * @version 2.0, 08/12/2016
 */
public class CPU {
	
	private boolean halt = false;
	private int programCounter = 0;
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private ByteCodeProgram bcProgram;

	/**
	 * Constructora por defecto, recive el programa de ByteCodes.
	 * @param program Recive como parámetro el programa de Bytecodes.
	 */
	public CPU(ByteCodeProgram program){ this.bcProgram = program;}

	/**
	 * Ejecuta el programa almacenado.
	 * @return Deuelve un booleano que indica si la ejecución del programa tuvo o no errores.
	 */
	public boolean run() {
		this.reset();
		this.halt = false;
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

	/**
	 * Indica a la pila que se ha de guardar en ella un nuevo dato.
	 * @param n Dato a apilar.
	 * @return Devuelve un booleano que indica si el dato se pudo apilar.
	 */
	public boolean push(int n) {
		return this.stack.push(n);
	}

	/**
	 * Indica a la pila que se ha de desapilar el dato de su cima.
	 * @return Deuelve un booleano que indica si el dato se pudo desapilar correctamente.
	 */
	public int pop(){
		return this.stack.pop();
	}

	/**
	 * Lee de la memoria el dato de una determinada posición.
	 * @param n Posición de la que hemos de leer el dato.
	 * @return Devuelve un booleano que indica si el dato se pudo leer de forma correcta.
	 */
	public int read(int n) {
		return this.memory.read(n);
	}

	/**
	 * Escribe en una determinada posición de memoria un dato.
	 * @param n Posición en la que escribir el dato.
	 * @return Deuelve un booleano que indica si se pudo escribir correctamente en memoria.
	 */
	public boolean write(int n) {
		return this.memory.write(n, this.stack.pop());
	}

	/**
	 * Añade un nuevo ByteCode al programa.
	 * @param bc Recive el nuevo ByteCode a almacenar en el programa actual.
	 * @return Deuelve un booleano que indica si el ByteCode se pudo ingresar o no en el programa. 
	 */
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

	/**
	 * Establece la línea de programa a ejecutarse.
	 * @param programCounter Número de línea que ha de ejecutarse.
	 * @return Devuelve un booleano que indica si se pudo establecer el nuevo valor del contador de programa.
	 */
	public boolean setProgramCounter(int programCounter) {
		
		if( programCounter < this.bcProgram.getNumInstr() && programCounter >= 0) {
			this.programCounter = programCounter;
			return true;
		}
		else
			return false;
	}

	/**
	 * Incrementa el contador de programa.
	 */
	public void increaseProgramCounter(){
		this.programCounter++;
	}

	/*
	 * Devuelve un booleano que indica si el programa ha de terminar o no.
	 */
	public boolean isHalt() {
		return this.halt;
	}

	/*
	 * Establece que el programa ha de terminar.
	 */
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

	/**
	 * Obtiene el nuemero de elementos de la pila.
	 * @return Devuelve el número de elementos que contiene la pila.
	 */
	public int getSizeStack() {
		return this.stack.getNumElems();
	}

}