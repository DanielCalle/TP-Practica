package maquinaVirtual.bytecode.jumps.conditional;

import maquinaVirtual.ByteCode;
import maquinaVirtual.CPU;

/**
 * Created by danie on 20/11/2016.
 */
abstract public class ConditionalJumps extends ByteCode {

	protected int param;
	protected int c;
	protected int sc;

	public ConditionalJumps(String name, int param) {
		super(name);
		this.param = param;
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.increaseProgramCounter();
		this.c = cpu.pop();
		this.sc = cpu.pop();

		return true;
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
