package maquinaVirtual;
import java.util.Scanner;

/**
 * Representa el bucle de control de la aplicación.
 * 
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 1.0, 08/11/2016
 */
public class Engine {

	private CPU cpu;
	private boolean end;
	private ByteCodeProgram program;
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor de Engine
	 */
	public Engine() {
		this.end = false;
		this.program = new ByteCodeProgram();
		this.cpu = new CPU();
	}

	/**
	 * Se encarga de leer sucesivamente los comandos introducidos por el usuario, hasta recibir el comando QUIT.
	 */
	public void start() {

		String line = null;
		Command command = null;

		while (!this.end) {
			
			System.out.print("> ");
			line = sc.nextLine();
			command = CommandParser.parse(line);
			
			if (command != null) {
				System.out.println("Comienza la ejecución de " + command.toString());
				if (!command.execute(this))
					System.out.println("Error: Ejecución incorrecta del comando.");	
				
			} else {
				System.out.println("Error: Comando incorrecto.");
			}

			System.out.println(this.program.toString());

		}

		sc.close();
		System.out.println("Fin de la ejecución....");

	}

	/**
	 * Ejecuta el comando HELP
	 * @return booleano que indica que la ejecución fué correcta
	 */
	public static boolean executeHelp() {
		System.out.println( System.getProperty("line.separator") 
				+ "HELP: Muestra esta ayuda." 
				+ System.getProperty("line.separator") 
				+ "QUIT: Cierra la aplicación." 
				+ System.getProperty("line.separator")
				+ "RUN: Ejecuta el programa." 
				+ System.getProperty("line.separator") + "NEWINST BYTECODE: Instroduce una nueva instrucción al programa.\n"
				+ "RESET: Vacia el programa actual." 
				+ System.getProperty("line.separator")
				+ "REPLACE N: Reemplaza la instrucción N por la solicitada al usuario.");

		return true;

	}
	
	/**
	 * Ejecuta el comando QUIT
	 * @return booleano que indica que la ejecución fué correcta
	 */
	public boolean executeQuit() {
		this.end = true;
		return true;
	}

	/**
	 * Ejectuta el comando HELP
	 * @return booleano que indica que la ejecución fué correcta
	 */
	public boolean executeReset() {
		this.program.reset();
		return true;
	}

	/**
	 * Ejecuta el comando REPLACE
	 * @param programLine posicion de la línea del programa a reemplazar
	 * @return si se ejecuta correctamente devuelve true si la posicion es inexistente devuelve false
	 */
	public boolean executeReplace(int programLine) {

		if (0 <= programLine && programLine < this.program.getNumInstr()) {
			System.out.print("Nueva instrucción: ");
			String line = sc.nextLine();
			ByteCode instruction = ByteCodeParser.parse(line);
			if (instruction == null)
				return false;
			else {
				this.program.replace(instruction, programLine);
				return true;
			}

		}
		else
			return false;
	}
	
	public boolean readByteCodeProgram() {
		
		String line = "";
		ByteCode instruction;
		boolean endBC = false; 
		boolean statusOkey = true;
		
		System.out.println("Introduce el bytecode. Una instrucción por línea:");
		
		do {
			line = sc.nextLine();
			instruction = ByteCodeParser.parse(line);
			if( instruction == null ){	
				endBC = line.trim().compareToIgnoreCase("END") == 0;	
				if( !endBC )
					statusOkey = false;
			}
			else
				this.program.add(instruction);
		} while( !endBC && statusOkey );
		
		return statusOkey;
	}
	
}