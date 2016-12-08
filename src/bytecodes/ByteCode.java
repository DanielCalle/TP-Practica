package bytecodes;

import cpu.CPU;

/**
 * Clase abstracta de las distintas instrucciones bytecode
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
abstract public class ByteCode {

	/**
	 * Ejecuta la instruccion bytecode
	 * @param cpu
	 * @return true si la instruccion se ejecuto correctamente o false si hubo un problema.
	 */
	abstract public boolean execute(CPU cpu);
	
	/**
	 * Realiza el parse de la instruccion bytecode
	 * @param words
	 * @return un objeto ByteCode si la sintaxis es correcta o null si no lo es
	 */
	abstract public ByteCode parse(String[] words);

}
