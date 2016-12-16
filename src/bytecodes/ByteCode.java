package bytecodes;

import cpu.CPU;

/**
 * Clase abstracta de las distintas instrucciones bytecode
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 3.0, 16/12/2016
 */
public interface ByteCode {

	/**
	 * Ejecuta la instruccion bytecode
	 * @param cpu La CPU en la que se ejecuta el bytecode
	 * @return true Si la instruccion se ejecuto correctamente o false si hubo un problema.
	 */
	public boolean execute(CPU cpu);
	
	/**
	 * Realiza el parse de la instruccion bytecode
	 * @param words Array de palabras que se van a utilizar en el parse
	 * @return Un objeto ByteCode si la sintaxis es correcta o null si no lo es
	 */
	public ByteCode parse(String[] words);

}
