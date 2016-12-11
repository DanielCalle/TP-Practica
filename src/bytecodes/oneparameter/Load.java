package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Implementacion de la clase Load
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Load extends ByteCodeOneParameter {

	/**
	 * Contructora sin parametros de ConditionalJumps
	 */
	public Load() {}
	
	/**
	 * Constructora con parametro de ConditionalJumps
	 * @param p parametro del bytecode
	 */
	public Load(int p) {
		super(p);
	}
	
	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.push(cpu.read(this.param));
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "LOAD";
	}

}
