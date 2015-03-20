//TODO
//make new spritesheets of the ball to show it moving in different directions
//figure out what coordinates the tiles will be at
//

package minimumvp;

import java.io.File;
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
	double playerX = 185;
	double playerY = 50;
	double mapX = 0;
	double mapY = 0;
	Animation playerMove;
	boolean move = false;
	Image map;
	Image starter;
	Image lostScreen;
	int timer=60;
	Timer t = new Timer();
	boolean start = false;
	boolean lost = false;
//	TileMap tileMap = new TileMap(new File("data/ZoneData"));
	
	public GameScreen(int state){
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException{
		player = new SpriteSheet("data/playerball.png", 64, 64);
		playerMove = new Animation(player, 100);
		map = new Image("data/ugh.png");
		starter = new Image("data/start.jpg");
		lostScreen = new Image("data/lostScreen.png");
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		map.draw((int)mapX, (int)mapY);
		playerMove.draw((int)playerX, (int)playerY);
		g.drawString(timer + "", 50, 50);
		if(start == false){
			starter.draw(100, 100);
		}
		if(lost == true){
			lostScreen.draw(10, 10);
		}
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_ENTER)){
			start = true;
		}
		if(start == true && lost == false){
		if(input.isKeyDown(Input.KEY_UP)){
			if(playerY < 70){
				mapY = mapY + .5;
			}else{
				playerY = playerY-.5;
			}
			move =true;
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			if(playerY > 550){
				mapY = mapY-.5;
			}else{
				playerY = playerY+.5;
			}
			move = true;
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			playerX = playerX-.5;
			move = true;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			playerX = playerX+.5;
			move = true;
		}
		t.tick();
		if(t.getTime()>=1){
			timer--;
			t.reset();
		}
		if(move == true){
			if(playerX < 550){
				playerX = playerX + .25;
			}
			if(playerY > 70 && playerY <550){
				playerY = playerY + .25;
			}
		}
		if(playerY >= 550){
			mapY = mapY-.5;
		}
		}
		if(timer == 0){
			lost=true;
		}
	}
	
	public int getID(){
		return 1;
	}
}
