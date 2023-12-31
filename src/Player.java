import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	/* A classe Rectangle nos permite manipular vetores, dimensões, colisores*/
	
	public int spd = 4;
	public boolean right, up, down, left; //variáveis de controle do player
	
	public Player(int x, int y) {
		super(x,y,30,30);
	}

	
	// Perguntar para o Zé o pq de ter um tick e um render na classe Game e um tick e um render na classe Player
	
	public void tick() { //Seria a mesma coisa que o Update() do C# ?
		
		if(right && World.isFree(x+spd, y) ) {
			x+=spd;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
		}
		
		// Perguntar para o Zé o pq do valor positivo ta fazendo o Player descer e o negativo, subir
		if(up && World.isFree(x, y - spd)) {
			y-=spd;
		}else if(down && World.isFree(x, y + spd)) {
			y+=spd;
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height); // adiciona a "g" (que será o render do nosso player) as propriedades
										// do retângulo
	}
	
	
}
