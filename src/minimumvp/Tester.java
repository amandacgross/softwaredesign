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

import javax.imageio.ImageIO;

public class Tester extends GameTemplate{
	
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
	
	static int timeLeft;
	static int progress=1;
	static File map1 = new File("map1.txt");
	static Tile flat = new Tile(tile1, 0, 0);
	static Tile angledRight = new Tile(tile2, 30, 1);
	static Tile angledLeft = new Tile(tile3, 30, 2);
	static Tile angledUp = new Tile(tile4, 45, 3);
	TileMap map = new TileMap(map1);
	Level level1 = new Level(map, 60, 50, 50, 110, 110);
	
	public static void main(String[] args){
		Tester game=new Tester();
		createGameFrame(game, 500, 800);
		game.init();
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	}
	
	public void updateFrame(Graphics2D g){
		System.out.println("ok");
		angledUp.draw(g, 57, 13);
		angledUp.draw(g, 83, -6);
		angledUp.draw(g, 31, -6);
		angledUp.draw(g, 57, -25);
		flat.draw(g, 50, 50);
		flat.draw(g, 80, 65);
		flat.draw(g, 20, 65);
		flat.draw(g, 50, 80);
		angledRight.draw(g, 110, 45);
		angledRight.draw(g, 80, 31);
		angledRight.draw(g, 107, 12);
		angledRight.draw(g, 137, 26);
		angledLeft.draw(g, -10, 45);
		angledLeft.draw(g, 20, 31);
		angledLeft.draw(g, -6, 12);
		angledLeft.draw(g, -37, 26);
		
	}

	@Override
	public void init() {
		timeLeft=level1.getAllottedTime();
		Player p = new Player(15, level1.getStartX(), level1.getStartY(), playerImg);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}
