package maquinaVirtual;
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

	public CPU() {
		this.halt = false;
		this.memory = new Memory();
		this.stack = new OperandStack();
	}

	/**
	 * Es el encargado de ejecutar la instrucción que le llega como parámetro
	 * modificando convenientemente la memoria y/o la pila de operandos. Si la
	 * ejecución genera un error el método devuelve false.
	 * 
	 * @param instruction una instancia de la clase ByteCode
	 * @return un booleano que indica si la ejecución fue correcta
	 */
	public boolean execute(ByteCode instruction) {

		int data1, data2;

		if (isHalt())
			return true;
		else {
			switch (instruction.getName()) {
				case PUSH:
					return this.stack.push(instruction.getParam());
					
				case LOAD:
					data1 = this.memory.read(instruction.getParam());
					this.stack.push(data1);
					return true;
					
				case STORE:
					if (this.stack.getNumElems() == 0)
						return false;
					else {
						data1 = this.stack.pop();
						this.memory.write(instruction.getParam(), data1);
						return true;
					}
					
				case ADD:
					if (this.stack.getNumElems() < 2)
						return false;
					else {
						data1 = this.stack.pop();
						data2 = this.stack.pop();
						data1 = data2 + data1;
						return this.stack.push(data1);
					}
					
				case SUB:
					if (this.stack.getNumElems() < 2)
						return false;
					else {
						data1 = this.stack.pop();
						data2 = this.stack.pop();
						data1 = data2 - data1;
						return this.stack.push(data1);
					}
					
				case MUL:
					if (this.stack.getNumElems() < 2)
						return false;
					else {
						data1 = this.stack.pop();
						data2 = this.stack.pop();
						data1 = data2 * data1;
						return this.stack.push(data1);
					}
					
				case DIV:
					if (this.stack.getNumElems() < 2)
						return false;
					else {
						data1 = this.stack.pop();
						data2 = this.stack.pop();
						if (data1 == 0)
							return false;
						else {
							data1 = data2 / data1;
							return this.stack.push(data1);
						}
					}
					
				case OUT:
					System.out.println("OUT: " + this.stack.pop());
					return true;
					
				case HALT:
					this.halt = true;
					return true;
					
				default:
					return false;
			}
		}

	}

	/**
	 * Devuelve true o false dependiendo de si la CPU esta en modo halt.
	 * @return valor del atributo halt
	 */
	public boolean isHalt() {
		return this.halt;
	}

	/**
	 * Borra los elementos de la pila y de la memoria.
	 */
	public void reset() {
		this.stack.reset();
		this.memory.reset();
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

}