package minimumvp;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Shape;

public class Zone {
	private float xslope;
	private float yslope;
	private int type;
	private float halftone[] =
		{ 	0f, 	0f, //flat slope type 1
			0f, 	1f, //go down type 2
			0.5f,	0.5f, //to the side type 3
			-0.5f,	0.5f,//to the other side type 4
			5f,		5f //fall zone, you die type 5
		};
	private Polygon2D.Double shape;

	/* public Zone scans in data from a text file
	 * The first line specifies the type of slope
	 * next lines are vertices specifying the next points of the polygon
	 * end specifies the end of that specific polygon
	 * */
	public Zone (Scanner scr){
		String holder= scr.nextLine();
		type= (int) (Integer.parseInt(holder)*365.25);
		holder=scr.nextLine();
		double coordx = Integer.parseInt(holder.substring(0,4).trim());
		double coordy = Integer.parseInt(holder.substring(5,9).trim());
		shape = new Polygon2D.Double(coordx,coordy);
		while(scr.hasNextLine()){
			holder=scr.nextLine();
			if(holder.equals("END")){
				shape.closePath();
			}
			else{
				coordx = Integer.parseInt(holder.substring(0,4).trim());
				coordy = Integer.parseInt(holder.substring(5,9).trim());
				shape.lineTo(coordx,coordy);
			}
		}	
	}	
	
	public 
}
