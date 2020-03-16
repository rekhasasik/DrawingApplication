package com.sasi.drawing.model;

import java.util.Arrays;
import java.util.List;

import com.sasi.drawing.command.ICommand;
import com.sasi.drawing.exception.NegativeValueException;
import com.sasi.drawing.exception.ParameterValidationException;
import com.sasi.drawing.util.Range;
import com.sasi.drawing.util.Utility;

/**
 * Line Class
 * @author Sasi
 *
 */
public class Line implements IShape {
	private final String HELP = "Format should be L x1 y1 x2 y2. Example. L 1 3 7 3";
	private final String name = "Line";
	
	Point p1;
	Point p2;
	
	public Line(String... params) {
		if (params.length != 4)
            throw new ParameterValidationException("Invalid Parameters. Line expects 4 parameters. "+HELP);
        try {
            int x = Utility.toInt(params[0]);
            int y = Utility.toInt(params[1]);
            p1 = new Point(x, y);
            x = Utility.toInt(params[2]);
            y = Utility.toInt(params[3]);
            p2 = new Point(x,y);
        } catch (NegativeValueException e) {
            throw new ParameterValidationException(" Line Cordinates. "+e.getMessage() +" "+HELP);
        }
        //Either x1==x2 or y1==y2
        if (p1.getX() != p2.getX() && p1.getY() != p2.getY()) {
            throw new ParameterValidationException("Line cannot be drawn.");
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

	@Override
	public List<Range> getRanges() {
		Range range = new Range(p1,p2);
		return Arrays.asList(range);
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
