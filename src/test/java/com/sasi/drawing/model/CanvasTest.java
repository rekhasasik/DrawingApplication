package com.sasi.drawing.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sasi.drawing.exception.ParameterValidationException;

public class CanvasTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void createCanvas() {
		String[] params = {"12", "8"};
		Canvas c = new Canvas(params);
		Assert.assertNotNull(c);
		Assert.assertNotNull(c.getDrawingBoard());
		Assert.assertEquals(10, c.getDrawingBoard().length);
		Assert.assertEquals(14, c.getDrawingBoard()[0].length);
	}
	
	@Test
	public void createCanvasAddObjects() {
		String[] params = {"12", "8"};
		Canvas c = new Canvas(params);
		Assert.assertNotNull(c);
		Assert.assertNotNull(c.getDrawingBoard());
		String[] params1 = {"7", "4", "12", "8"};
		IShape shape = new Rectangle(params1);
		c.addShape(shape);
		Assert.assertEquals(1, c.getShapes().size());
		Assert.assertTrue(shape.symbol() == c.getDrawingBoard()[6][7]);
		String[] params2 = {"12", "2", "12", "8"};
		shape = new Line(params2);
		c.addShape(shape);
		Assert.assertTrue(shape.symbol() == c.getDrawingBoard()[5][12]);
		Assert.assertEquals(2, c.getShapes().size());
			
	}
	
	@Test
	public void createCanvasAddObjectOutOfBoundary() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("inputs are out of Boundary");
		String[] params = {"12", "8"};
		Canvas c = new Canvas(params);
		Assert.assertNotNull(c);
		Assert.assertEquals(0, c.getShapes().size());		
		String[] params1 = {"13", "2", "13", "8"};
		IShape shape = new Line(params1);
		c.addShape(shape);
		Assert.assertEquals(0, c.getShapes().size());
	}

}
