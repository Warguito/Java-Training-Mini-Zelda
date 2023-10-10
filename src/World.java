import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Blocks> blocos = new ArrayList<Blocks>();
	// os blocos precisam estar como Static para que seja possível acessálos pela função
	
	public World() {
		
/*--------------------------------------------------------------------------------------------------------------------------
 * 											Criação do Array de blocos e seu posicionamento
 * -----------------------------------------------------------------------------------------------------------------------*/
		for(int xx = 0; xx < 9; xx++ ) {
			blocos.add(new Blocks(xx*100, 0));
		}
		
		for(int xx = 0; xx < 9; xx++ ) {
			blocos.add(new Blocks(xx*100, 900-100));
		}
		
		for(int yy = 0; yy < 9; yy++ ) {
			blocos.add(new Blocks(0, yy*100));
		}
		
		for(int yy = 0; yy < 9; yy++ ) {
			blocos.add(new Blocks(900-100, yy*100));
		}
		
	}
//----------------------------------------------------------------------------------------------------------------------------
	
/*--------------------------------------------------------------------------------------------------------------------------
* 											Criação das Colisões
* -----------------------------------------------------------------------------------------------------------------------*/
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocos.size(); i++) {
			Blocks blocoAtual = blocos.get(i);	
			if(blocoAtual.intersects(new Rectangle(x,y,100,100))){
				return false;
				}
			}
		
		return true;
	}
	
	/*public void render(Graphics g) {
		for(int i =0; i < blocos.size(); i++) {
			blocos.get(i).render(g);
		}
	}*/
}
