package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

/**
 * Atua como um componente de apresentacao (view), exibindo o estado atual do
 * game com uma implementacao baseada em caracteres ASCII.
 * 
 * @author rbonifacio
 */
public class GameView {

	private int width;
	private int height;
	
	private GameController controller;
	private JPanel controls;
	private JPanel grid;
	private List<Cell> cells;

	/**
	 * Construtor da classe GameBoard
	 */
	public GameView(int height, int width,GameController controller) {
		this.width = width;
		this.height = height;
		this.controller = controller;
		
		cells = new ArrayList<Cell>();
		
		initUI();
	}
	
	public List<Cell> getCells() {
		return cells;
	}
	
	/**
	 * Inicia a interface grafica.
	 * 
	 */
	public void initUI() {


		//Criacao da janela principal da aplicacao
		JFrame window = new JFrame("Game of Life");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(700, 700);
		window.setVisible(true);
		window.setLocationRelativeTo(null);

		//Cria as areas de controls e grid, aqui eh passado como parametrowindow
		//e controls porque serao usados para calcular os tamanhos de
		//grid e controls de acordo com a window
		this.controls = createButtonsMenu(window);
		this.grid = createGrid(window, controls);
		
		//Insere as areas de controls e grid na window
		window.add(controls,  BorderLayout.NORTH);
		window.add(grid,  BorderLayout.SOUTH);
		window.pack();

	}
	
	
	private JPanel createButtonsMenu(JFrame window) {
		JButton nextGeneration = new JButton("Next");
		nextGeneration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				controller.nextGeneration();
			}
		});
		
		JButton haltButton = new JButton("Halt");
		haltButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				controller.halt();
			}
		});
		
		
	    //Criacao do painel de controlhes do jogo
		JPanel controls = new JPanel();
		controls.setBackground(Color.red);
		controls.setPreferredSize(new Dimension(window.getSize().width, 40));
		controls.add(nextGeneration);
		controls.add(haltButton);
		
		return controls;
	}
	
	private JPanel createGrid(JFrame window, JPanel controls) {
		//Criacao do grid onde estao posicionadas as celulas
		JPanel grid = new JPanel();
		grid.setPreferredSize(new Dimension(window.getSize().width, 
				window.getSize().height - controls.getSize().height - 67));

		
		grid.setLayout(new GridLayout(height, width));
		
     
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Cell cell = new Cell();

				this.cells.add(cell);
				
				grid.add(cell);
			}
		}
		
        
		
		
		return grid;
	}

	


}


