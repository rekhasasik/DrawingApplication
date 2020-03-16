package com.sasi.drawing.coordinator;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import com.sasi.drawing.coordinator.Coordinator;
import com.sasi.drawing.coordinator.ICoordinator;
import com.sasi.drawing.exception.NoDrawingBoardException;
import com.sasi.drawing.exception.ParameterValidationException;

@FixMethodOrder(MethodSorters.DEFAULT)
public class CoordinatorTest {
	
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test(expected=NoDrawingBoardException.class)
	public void testAddCommandThrowsNoDrawingBoardExcetion() {
		ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("L 1 5 7 5");
	}
	
	@Test
	public void testAddCommandThrowsNegativeValueException() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Only positive values Expected");
	    ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("c -4 5");
	}
	
	@Test
	public void testAddCommandThrowsParamNotMatchingException() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("expects 2 parameters");
	    ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("c 4 5 6 7");
	    Assert.assertNull(coordinator.getDrawingGrid());
	}
	
	@Test
	public void testDrawingGrid() {
		ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
	
	}
	
	@Test
	public void testLineInvalidParameters() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("expects 4 parameters");
	    ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("L 14 5");
	
	}
	
	@Test(expected=NumberFormatException.class)
	public void testLineParametersForNumberFormatException() {
		ICoordinator coordinator = new Coordinator();
		coordinator.processCommand("L 1 4 7.5 4.5");
	
	}
	
	@Test
	public void testLineParametersInvalidInputException() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Line cannot be drawn");
	    ICoordinator coordinator = new Coordinator();
	    coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("L 1 4 7 1");
		Assert.assertEquals(0, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testAddLine() {
		ICoordinator coordinator = new Coordinator();
		coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("L 1 4 7 4");
		Assert.assertEquals(1, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testRectangleInvalidParameters() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("expects 4 parameters");
	    ICoordinator coordinator = new Coordinator(); 
		coordinator.processCommand("R 14 5");
	
	}
	
	@Test
	public void testRectangleParametersInvalidInputException() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Rectangle cannot be drawn");
	    ICoordinator coordinator = new Coordinator();
		coordinator.processCommand("R 7 4 1 1");
		Assert.assertEquals(0, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testAddRectangle() {
		ICoordinator coordinator = new Coordinator();
		coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("R 10 2 14 5");
		Assert.assertEquals(1, coordinator.getDrawingGrid().getShapes().size());
		coordinator.processCommand("c 25 10");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("R 10 2 14 5");
		Assert.assertEquals(1, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testLineParametersOutOfBoundary() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("inputs are out of Boundary");
	    ICoordinator coordinator = new Coordinator();
	    coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("L 1 6 1 9");
		Assert.assertEquals(0, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testRectangleParametersOutOfBoundary() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("inputs are out of Boundary");
	    ICoordinator coordinator = new Coordinator();
	    coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("R 15 2 17 9");
		Assert.assertEquals(0, coordinator.getDrawingGrid().getShapes().size());
	
	}
	
	@Test
	public void testRectangleParametersEqualToBoundary() {
	    ICoordinator coordinator = new Coordinator();
	    coordinator.processCommand("c 14 5");
		Assert.assertNotNull(coordinator.getDrawingGrid());
		coordinator.processCommand("R 8 2 14 5");
		Assert.assertEquals(1, coordinator.getDrawingGrid().getShapes().size());
	
	}

}
