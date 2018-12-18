import java.util.Scanner;

public class Fibo {
	public static void main(String[] args) {
		System.out.print("Nhap n: ");
		int n = new Scanner(System.in).nextInt();
		int dem = 0;
		int sot = 0, sos = 1;
		int temp = 0;
		System.out.printf("So fibo thu 0 la: 0\n");
		System.out.printf("So fibo thu 1 la: 1\n");
		for (int i = 2; dem <= n-2; i++) {			
			if (dem <= n) {
				temp = sos;
				sos = sot + sos;
				sot = temp;
				dem++;
				System.out.printf("So fibo thu %d la: %d\n",i, sos);
			} else {
				break;
			}
		}
	}
}
