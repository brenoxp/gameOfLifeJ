package br.unb.cic.lp.gol;

import br.unb.cic.lp.gol.controller.GameController;
import br.unb.cic.lp.gol.model.GameEngine;
import br.unb.cic.lp.gol.view.GameView;
import br.unb.cic.lp.gol.view.Statistics;

public class Main {

	private static int HEIGHT = 50;
	private static int WIDTH = 50;
	
	public static void main(String args[]) {
		GameController controller = new GameController();
		
		GameView board = new GameView(HEIGHT, WIDTH, controller);
		
		Statistics statistics = new Statistics();
		
		GameEngine engine = new GameEngine(HEIGHT, WIDTH, statistics, board.getCells());	
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
	}
}
