package main;
import java.util.Scanner;

import bytecodes.ByteCode;
import bytecodes.ByteCodeParser;
import commands.Command;
import commands.CommandParser;
import cpu.CPU;

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
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor de Engine
	 */
	public Engine() {
		this.end = false;
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

			System.out.println(cpu.getBcProgram().toString());

		}

		sc.close();
		System.out.println("Fin de la ejecución....");

	}
	
	public boolean executeQuit() {
		this.end = true;
		return true;
	}
	
	public boolean executeReset() {
		cpu.getBcProgram().reset();
		return true;
	}

	public boolean executeReplace(int programLine) {
		if (0 <= programLine && programLine < cpu.getBcProgram().getNumInstr()) {
			System.out.print("Nueva instrucción: ");
			String line = sc.nextLine();
			ByteCode instruction = ByteCodeParser.parse(line);
			if (instruction == null)
				return false;
			else {
				cpu.getBcProgram().replace(instruction, programLine);
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
				cpu.addByteCode(instruction);
		} while( !endBC && statusOkey );
		
		return statusOkey;
	}
	
	public boolean executeRun() {
		return this.cpu.run();
	}
	
}