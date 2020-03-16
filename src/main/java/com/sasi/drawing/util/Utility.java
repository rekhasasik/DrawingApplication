package com.sasi.drawing.util;

import com.sasi.drawing.exception.NegativeValueException;

/**
 * Helper class to get common validation methods
 * @author Sasi
 *
 */
public class Utility {
	
	public static int toInt(String s) throws NegativeValueException {
		int i = Integer.parseInt(s);
        if (i <= 0) {
        	throw new NegativeValueException("Only positive values Expected");
        }
        return i;
	}

}
