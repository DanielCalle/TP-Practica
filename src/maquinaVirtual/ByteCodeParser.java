package maquinaVirtual;
import maquinaVirtual.enums.ENUM_BYTECODE;

/**
 * Es la clase encargada de parsear un string que contiene un posible bytecode.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class ByteCodeParser {

	/**
	 * Devuelve el bytecode almacenado en s o bien null si s no representa ningún comando
	 * @param line el string de la instrucción
	 * @return una instancia de la clase ByteCode, si la instrucción no existe es null 
	 */
	public static ByteCode parse(String line) {

		line = line.trim().toUpperCase();
		String instruction[] = line.split(" +");

		switch (instruction.length) {
			case 1:
				switch (instruction[0]) {
					case "ADD":
						return new ByteCode(ENUM_BYTECODE.ADD);
		
					case "SUB":
						return new ByteCode(ENUM_BYTECODE.SUB);
		
					case "MUL":
						return new ByteCode(ENUM_BYTECODE.MUL);
		
					case "DIV":
						return new ByteCode(ENUM_BYTECODE.DIV);
		
					case "OUT":
						return new ByteCode(ENUM_BYTECODE.OUT);
		
					case "HALT":
						return new ByteCode(ENUM_BYTECODE.HALT);
		
					default:
						return null;
			}

		case 2:
			switch (instruction[0]) {
				case "PUSH":
					return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(instruction[1]));
	
				case "LOAD":
					return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(instruction[1]));
	
				case "STORE":
					return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(instruction[1]));
	
				default:
					return null;
			}

		default:
			return null;
		}

	}

}
