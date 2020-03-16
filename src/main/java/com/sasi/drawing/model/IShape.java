package com.sasi.drawing.model;

import java.util.List;

import com.sasi.drawing.command.ICommand;
import com.sasi.drawing.util.Range;

/**
 * Shape Interface implemented by shapes like Line and Rectangle
 * @author Sasi
 *
 */
public interface IShape extends ICommand{
    
	Point getP1();
	Point getP2();
	/**
	 * The list of points to be updated in the drawing board
	 * @return
	 */
	List<Range> getRanges();
	String getName();
	/**
	 * If shape has to represent a different symbol
	 * @return
	 */
	Character symbol();

}
