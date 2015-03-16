package minimumvp;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	public BufferedImage img=null;
	public int angle;
	public int direction;
	public int accel;

	public Tile(BufferedImage img1, int angle1, int direction1){
		img=img1;
		angle=angle1;
		direction=direction1;
		accel= (int) (9.8*Math.sin((double)angle));
	}
	
	public int getAngle(){
		return angle;
	}
	
	public BufferedImage getImage(){
		return img;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public int getAccel(){
		return accel;
	}
	
	public void draw(Graphics2D g, int xCoord, int yCoord){
		g.drawImage(img, xCoord, yCoord, null);
		System.out.println("k");
	}
}
