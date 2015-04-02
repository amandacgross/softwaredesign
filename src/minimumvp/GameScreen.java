//TODO
//make new spritesheets of the ball to show it moving in different directions
//figure out what coordinates the tiles will be at
//if ball does not overlap with any tiles, then fall off.  what if when you fell, you had to play the falling part and eventually end up on the tumble part again

package minimumvp;

import java.io.File;

import org.lwjgl.util.Timer;
import org.newdawn.slick.*;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameScreen extends BasicGameState {

	SpriteSheet player;
	SpriteSheet dir2;
	double playerX = 185;
	double playerY = 50;
	double mapX = 0;
	double mapY = 0;
	Animation playerMove;
	Animation move2;
	boolean move = false;
	Image map;
	Image starter;
	Image lostScreen;
	Image wonScreen;
	int timer=60;
	Timer t = new Timer();
	boolean start = false;
	boolean lost = false;
	boolean won = false;
	int direction = 1;
	TileMap tileMap = new TileMap(new File("data/ZoneData"));
	int mouseX;
	int mouseY;
	Polygon test;
	
	public GameScreen(int state){
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException{
		player = new SpriteSheet("data/playerball.png", 64, 64);
		dir2 = new SpriteSheet("data/playerball2.png", 64, 64);
		playerMove = new Animation(player, 50);
		move2 = new Animation(dir2, 50);
		map = new Image("data/ugh.png");
		starter = new Image("data/start.jpg");
		lostScreen = new Image("data/lostScreen.png");
		wonScreen = new Image("data/winning-ticket.gif");
		test = tileMap.getMap().get(3).getShape();
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		map.draw((int)mapX, (int)mapY);
		if(direction ==1 && lost ==false && won == false){
			playerMove.draw((int)playerX, (int)playerY);
		}else if(direction ==2 && lost ==false && won ==false){
			move2.draw((int)playerX, (int)playerY);
		}
		g.drawString(timer + "", 450, 40);
		if(start == false){
			starter.draw(100, 100);
		}
		if(lost == true){
			lostScreen.draw(10, 10);
		}
		if(won == true){
			wonScreen.draw(0, 0);
		}
		g.setColor(Color.red);
	//	g.draw(test);
		g.setColor(Color.blue);
		for(int i=0; i<tileMap.getMap().size(); i++){
	//		g.draw(tileMap.getMap().get(i).getShape());
		}
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		Input input = container.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			mouseX = input.getMouseX();
			mouseY = input.getMouseY();
			System.out.println(mouseX);
			System.out.println(mouseY);
		}
		
		
		if(input.isKeyDown(Input.KEY_ENTER)){
			start = true;
		}
		
		
		if(start == true && lost == false){
			if(input.isKeyDown(Input.KEY_UP)){
				if(playerY < 70){
					mapY = mapY + .5;
					for(int i=0; i<tileMap.getMap().size(); i++){
						tileMap.getMap().get(i).shift(0, .5);
					}
				}else{
					playerY = playerY-.5;
				}
				move =true;
			}
			if(input.isKeyDown(Input.KEY_DOWN)){
				if(playerY > 550){
					mapY = mapY-.5;
					for(int i=0; i<tileMap.getMap().size(); i++){
						tileMap.getMap().get(i).shift(0, -.5);
					}
				}else{
					playerY = playerY+.5;
				}
				move = true;
			}
			if(input.isKeyDown(Input.KEY_LEFT)){
				playerX = playerX-.5;
				move = true;
				direction=2;
			}
			if(input.isKeyDown(Input.KEY_RIGHT)){
				playerX = playerX+.5;
				move = true;
				direction=1;
			}
			t.tick();
			if(t.getTime()>=1){
				timer--;
				t.reset();
			}
			if(move == true){
				for(int i=0; i<tileMap.getMap().size(); i++){
					if(tileMap.getMap().get(i).getShape().contains((float)(playerX+32), (float)(playerY+32))){
						move(tileMap.getMap().get(i).getType());
					}
				}
			}
			if(playerY >= 550){
				mapY = mapY-.5;
				for(int i=0; i<tileMap.getMap().size(); i++){
					tileMap.getMap().get(i).shift(0, -.5);
				}
			}
		}
		if(timer == 0){
			lost=true;
		}

		test = tileMap.getMap().get(3).getShape();
	}

	public int getID(){
		return 1;
	}

	public void move(int tileType){
		switch(tileType){
		case 1:
			if(playerX < 550){
				playerX = playerX + .125;
			}
			if(playerY > 70 && playerY <550){
				playerY = playerY + .125;
			}
			break;
		case 2:
			if(playerY > 70 && playerY <550){
				playerY = playerY + .35;
			}
			break;
		case 3:
			if(playerX < 550){
				playerX = playerX + .35;
			}
			if(playerY > 70 && playerY <550){
				playerY = playerY + .225;
			}
			break;
		case 4:
			if(playerX < 550){
				playerX = playerX - .35;
			}
			if(playerY > 70 && playerY <550){
				playerY = playerY + .225;
			}
			break;
		case 0:
			lost = true;
			break;
		case 5:
			won = true;
			break;
		}
	}
}