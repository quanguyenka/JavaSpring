package itsol.spring_h1;

public class Triangle {
	
	private String type;
	private int height;
	
	public Triangle(String type) {
		this.type =  type;
	}
	public Triangle(int height) {
		this.height = height;
	}
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	
	public void draw() {
		System.out.println(getType() + " Triangle draw with height = " +getHeight());
	}

	public String getType() {
		return type;
	}
	public int getHeight() {
		return height;
	}
	
		
}
