package minimumvp;

public class Level {
	public TileMap map;
	public int allottedTime;
	public int startX;
	public int startY;
	public int goalX;
	public int goalY;
	
	public Level(TileMap map1, int time1, int x1, int y1, int goalx1, int goaly1){
		map=map1;
		allottedTime=time1;
		startX=x1;
		startY=y1;
		goalX=goalx1;
		goalY=goaly1;
	}
	
	public TileMap getMap(){
		return map;
	}
	
	public int getAllottedTime(){
		return allottedTime;
	}
	
	public int getStartX(){
		return startX;
	}
	
	public int getStartY(){
		return startY;
	}
}
