package com.sasi.drawing.model;

import java.util.ArrayList;
import java.util.List;

import com.sasi.drawing.command.ICommand;
import com.sasi.drawing.exception.NegativeValueException;
import com.sasi.drawing.exception.ParameterValidationException;
import com.sasi.drawing.util.Range;
import com.sasi.drawing.util.Utility;

/**
 * Canvas class that sets the region for drawing different objects
 * and also updates the drawing board
 * @author Sasi
 *
 */
public class Canvas implements IDrawingGrid {
	
	private final String HELP = "Format should be C w h. Example. C 20 5";
	private int width;
	private int height;
	private char[][] drawingBoard;
	//For testing purposes
	private List<IShape> shapes;
	
	public Canvas(String... params) {
		if (params.length != 2)
            throw new ParameterValidationException("Invalid parameters. Create Canvas expects 2 parameters. "+HELP);	
		try {
			this.width = Utility.toInt(params[0]);
			this.height = Utility.toInt(params[1]);
		} catch (NegativeValueException e) {
		    throw new ParameterValidationException("Canvas Width and Height "+e.getMessage()+ " "+HELP);
		}
		shapes = new ArrayList<>();
		
		//2 Additional columns for two horizotal Borders
		//2 Additional Columns for two Vertical Borders
		drawingBoard = new char[this.height+2][this.width+2];
		
		for (int i = 0; i < drawingBoard.length; i++) {
	        for (int j = 0; j < drawingBoard[i].length; j++) {
	            if(i==0 || i==drawingBoard.length-1) {
	            	drawingBoard[i][j]=ICommand.HORIZONTAL_SYMBOL;
	            }
	            else if(j==0||j==drawingBoard[i].length-1) {
	            	drawingBoard[i][j]=ICommand.VERTICAL_SYMBOL;
	            }
	            else {
	            	drawingBoard[i][j]=ICommand.SPACE_SYMBOL;
	            }
	        }		
		}
	}
	
	/**
	 * Validates the Input of shape with the borders Of Canvas.
	 * Gets the List of ranges(set of Points) from the shape and Updates the drawing board.
	 */
	@Override
	public void addShape(IShape shape) {
		if(!isValid(shape.getP1())) {
			throw new ParameterValidationException(shape.getName()+" inputs are out of Boundary");
		}
		
		shapes.add(shape);
		
		//If we want to resize the shape to actual width and height of Canvas
	/*	if(shape.getP2().getX() > width) {
			shape.getP2().setX(width);
		}
		
		if(shape.getP2().getY() > height) {
			shape.getP2().setY(height);
		}*/
		
		List<Range> ranges = shape.getRanges();
		if(ranges == null || ranges.size() < 1) {
			throw new RuntimeException(shape.getName()+" Nothing to update Drawing Board");
		}
		Character symbol = shape.symbol();
		if(symbol == null) {
			symbol = ICommand.LINE_SYMBOL;
		}
		updateDrawingBoard(ranges, symbol);
	}
	
	@Override
	public List<IShape> getShapes() {
		return shapes;
	}

	
	/**
	 * Print the drawing board
	 */
	@Override
	public void print() {
	 for (int i = 0; i < drawingBoard.length; i++) {
            for (int j = 0; j < drawingBoard[i].length; j++) {
            	System.out.print(drawingBoard[i][j]);
            }
            System.out.println();
        }
		
	}
	
	public char[][] getDrawingBoard() {
		return drawingBoard;
	}
	
	/**
	 * chack if the given x and y coordinates lie with in the border of Canvas
	 * @param p
	 * @return
	 */
	private boolean isValid(Point p) {
		return p.getX() <= width && p.getY() <= height;
	}
	
	/**
	 * Sets the values in the drawboard from the list of points that has been provided.
	 * Note: When the x2,y2 coordinates of shape exceeds the Drawing Board, only the points inside the board are printed.
	 * @param ranges
	 * @param symbol
	 */
	private void updateDrawingBoard(List<Range> ranges,Character symbol) {
		Point p1 = null;
		Point p2 = null;
		for(Range range : ranges) {
			p1 = range.getP1();
			p2 = range.getP2();
			for(int i=p1.getY(); i <= p2.getY() && i < drawingBoard.length-1;i++) {
				for(int j=p1.getX(); j <= p2.getX() && j < drawingBoard[i].length-1;j++) {
					drawingBoard[i][j] = symbol;
				}
			}
		}
		
	}

		
}
