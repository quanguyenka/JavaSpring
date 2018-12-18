package itsol.spring_h4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawTriangle4 {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("itsol/spring_h4/spring.xml");
		
		Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();
		
	}
}
