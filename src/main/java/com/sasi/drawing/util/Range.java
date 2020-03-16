package com.sasi.drawing.util;

import com.sasi.drawing.model.Point;

/**
 * Class to hold x1,y1,x2,y2
 * @author Sasi
 *
 */
public class Range {
	
	private Point p1;
	private Point p2;
	public Range() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Range(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
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
	
	

}
