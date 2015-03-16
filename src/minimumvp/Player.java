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
	private int _speedY=0;
	public int xCoord;
	public int yCoord;
	public int size;
	public BufferedImage img; 
	public Rectangle2D bounds;

	/**
	 * Create a paddle 
	 */
	public Player(int size1, int x1, int y1, BufferedImage img1){
		super();
		//set size of paddle from image size 
		size=size1; 
		img=img1;
		xCoord=x1;
		yCoord=y1;
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
	public int getSpeedX() {
		return _speedX;
	}
	
	public int getSpeedY(){
		return _speedY;
	}
	
	public void setSpeedX(int speed1){
		_speedX=speed1;
	}
	
	public void setSpeedY(int speed1){
		_speedY=speed1;
	}
	
	/**
	 * @return  Speed to move with each frame
	 */
	public void setSpeed(int speed) {
		this._speedX = speed;
	}
	
	public int getXCoord(){
		return xCoord;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
	public void setXCoord(int x1){
		xCoord=x1;
	}
	
	public void setYCoord(int y1){
		yCoord=y1;
	}
	
	 public void doMove(int direction){
		 	switch(direction){
		 	case '0':
		 		setXCoord(getXCoord()-_speedX);
		 		break;
		 	case '1':
		 		setYCoord(getYCoord()+_speedY);
		 		break;
		 	case '2':
		 		setXCoord(getXCoord()+_speedX);
		 		break;
		 	case '3':
		 		setYCoord(getYCoord()-_speedY);
			}	 
	}
	 
	 public Rectangle2D getBounds(){
		 return bounds;
	 }
		
}
