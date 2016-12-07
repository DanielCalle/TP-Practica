package commands;

/**
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class CommandParser {

	private final static Command[] COMMANDS = {
			new Help(), new Quit(), new Reset(),
			new Replace(), new Run(), new AddByteCodeProgram()
	};
	
	public static Command parse(String line) {

		int i = 0;
		Command command = null;
		String lineDecode[] = line.toUpperCase().trim().split(" +");
				
		do {
			command = COMMANDS[i++].parse(lineDecode);
		} while( i < COMMANDS.length && command == null );
		
		return command;	
	}

	 public static void showHelp() {
		 
		 for( Command command : COMMANDS ) System.out.print( command.textHelp() );
		 
	 }
	
}