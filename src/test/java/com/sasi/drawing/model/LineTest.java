package com.sasi.drawing.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sasi.drawing.exception.ParameterValidationException;

public class LineTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void createLine() {
		String[] params = {"7", "1", "8", "1"};
		Line l = new Line(params);
		Assert.assertNotNull(l);
		Assert.assertEquals(1, l.getP1().getY());
		Assert.assertEquals(8, l.getP2().getX());
	}
	
	@Test
	public void createLineWithInvalidInput() {
		String[] params = {"7", "1", "8", "2"};
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Line cannot be drawn");
		Line l = new Line(params);
		Assert.assertNull(l);
	}
	
	@Test
	public void testGetRanges() {
		String[] params = {"7", "1", "8", "1"};
		Line l = new Line(params);
		Assert.assertNotNull(l);		
		Assert.assertEquals(1, l.getRanges().size());
	}

}
