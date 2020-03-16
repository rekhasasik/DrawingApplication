package com.sasi.drawing.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sasi.drawing.exception.InvalidCommandException;
import com.sasi.drawing.exception.ParameterValidationException;
import com.sasi.drawing.model.IDrawingGrid;
import com.sasi.drawing.model.Line;
import com.sasi.drawing.model.Rectangle;

public class CommandFactoryTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void createCanvasCommand() {
		String input = "C 30 10";
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNotNull(command);
		Assert.assertTrue(command instanceof IDrawingGrid);
		
	}
	
	@Test
	public void createCanvasCommandWithNegativeValue() {
		String input = "C 30 -10";
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Only positive values Expected");
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNull(command);
		
	}
	
	@Test
	public void createLineCommandWithWrongNumberOfInputs() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("expects 4 parameters");
	    String input = "L"; 
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNull(command);
		
	}
	
	@Test
	public void createLineCommand() {
	    String input = "L 1 4 1 7"; 
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNotNull(command);
		Assert.assertTrue(command instanceof Line);
		
	}
	
	@Test
	public void createRectangleCommandWithWrongInputs() {
		exceptionRule.expect(ParameterValidationException.class);
	    exceptionRule.expectMessage("Rectangle cannot be drawn");
	    String input = "R 9 2 4 6 "; 
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNull(command);
		
	}
	
	@Test
	public void createRectangleCommand() {
	    String input = "R 9 4 15 7"; 
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNotNull(command);
		Assert.assertTrue(command instanceof Rectangle);
		
	}
	
	@Test
	public void createMiscObject() {
		exceptionRule.expect(InvalidCommandException.class);
	    exceptionRule.expectMessage("Invalid command");
		String input = "fg"; 
		ICommand command = CommandFactory.getCommand(input);
		Assert.assertNull(command);
	}

}
