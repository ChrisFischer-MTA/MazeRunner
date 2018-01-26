package io.github.chrisfischermta;

import java.util.ArrayList;

public class point {
	int x;
	int y;
	ArrayList<point> pastPoints = new ArrayList();	
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
		pastPoints.add(this);
	}
	
	public point(int x, int y, ArrayList<point> past) {
		this.x = x;
		this.y = y;
		pastPoints.addAll(past);
		pastPoints.add(this);
	}
	
}
