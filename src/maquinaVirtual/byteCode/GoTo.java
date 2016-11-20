package maquinaVirtual.byteCode;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
public class GoTo extends ByteCode {

	private int param;

	/**
	 * Constructor para GoTo
	 *
	 * @param param de la instrucción
	 */
	public GoTo(int param) {
		super("GOTO");
		this.param = param;
	}

	@Override
	public boolean execute(CPU cpu) {
		return cpu.setProgramCounter(this.param);
	}

	@Override
	public ByteCode parse(String[] s) {
		if (s[0].compareTo("GOTO") == 0)
			return new GoTo(Integer.parseInt(s[1]));
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
