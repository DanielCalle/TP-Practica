package commands;

/**
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class CommandParser {

	private final static Command[] COMMANDS = {
			new Help(), new Quit(), new Reset(),
			new Replace(0), new Run(), new AddByteCodeProgram()
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
		 
		 String s = ""; 
		
		 for( Command command : COMMANDS ) s += command.textHelp();
		 
		 System.out.print(s);
		 
	 }
	
}