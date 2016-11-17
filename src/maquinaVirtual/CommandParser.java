package maquinaVirtual;
import maquinaVirtual.enums.ENUM_COMMAND;

/**
 * Contiene como único método parse(String line).
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class CommandParser {

	/**
	 * Se encarga de analizar el parámetro line y generar a partir de él el corresiente comando.
	 * Si line no se corresponde con la sintáxis de ningún comando entonces el método devuelve null.
	 * @param line string que contiene el comando que instroduce el usuario
	 * @return devuelve de un comando o si no null
	 */
	public static Command parse(String line) {

		line = line.toUpperCase().trim();
		String lineSplit[] = line.split(" +");
		
		switch (lineSplit.length) {
	
			case 1:
				switch (lineSplit[0]) {
	
					case "RUN":
						return new Command(ENUM_COMMAND.RUN);
		
					case "HELP":
						return new Command(ENUM_COMMAND.HELP);
		
					case "QUIT":
						return new Command(ENUM_COMMAND.QUIT);
		
					case "RESET":
						return new Command(ENUM_COMMAND.RESET);
		
					case "BYTECODE":
						return new Command(ENUM_COMMAND.BYTECODE);
						
					default:
						return null;
				}

			case 2:
				
				if (lineSplit[0].compareTo("REPLACE") == 0)
					return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(lineSplit[1]));
	
			default:
				return null;

		}

	}

}