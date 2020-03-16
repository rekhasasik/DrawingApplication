package com.sasi.drawing.coordinator;

import com.sasi.drawing.model.IDrawingGrid;

/**
 * Acts as a Moderator between IDraeingGrid and Ishape
 * @author Sasi
 *
 */
public interface ICoordinator {
	/**
	 * Gets the command object.
	 * Check if it is Drawing grid like Canvas
	 * Adds shapes to Drawing grid.
	 */
	void processCommand(String command);
	IDrawingGrid getDrawingGrid();
	void printCommandHistory();
	

}
