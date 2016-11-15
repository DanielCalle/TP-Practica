package maquinaVirtual;
import maquinaVirtual.enums.ENUM_BYTECODE;

/**
 * Implementa las distintas instrucciones bytecode que puede manejar nuestra máquina virtual
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class ByteCode {

	private int param;
	private ENUM_BYTECODE name;

	/**
	 * Constructor para instrucciones con parámetro
	 * @param name nombre de la instrucción
	 * @param param párametro de la instrucción
	 */
	public ByteCode(ENUM_BYTECODE name, int param) {
		this.name = name;
		this.param = param;
	}
	
	/**
	 * Constructor para intrucciones sin parametro
	 * @param name nombre de la instrucción
	 */
	public ByteCode(ENUM_BYTECODE name) {
		this.name = name;
	}
	
	/**
	 * Devuelve el valor del parametro
	 * @return param parámetro de la instrucción
	 */
	public int getParam() {
		return this.param;
	}
	
	/**
	 * Devuelve el nombre de la instruccion
	 * @return nombre de la instrucción
	 */
	public ENUM_BYTECODE getName() {
		return this.name;
	}
	
	/**
	 * Devuelve el string de la instruccion
	 * @return un string que describe el objeto
	 */
	public String toString() {
		return this.name + (this.name.getNumArgs() > 0 ? (" " + this.param) : "");
	}

}
