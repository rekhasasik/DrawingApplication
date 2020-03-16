package com.sasi.drawing.model;

import java.util.List;

import com.sasi.drawing.command.ICommand;

/**
 * Interfaces implemented by Grid components like Canvas
 * @author Sasi
 *
 */
public interface IDrawingGrid extends ICommand{
	
		void print();
		void addShape(IShape shape);
		List<IShape> getShapes();
    
    

}
