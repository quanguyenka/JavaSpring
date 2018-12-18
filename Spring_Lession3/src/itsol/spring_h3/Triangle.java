package itsol.spring_h3;

import java.util.List;

public class Triangle {

	private List<Point> list;
	
	
	
	public List<Point> getList() {
		return list;
	}



	public void setList(List<Point> list) {
		this.list = list;
	}



	public void draw() {
		for(Point point: list) {
			System.out.println("PointA("+point.getX()+","+point.getY()+")");
		}
	}
}
