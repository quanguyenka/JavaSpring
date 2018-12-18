package train;

public class Main {
	public static void main(String[] args) {
		Thread2 thread2 = new Thread2();
		Thread th2 = new Thread(thread2);
		
		Thread1 th1 = new Thread1();
		
		th1.start();
		th2.start();
	}
}
