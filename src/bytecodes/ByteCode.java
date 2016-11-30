package bytecodes;

import cpu.CPU;

/**
 * Implementa las distintas instrucciones bytecode que puede manejar nuestra máquina virtual
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
abstract public class ByteCode {

	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] words);

}
