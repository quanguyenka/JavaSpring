package itsol.spring_h4;

public class Triangle {
	private Point pointA,pointB, pointC;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("PointA("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointA("+getPointC().getX()+","+getPointC().getY()+")");
	}
}
