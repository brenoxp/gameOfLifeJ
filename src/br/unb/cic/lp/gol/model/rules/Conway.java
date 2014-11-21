package br.unb.cic.lp.gol.model.rules;

import java.util.List;

import br.unb.cic.lp.gol.model.GameEngine;
import br.unb.cic.lp.gol.view.Cell;
import br.unb.cic.lp.gol.view.Statistics;

public class Conway extends GameEngine{

	public Conway(int height, int width, Statistics statistics,
			List<Cell> listCells) {
		super(height, width, statistics, listCells);
	}
	
	public boolean shouldKeepAlive(int i, int j){
		int aliveNeighbors = numberOfNeighborhoodAliveCells(i, j);
		
		return (getListCellsItem(i, j).isAlive())
				&& (aliveNeighbors == 2 || aliveNeighbors == 3);
	}
	
	public boolean shouldRevive(int i, int j) {
		int aliveNeighbors = numberOfNeighborhoodAliveCells(i, j);
		return (!getListCellsItem(i, j).isAlive())
				&& (aliveNeighbors == 3);
	}
	
}