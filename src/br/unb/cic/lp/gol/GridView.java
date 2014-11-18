package br.unb.cic.lp.gol;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class GridView extends JPanel{

    private int columnCount;
    private int rowCount;
    private List<Cell> cells;
    private Point selectedCell;
    private GameController controller;

    public GridView(final int rowCount, final int columnCount, GameController controller) {
    	this.rowCount = rowCount;
    	this.columnCount = columnCount;
    	this.controller = controller;
    	
        cells = new ArrayList<Cell>(columnCount * rowCount);
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {

                int width = getWidth();
                int height = getHeight();

                int cellWidth = width / columnCount;
                int cellHeight = height / rowCount;

                int column = e.getX() / cellWidth;
                int row = e.getY() / cellHeight;

                selectedCell = new Point(column, row);
                
                clickCell(selectedCell);
                
                repaint();
            }

			@Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });
        
        
    }

    
    private void clickCell(Point selectedCell) {
		int column = (int) selectedCell.getX();
		int row = (int) selectedCell.getY();
		
		controller.clickedCell(row, column);
	}


    @Override
    public void invalidate() {
        cells.clear();
        selectedCell = null;
        super.invalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;

        if (cells.isEmpty()) {
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Cell cell = new Cell(
                            xOffset + (col * cellWidth),
                            yOffset + (row * cellHeight),
                            cellWidth,
                            cellHeight);
                    cells.add(cell);
                }
            }
        }

        
        for (Cell cell : cells) {
        	if(cell.isAlive()) {
                g2d.setColor(Color.BLUE);
                g2d.fill(cell);
        	}
        }
        

        g2d.setColor(Color.GRAY);
        for (Rectangle cell : cells) {
            g2d.draw(cell);
        }

        g2d.dispose();
    }
    
    public List<Cell> getCells() {
    	return cells;
    }


}