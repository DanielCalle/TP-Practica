package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;

/**
 * Implementacion de la clase IfNeq
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class IfNeq extends ConditionalJumps {

	/**
	 * Contructora sin parametros de IfNeq
	 */
	public IfNeq() {}
	
	/**
	 * Constructora con parametro de IfNeq
	 * @param j direccion de salto
	 */
	public IfNeq(int param) {
		super(param);
	}
	
	@Override
	protected boolean compare(int n1, int n2) {
		return n1!=n2;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IFNEQ"))
			return new IfNeq(Integer.parseInt(string2));
		else
			return null;
	}

	@Override
	protected String toStringAux() {
		return "IFNEQ";
	}

}
