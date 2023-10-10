import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	// O KeyListener permite a chamada dos inputs
	
	public static int WIDTH = 1080, HEIGHT = 720; // Que nem no XNA, define o tamanho da janela
	public Player player;
	
	public Game() {
		this.addKeyListener(this);
	/* Esse método diz que eu desejo implementar eventos de teclado. O "this" diz que esses eventos já foram criados dentro
	desse script*/
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT)); 
		// Define quais parâmetros vão ser usados para a criação da janela
		
		player = new Player(0,0);
	}

	public void tick() // Responsável pela lógica (movimentação, colisões, etc)
	{
		player.tick();
	}
	
	public void render() // Responsável pela renderização
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) { // Verifica se há um buffer strategy, se não houver, ele cria um novo, se houver, ele simplesmente
						// retorna.
			this.createBufferStrategy(3);
			return;
	}
		
		Graphics g = bs.getDrawGraphics();
		
		// É necessário reiniciar o buffer, caso contrário a tela ficará bugada (piscando loucamente)
		// Pra isso, primeiro coloca o fundo e depois o "Player"
		//******Perguntar isso pro Zé depois*******
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		player.render(g);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		
		/*-----------------------------------------------------------------------------------------------------------------
														Criação da Janela
		-----------------------------------------------------------------------------------------------------------------*/
		JFrame frame = new JFrame();
		// JFrame chama a janela do Java
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.add(game); 
		//Chama o Game para a janela
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.setTitle("сука блять"); 	// Define o título da janela
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.pack(); 
		//Reune todas as informações listadas acima para calcular corretamente o tamanho da janela
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.setLocationRelativeTo(null); 	
		// Faz com que a janela sempre abra no centro da tela
		// Obrigatóriamente tem que vir depois do "frame.pack();"
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// Faz com que a aplicação seja encerrada quando a janela é fechada, assim liberando memória
		
		//-----------------------------------------------------------------------------------------------------------------
		
		frame.setVisible(true); 
		// Faz com que a janela seja visível
		/*
		-----------------------------------------------------------------------------------------------------------------
														Fim da Criação da Janela
		-----------------------------------------------------------------------------------------------------------------*/
		
		
		
		/*						
	 	-----------------------------------------------------------------------------------------------------------------							
		  												Criação do Game Loop
		-----------------------------------------------------------------------------------------------------------------*/
		
		new Thread(game).start();
		
		
	}
	@Override
	public void run() { // Faz o jogo rodar em loop
		
		while(true) {
			tick();
			render();
			
			try {
				Thread.sleep(1000/60); // Comando para fazer o jogo rodar a 60FPS					
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			/* O comando Try/Catch serve para caso o jogo não consiga realizar o comando inserido dentro do TRY, ele
			  irá indicar um erro*/
			
			//System.out.println("Chamando o Game Loop... ");
		}
		
/*----------------------------------------------------------------------------------------------------------------------------
		Fim da criação do Game Loop
----------------------------------------------------------------------------------------------------------------------------*/
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	//movimento no eixo X
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		
	//movimento no eixo Y
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	//movimento no eixo X
		
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		} 
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		
	//movimento no eixo Y
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down= false;
		}
	}

}
