package minimumvp;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage; //image 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO; //loader
/**
 * A Paddle
 * @author fowlerda
 *
 */
public class Player extends Sprite{
	private int _speedX=0; 
	public int topX=0;
	public int xCoord=0;
	public int yCoord=0;
	public int topY=0;
	public int size;
	public int range=size;
	public BufferedImage img; 
	public Rectangle2D bounds;

	/**
	 * Create a paddle 
	 */
	public Player(int sizeX,int sizeY, BufferedImage img1){
		super();
		//set size of paddle from image size 
		setSizeY(sizeY);
		setSizeX(sizeX); 
		img=img1;
	}
	
	/**
	 * Draw the paddle on the screen
	 */
	public void draw(Graphics2D g){
		g.drawImage(img, xCoord, yCoord, null);
	}
	
	/**
	 *
	 * @return  Speed to move with each frame
	 */
	public int getSpeed() {
		return _speedX;
	}
	
	/**
	 * @return  Speed to move with each frame
	 */
	public void setSpeed(int speed) {
		this._speedX = speed;
	}
	
	public int getTopX() {
		return topX;
	}
	
	public void setTopX(int x) {
		this.topX = x;
		xCoord[0]=x-getSizeX();
		xCoord[1]=x;
		xCoord[2]=x+getSizeX();
	}
	
	public int getTopY() {
		return topY;
	}
	public void setTopY(int y){
		this.topY = y;
		yCoord[0]=y;
		yCoord[1]=y-3*getSizeY();
		yCoord[2]=y;
	}
	
	 public void doMove(boolean moveLeftOrRight){
		 
			if(moveLeftOrRight==true) { //move up
				setTopX(getTopX()-_speedX);
			} else {
				setTopX(getTopX()+_speedX); //move down
			}
		 
	}
	 
	 public void setSprite(int[] xCoord, int[] yCoord){
		 this.sprite = new Polygon(xCoord, yCoord, 3);
	 }
	 
	 public Polygon getSprite(){
		 return sprite;
	 }
	 
	 public Rectangle2D getBounds(){
		 return bounds;
	 }
		
}
