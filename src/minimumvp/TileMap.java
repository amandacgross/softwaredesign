package minimumvp;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileMap {
	ArrayList<Zone> arrayX = new ArrayList<Zone>();
	Scanner sc;
	
	public TileMap(File textFile){
		try {
			sc = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			System.out.println("not here");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){
			arrayX.add(new Zone(sc));
		}
	}
	
	public ArrayList<Zone> getMap(){
		return arrayX;
	}
	

//	public Tile getTile(int xCoord, int yCoord){
//		return arrayX.get((int)xCoord/8).get((int)yCoord/8);
//	}
}