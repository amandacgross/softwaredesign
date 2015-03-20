package minimumvp;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileMap {
	ArrayList<ArrayList<Zone>> arrayX = new ArrayList<ArrayList<Zone>>();
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
			String s = sc.nextLine();
			ArrayList<Zone> temp = new ArrayList<Zone>();
			while(!s.isEmpty()){
				if(s.charAt(0) != ' '){
					switch(s.charAt(0)){
					case '1':
						temp.add(new Zone(sc));
						break;
					case '2':
						temp.add(new Zone(sc));
						break;
					case '3':
						break;
					case '4':
						temp.add(new Zone(sc));
						break;
					}
				}
				s=s.substring(1);
			}
			arrayX.add(temp);
		}
	}
	
	public ArrayList<ArrayList<Zone>> getMap(){
		return arrayX;
	}
	

//	public Tile getTile(int xCoord, int yCoord){
//		return arrayX.get((int)xCoord/8).get((int)yCoord/8);
//	}
}
