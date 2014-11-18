package br.unb.cic.lp.gol;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends Rectangle {
	
	private static Color ALIVE_COLOR = Color.blue;
	private static Color DEAD_COLOR = Color.white;
	
	private boolean alive = false;
	
	public Cell(int x, int y, int cellWidth, int cellHeight) {
		super(x, y, cellWidth, cellHeight);
		
	}
    
	public boolean isAlive() {
		return alive;
	}

	public void kill() {
		this.alive = false;
	}
	
	public void revive() {
		this.alive = true;
	}

}
