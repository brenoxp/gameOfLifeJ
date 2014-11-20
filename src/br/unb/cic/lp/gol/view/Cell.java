package br.unb.cic.lp.gol.view;

import java.awt.Rectangle;

public class Cell extends Rectangle {
	
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
