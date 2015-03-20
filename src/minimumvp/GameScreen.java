package minimumvp;

import org.lwjgl.util.Timer;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameScreen extends BasicGameState {

	SpriteSheet player;
	int playerX = 0;
	int playerY = 0;
	int mapX = 0;
	int mapY = 0;
	Animation playerMove;
	boolean move = false;
	Image map;
	int timer=60;
	Timer t = new Timer();
	
	public GameScreen(int state){
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException{
		player = new SpriteSheet("data/playerball.png", 64, 64);
		playerMove = new Animation(player, 100);
		map = new Image("data/marble-all.png");
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		map.draw(mapX, mapY);
		playerMove.draw(playerX, playerY);
		g.drawString(timer + "", 50, 50);
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			if(playerY < 70){
				mapY = mapY + 1;
			}else{
				playerY = playerY-1;
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			if(playerY > 550){
				mapY = mapY-1;
			}else{
				playerY = playerY+1;
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			playerX = playerX-1;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			playerX = playerX+1;
		}
		t.tick();
		if(t.getTime()>=1){
			timer--;
			t.reset();
		}
	}
	
	public int getID(){
		return 1;
	}
}
