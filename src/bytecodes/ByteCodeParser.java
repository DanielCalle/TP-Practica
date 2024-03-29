package bytecodes;

import bytecodes.arithmetics.*;
import bytecodes.oneparameter.GoTo;
import bytecodes.oneparameter.Load;
import bytecodes.oneparameter.Push;
import bytecodes.oneparameter.Store;
import bytecodes.oneparameter.conditionaljumps.IfEq;
import bytecodes.oneparameter.conditionaljumps.IfLe;
import bytecodes.oneparameter.conditionaljumps.IfLeq;
import bytecodes.oneparameter.conditionaljumps.IfNeq;

/**
 * Es la clase encargada de parsear un string que contiene un posible bytecode.
 *
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class ByteCodeParser {

	private final static ByteCode[] BYTECODES = {
			new Add(), new Div(), new Mul(),
			new Sub(), new IfEq(), new IfLe(),
			new IfLeq(), new IfNeq(), new GoTo(),
			new Halt(), new Load(), new Out(),
			new Push(), new Store()};

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
