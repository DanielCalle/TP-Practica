package main;
import java.util.Scanner;

import bytecodes.ByteCode;
import bytecodes.ByteCodeParser;
import commands.Command;
import commands.CommandParser;
import cpu.CPU;

/**
 * Representa el bucle de control de la aplicación.
 * @author Daniel Calle Sánchez
 * @author Manuel Guerrero Moñús
 * @version 2.0, 08/12/2016
 */
public class Engine {

	private CPU cpu;
	private boolean end;
	private ByteCodeProgram program;
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructora de Engine.
	 */
	public Engine() {
		this.end = false;
		this.program = new ByteCodeProgram();
		this.cpu = new CPU(this.program);
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
	 * Establece que la máquina virtual va a pararse.
	 * @return Devuelve un booleano que indica si la ejecución del comando fue correcta.
	 */
	public boolean executeQuit() {
		this.end = true;
		return true;
	}
	
	/**
	 * Vacia el programa aactual.
	 * @return Devuelve un booleano que indica si la ejecución del 
	 */
	public boolean executeReset() {
		this.program.reset();
		return true;
	}

	/**
	 * Realiza la sustitución de una instrucción existente por una nueva isntrucción.
	 * @param programLine Recive como parámetro el número de línea de la instrucción a reemplazar.
	 * @return Devuelve un booleano que indica si la ejecución del comando fue correcta.
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
	
	/**
	 * Indica a la CPU que debe de añadir nuevas isntrucciones al programa.
	 * @return Devuelve un booleano que indica si la introducción de ByteCodes fue correcta.
	 */
	public boolean readByteCodeProgram() {
		String line = "";
		ByteCode instruction;
		boolean endBC = false; 
		boolean statusOkey = true;
		this.program.reset();
		
		System.out.println("Introduce el bytecode. Una instrucción por línea:");
		
		do {
			line = sc.nextLine();
			instruction = ByteCodeParser.parse(line);
			if( instruction == null ){	
				endBC = line.trim().equalsIgnoreCase("END");	
				if( !endBC ) {
					statusOkey = false;
					this.program.reset();
				}
			}
			else
				cpu.addByteCode(instruction);
		} while( !endBC && statusOkey );
		
		return statusOkey;
	}
	
	/**
	 * Ordena a la CPU que debe ejecutarse el comando RUN.
	 * @return Deuvelve un booleano que indica si la ejecuión del comando fue correcta o no.
	 */
	public boolean executeRun() {
		return this.cpu.run();
	}
	
}