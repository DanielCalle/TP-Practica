package maquinaVirtual;

import maquinaVirtual.byteCode.arithmetics.*;
import maquinaVirtual.byteCode.conditionalJumps.*;
import maquinaVirtual.byteCode.GoTo;
import maquinaVirtual.byteCode.Halt;
import maquinaVirtual.byteCode.Load;
import maquinaVirtual.byteCode.Out;
import maquinaVirtual.byteCode.Push;
import maquinaVirtual.byteCode.Store;

/**
 * Es la clase encargada de parsear un string que contiene un posible bytecode.
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class ByteCodeParser {

	private final static ByteCode[] BYTECODES = {
			new Add(), new Div(), new Mul(),
			new Sub(), new IfEq(0), new IfLe(0),
			new IfLeq(0), new IfNeq(0), new GoTo(0),
			new Halt(), new Load(0), new Out(),
			new Push(0), new Store(0)};

	/**
	 * Devuelve el bytecode almacenado en s o bien null si s no representa ningún comando
	 *
	 * @param line el string de la instrucción
	 * @return una instancia de la clase ByteCode, si la instrucción no existe es null
	 */
	public static ByteCode parse(String line) {

		line = line.trim().toUpperCase();
		String s[] = line.split(" +");
		ByteCode bc = null;

		for (int i = 0; i < BYTECODES.length && bc == null; i++) {
			bc = BYTECODES[i].parse(s);
		}

		return bc;

	}

}
