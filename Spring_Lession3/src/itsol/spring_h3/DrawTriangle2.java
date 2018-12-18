package itsol.spring_h3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawTriangle2 {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("itsol/spring_h3/spring.xml");
		
		Triangle triangle= (Triangle)context.getBean("triangle");
		triangle.draw();
	}
}
