package maquinaVirtual;

import maquinaVirtual.enums.ENUM_BYTECODE;

/**
 * Implementa las distintas instrucciones bytecode que puede manejar nuestra máquina virtual
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
abstract public class ByteCode {

	protected String name;

	/**
	 * Constructor para ByteCode
	 *
	 * @param name nombre de la instrucción
	 */
	public ByteCode(String name) {
		this.name = name;
	}

	abstract public boolean execute(CPU cpu);

	abstract public ByteCode parse(String[] s);

	/**
	 * Devuelve el nombre de la instruccion
	 *
	 * @return nombre de la instrucción
	 */
	public String getName() {
		return this.name;
	};

	@Override
	public String toString() {
		return this.getName();
	}

}
