package minimumvp;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileMap {
	ArrayList<ArrayList<Tile>> arrayX = new ArrayList<ArrayList<Tile>>();
	Scanner sc;
	
	public TileMap(File textFile){
//		try {
//			sc = new Scanner(textFile);
//		} catch (FileNotFoundException e) {
//			System.out.println("not here");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
//		while(sc.hasNext()){
//			String s = sc.nextLine();
//			ArrayList<Tile> temp = new ArrayList<Tile>();
//			while(!s.isEmpty()){
//				if(s.charAt(0) != ' '){
//					switch(s.charAt(0)){
//					case '1':
//						temp.add(Tester.flat);
//						break;
//					case '2':
//						temp.add(Tester.angledLeft);
//						break;
//					case '3':
//						break;
//					case '4':
//						temp.add(Tester.angledUp);
//						break;
//					}
//				}
//				s=s.substring(1);
//			}
//			arrayX.add(temp);
//		}
//	}
	
	public ArrayList<ArrayList<Tile>> getMap(){
		return arrayX;
	}
	
	public void drawMap(Graphics2D g, int anchorX, int anchorY){
		for(int i=0; i<arrayX.size(); i++){
			for(int j=0; j<arrayX.get(i).size(); j++){
				g.drawImage(arrayX.get(i).get(j).getImage(), 8*i, 8*j, null);
			}
		}
	}
	
	public Tile getTile(int xCoord, int yCoord){
		return arrayX.get((int)xCoord/8).get((int)yCoord/8);
	}
}
