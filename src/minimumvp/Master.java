package minimumvp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javax.imageio.ImageIO;

public class Master extends StateBasedGame{
	
	private static BufferedImage tile1=null;
	{try{
		tile1=ImageIO.read(new File("tile1.png"));
	} catch(IOException ex){
		System.out.println("Background is not available");
	}
	}
	private static BufferedImage tile2=null;
	{try{
		tile2=ImageIO.read(new File("tile2.png"));
	} catch(IOException ex){
		System.out.println("Background is not available");
	}
	}
	private static BufferedImage tile3=null;
	{try{
		tile3=ImageIO.read(new File("tile3.png"));
	} catch(IOException ex){
		System.out.println("Background is not available");
	}
	}
	private static BufferedImage tile4=null;
	{try{
		tile4=ImageIO.read(new File("tile4.png"));
	} catch(IOException ex){
		System.out.println("Background is not available");
	}
	}
	private static BufferedImage playerImg=null;
	{try{
		playerImg=ImageIO.read(new File("ball.png"));
	} catch(IOException ex){
		System.out.println("Background is not available");
	}
	}
	
	static final int statePlaying = 1;
	static int timeLeft;
	static int progress=1;
	static File map1 = new File("map1.txt");
	static Tile flat = new Tile(tile1, 0, 0);
	static Tile angledRight = new Tile(tile2, 30, 1);
	static Tile angledLeft = new Tile(tile3, 30, 2);
	static Tile angledUp = new Tile(tile4, 45, 3);
	TileMap map = new TileMap(map1);
	Level level1 = new Level(map, 60, 50, 50, 110, 110);
	
	public Master(String gameName){
		super(gameName);
		this.addState(new GameScreen(1));
	}
	
	public void initStatesList(GameContainer container) throws SlickException{
		this.getState(statePlaying).init(container, this);
		this.enterState(statePlaying);
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Master("Lucid"));
			appgc.setDisplayMode(640, 640, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
	
}
