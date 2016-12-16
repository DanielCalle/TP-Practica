package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Implementacion de la clase Arithmetics
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
abstract public class Arithmetics implements ByteCode {

	protected int n1;
	protected int n2;

	@Override
	public boolean execute(CPU cpu) {
		if(cpu.getSizeStack()>=2){ 
			cpu.increaseProgramCounter();
			n1 = cpu.pop();
			n2 = cpu.pop();
			return execute(n2, n1, cpu);
		}
		else
			return false;
		}
	
	/**
	 * Ejecuta una operacion aritmética lógica
	 * @param n1 primer operando
	 * @param n2 segundo operando
	 * @param cpu
	 * @return true si la ejecucion es correcta o false si hubo algun problema
	 */
	abstract protected boolean execute(int n1, int n2, CPU cpu);

	@Override
	public ByteCode parse(String[] words) {
		if(words.length!=1) return null;
		else return this.parseAux(words[0]);
	}
	
	/**
	 * Realiza el parse de una instruccion Arithmetics
	 * @param string1 string que se va a utilizar en el parse
	 * @return un objeto Bytecode si la sintaxis es correcta o null si es incorrecta
	 */
	abstract public ByteCode parseAux(String string1);
}
