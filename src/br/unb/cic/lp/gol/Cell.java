package br.unb.cic.lp.gol;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Cell extends JButton {
	
	private static Color ALIVE_COLOR = Color.blue;
	private static Color DEAD_COLOR = Color.white;
	
	private boolean alive = false;
    
    public Cell() {
        this(null);
        setBackground(DEAD_COLOR);
    }

    private Cell(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    //muda a cor do botao
    @Override
    protected void paintComponent(Graphics b) {
        if (isAlive()) {
        	if (getModel().isPressed()) {
        		b.setColor(DEAD_COLOR); 
        		this.kill();
        	} else {
        		b.setColor(ALIVE_COLOR);
        	}
        } 
        
        else if (!isAlive()) {
        	if (getModel().isPressed()) {
        		b.setColor(ALIVE_COLOR);
        		this.revive();
        	} else {
        		b.setColor(DEAD_COLOR);
        	}
        }
        
  
        b.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(b);  
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
