package minimumvp;

import java.util.Scanner;

import org.newdawn.slick.geom.Polygon;

public class Zone {
	private float xslope;
	private float yslope;
	private int type;
	private float typechart[] =
		{ 	0f, 	0f, //flat slope type 1
			0f, 	1f, //go down type 2
			0.5f,	0.5f, //to the side type 3
			-0.5f,	0.5f,//to the other side type 4
			5f,		5f //fall zone, you die type 5
		};
	private float[] xCoordinates = new float[4];
	private float[] yCoordinates = new float[4];

	private Polygon shape;

	/* public Zone scans in data from a text file
	 * The first line specifies the type of slope
	 * next lines are vertices specifying the next points of the polygon
	 * end specifies the end of that specific polygon
	 * */
	public Zone (Scanner scr){
		String holder= scr.nextLine();
		
		type= (int) (Integer.parseInt(holder));
		if(type==5){
			xslope=typechart[2];
			yslope=typechart[3];
		}else{
		xslope=typechart[2*type];
		yslope=typechart[2*type+1];
		}
		float coordx;
		float coordy;
		shape = new Polygon();
		int i=0;
		while(scr.hasNextLine()){
			holder=scr.nextLine();
			if(holder.equals("END")){
				shape.closed();
				break;
			}
			else{
				coordx = (int)Double.parseDouble(holder.substring(0,3).trim());
				coordy = (int)Double.parseDouble(holder.substring(4).trim());
				xCoordinates[i] = coordx;
				yCoordinates[i] = coordy;
				shape.addPoint(coordx,coordy);
				System.out.println(coordx);
				System.out.println(coordy);
				i++;
			}
		}	
	}
	
	public void shift(double mapX, double mapY){
		shape = new Polygon();
		for(int i=0; i<4; i++){
			xCoordinates[i]=(float) (xCoordinates[i]+mapX);
			yCoordinates[i]=(float) (yCoordinates[i]+mapY);
			shape.addPoint(xCoordinates[i], yCoordinates[i]);
		}
		shape.closed();
	}
	
	public Polygon getShape(){
		return shape;
	}
	
	public int getType(){
		return type;
	}
}