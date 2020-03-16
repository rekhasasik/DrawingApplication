package com.sasi.drawing.command;

import java.util.Arrays;

import com.sasi.drawing.Application;
import com.sasi.drawing.exception.InvalidCommandException;
import com.sasi.drawing.model.Canvas;
import com.sasi.drawing.model.Line;
import com.sasi.drawing.model.Rectangle;

/**
 * Factory class to parse the command and return object
 * @author Sasi
 *
 */
public class CommandFactory {

	public static ICommand getCommand(String inputCommand) {
		inputCommand = inputCommand.trim();
		String[] inpArray = inputCommand.split(" ");
		String baseCommand = inpArray[0].toUpperCase();
		String[] params = Arrays.copyOfRange(inpArray, 1, inpArray.length);
		switch(baseCommand) {
		 case "C":
             return new Canvas(params);
         case "L":
             return new Line(params);
         case "R":
             return new Rectangle(params);
         default:
        	 throw new InvalidCommandException("Invalid command Prefix.Available Commands: "+Application.supportedCommands);
		
		}
		
	}

}
