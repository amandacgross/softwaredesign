package minimumvp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileMap {
	ArrayList<ArrayList<Tile>> arrayX = new ArrayList<ArrayList<Tile>>();
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
			ArrayList<Tile> temp = new ArrayList<Tile>();
			while(!s.isEmpty()){
				if(s.charAt(0) != ' '){
					switch(s.charAt(0)){
					case '1':
						temp.add(Tester.flat);
						break;
					case '2':
						temp.add(Tester.angledLeft);
						break;
					case '3':
						temp.add(Tester.angledRight);
						break;
					case '4':
						temp.add(Tester.angledUp);
						break;
					}
				}
				s=s.substring(1);
			}
			arrayX.add(temp);
		}
	}
	
	public ArrayList<ArrayList<Tile>> getMap(){
		return arrayX;
	}
}
