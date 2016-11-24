package maquinaVirtual.bytecode.memory;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Load extends ByteCode {
	private int param;

	/**
	 * Constructor para Load
	 *
	 * @param param de la instrucción
	 */
	public Load(int param) {
		super("LOAD");
		this.param = param;
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.push(cpu.read(this.param));
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("LOAD") == 0)
			return new Load(Integer.parseInt(s[1]));
		else
			return null;
	}

	/**
	 * Devuelve el valor del parametro
	 *
	 * @return param parámetro de la instrucción
	 */
	public int getParam() {
		return this.param;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.getParam();
	}

}
