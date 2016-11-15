package maquinaVirtual.enums;

/**
 * Contiene una constante de enumeración por cada una de las instrucciones.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public enum ENUM_BYTECODE {

	PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;

	private int numArgs;

	/**
	 * Constructora que asigna el numero del parametro a numArgs.
	 * @param n número de argumentos
	 */
	ENUM_BYTECODE(int n) {
		numArgs = n;
	}
	
	/**
	 * Constructora sin parametros con el valor 0 por defecto para numArgs.
	 */
	ENUM_BYTECODE() {
		this(0);
	}

	/**
	 * Devuelve el valor del numero de argumentos de la instruccion
	 * @return numArgs
	 */
	public int getNumArgs() {
		return this.numArgs;
	}

}