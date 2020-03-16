package com.sasi.drawing.coordinator;

import java.util.ArrayList;
import java.util.List;

import com.sasi.drawing.command.CommandFactory;
import com.sasi.drawing.command.ICommand;
import com.sasi.drawing.exception.NoDrawingBoardException;
import com.sasi.drawing.model.IDrawingGrid;
import com.sasi.drawing.model.IShape;

/**
 * Implementation of ICoordinator
 * @author Sasi
 *
 */
public class Coordinator implements ICoordinator{
	
	private IDrawingGrid grid;
	private List<String> commands = new ArrayList<>();
	
	/**
	 * Gets the command object.
	 * Check if it is Drawing grid like Canvas
	 * Adds shapes to Drawing grid.
	 */
   	@Override
	public void processCommand(String input) {
   		commands.add(input);
		ICommand model = CommandFactory.getCommand(input);
		if(model instanceof IDrawingGrid) {
			grid = (IDrawingGrid) model;
		}
		else if(model instanceof IShape) {
			IShape shape = (IShape) model;
			if(grid == null) {
				throw new NoDrawingBoardException("First Create Canvas before creating Line or Rectangle");
			}
			grid.addShape(shape);
		}
		else {
			throw new RuntimeException("Invalid Drawing Model. It could be Canvas or Shape(Line, Rectangle)");
		}
		grid.print();
	}

	@Override
	public IDrawingGrid getDrawingGrid() {
		return grid;
	}
	
	/**
	 * Print command History
	 */
	@Override
	public void printCommandHistory() {
		if(commands.size() < 1) {
			System.out.println("No History So far");
		}
		else {
			commands.stream().forEach(System.out::println);
		}
		
	}
	



}
