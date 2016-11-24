package maquinaVirtual.bytecode.memory;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class Push extends ByteCode {

	private int param;

	/**
	 * Constructor para Push
	 *
	 * @param param de la instrucción
	 */
	public Push(int param) {
		super("PUSH");
		this.param = param;
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		return cpu.push(this.param);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("PUSH") == 0)
			return new Push(Integer.parseInt(s[1]));
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
