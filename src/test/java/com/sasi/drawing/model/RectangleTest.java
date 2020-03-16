package com.sasi.drawing.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sasi.drawing.exception.ParameterValidationException;
import com.sasi.drawing.util.Range;

public class RectangleTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testCreateRectangle() {
		String[] params = {"7", "1", "8", "1"};
		Rectangle r = new Rectangle(params);
		Assert.assertNotNull(r);
		Assert.assertEquals(1, r.getP1().getY());
		Assert.assertEquals(8, r.getP2().getX());
	}
	
	@Test
	public void createRectangleWithInvalidInput() {
		String[] params = {"7", "1", "-8", "2"};
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Only positive values Expected");
	    Rectangle r = new Rectangle(params);
		Assert.assertNull(r);
	}
	
	@Test
	public void testGetRanges() {
		String[] params = {"7", "1", "8", "4"};
		Rectangle r = new Rectangle(params);
		Assert.assertNotNull(r);	
		List<Range> ranges = r.getRanges();
		Assert.assertEquals(4, r.getRanges().size());
		Assert.assertTrue(8 == ranges.get(2).getP1().getX());
		Assert.assertTrue(1 == ranges.get(0).getP2().getY());
	}

}
