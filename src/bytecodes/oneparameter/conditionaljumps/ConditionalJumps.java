package bytecodes.oneparameter.conditionaljumps;

import bytecodes.oneparameter.ByteCodeOneParameter;
import cpu.CPU;

/**
 * Implementacion de la clase ConditionalJumps
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
abstract public class ConditionalJumps extends ByteCodeOneParameter {
	
	/**
	 * Contructora sin parametros de ConditionalJumps
	 */
	public ConditionalJumps() {}

	/**
	 * Constructora con parametro de ConditionalJumps
	 * @param j direccion de salto
	 */
	public ConditionalJumps(int j) {
		super(j);
	}

	@Override
	public boolean execute(CPU cpu) {
		if (cpu.getSizeStack() >= 2){
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			if (!compare(n2,n1))
				cpu.setProgramCounter(this.param);
			else
				cpu.increaseProgramCounter();
			return true;
		}
		else
			return false;
	}

	/**
	 * Comparacion de dos datos
	 * @param n1 primer operando
	 * @param n2 segundo operando
	 * @return true si la comparacion es verdad y false si es falsa
	 */
	abstract protected boolean compare(int n1, int n2);
}
