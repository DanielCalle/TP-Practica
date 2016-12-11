package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

/**
 * Implementacion de la clase Store
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Store extends ByteCodeOneParameter {

	/**
	 * Contructora sin parametros de Store
	 */
	public Store() {}
	
	/**
	 * Constructora con parametro de Sotre
	 * @param p parametro del bytecode
	 */
	public Store(int p) {
		super(p);
	}


	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.write(this.param);
	}

	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("STORE"))
			return new Store(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "STORE";
	}

}
