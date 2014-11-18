package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe que atua como um controlador do 
 * padrao MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController {

	private GameEngine engine;
	private GameView board;
	private Statistics statistics;
	
	public GameEngine getEngine() {
		return engine;
	}
	
	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}
	
	public GameView getBoard() {
		return board;
	}
	
	public void setBoard(GameView board) {
		this.board = board;
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	public void start() {
//		board.update();
	}
	
	public void halt() {
		engine.halt();
	}
	

	
	public void makeCellAlive(int i, int j) {
		try {
			engine.makeCellAlive(i, j);
//			board.update();
		}
		catch(InvalidParameterException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void nextGeneration() {
		//Declare the timer
		
		final Timer t = new Timer();
		//Set the schedule function and rate
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	engine.nextGeneration();
		    	if(board.update() == false) {
		    		t.cancel();
		    	}
				
			
		    }

		},
		//Set how long before to start calling the TimerTask (in milliseconds)
		0,
		//Set the amount of time between each execution (in milliseconds)
		100);
		
//		t.cancel();
		
	}
	
}
