package com.sasi.drawing.model;

import java.util.ArrayList;
import java.util.List;

import com.sasi.drawing.command.ICommand;
import com.sasi.drawing.exception.NegativeValueException;
import com.sasi.drawing.exception.ParameterValidationException;
import com.sasi.drawing.util.Range;
import com.sasi.drawing.util.Utility;

/**
 * Rectangle
 * @author Sasi
 *
 */
public class Rectangle implements IShape {
	private final String HELP = "Format should be R x1 y1 x2 y2. Example. R 15 2 20 25";
	private final String name = "Rectangle";
	
	Point p1;
	Point p2;
	
	public Rectangle(String... params) {
		if (params.length != 4)
            throw new ParameterValidationException("Invalid Parameters. Rectangle expects 4 parameters. "+HELP);
        try {
    	   int x = Utility.toInt(params[0]);
           int y = Utility.toInt(params[1]);
           p1 = new Point(x, y);
           x = Utility.toInt(params[2]);
           y = Utility.toInt(params[3]);
           p2 = new Point(x,y);
        } catch (NegativeValueException e) {
            throw new ParameterValidationException("Rectangle Cordinates: "+e.getMessage() +" "+HELP);
        }
        if (p1.getX() > p2.getX() || p1.getY() > p2.getY()) {
        	throw new ParameterValidationException("Rectangle cannot be drawn.");
        }
    		
		
	}


	public Point getP1() {
		return p1;
	}


	public void setP1(Point p1) {
		this.p1 = p1;
	}


	public Point getP2() {
		return p2;
	}


	public void setP2(Point p2) {
		this.p2 = p2;
	}

	
	/**
	 * Setting points for all the 4 sides of rectangle
	 */
	@Override
	public List<Range> getRanges() {
		List<Range> ranges = new ArrayList<Range>();
		Range range = new Range(p1,new Point(p2.getX(),p1.getY()));
		ranges.add(range);
		range = new Range(p1, new Point(p1.getX(),p2.getY()));
		ranges.add(range);
		range = new Range(new Point(p2.getX(),p1.getY()), p2);
		ranges.add(range);
		range = new Range(new Point(p1.getX(),p2.getY()), p2);
		ranges.add(range);
		return ranges;
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public Character symbol() {
		return ICommand.LINE_SYMBOL;
	}

	


}
