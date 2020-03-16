package com.sasi.drawing;

import java.util.Scanner;

import com.sasi.drawing.coordinator.Coordinator;
import com.sasi.drawing.coordinator.ICoordinator;

/**
 * 
 * @author Sasi
 * Main class that Reads the input from User
 *
 */
public class Application {
	
	private static final String QUIT_COMMAND = "Q";
	public static final String HISTORY = "H";
	private static final String CREATE_CANVAS_COMMAND = "C w h";
	private static final String LINE_COMMAND = "L x1 y1 x2 y2";
	private static final String RECTANGLE_COMMAND = "R x1 y1 x2 y2";
	private static final String SUPPORTED_COMMANDS[] = {CREATE_CANVAS_COMMAND, LINE_COMMAND, RECTANGLE_COMMAND, HISTORY, QUIT_COMMAND};
	public static String supportedCommands = String.join(", ", SUPPORTED_COMMANDS);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ICoordinator coordinator = new Coordinator();
		
		String input = null;
		while(true) {
			System.out.print("enter command: ");
			input = scanner.nextLine();
			if(input == null || input.length() < 1) {
				System.out.println("Invalid Input. Try Again. Supported Comands: "+supportedCommands);
				continue;
			}
			if(input.equalsIgnoreCase(QUIT_COMMAND)) {
				break;				
			}
			if(input.equalsIgnoreCase(HISTORY)) {
				coordinator.printCommandHistory();
	   			continue;
	   		}
			try {
				coordinator.processCommand(input);
			}catch(Throwable e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();

	}

}
