import java.util.Scanner;

public class MaTran {
	static Scanner inp = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("---MA TRAN THU NHAT--- ");
		System.out.print("Nhap so hang n: ");
		int n = new Scanner(System.in).nextInt();
		System.out.print("Nhap so cot m:");
		int m = new Scanner(System.in).nextInt();

		int mt1[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("Nhap phan tu thu["+i+", "+j+"] = ");
				mt1[i][j] = inp.nextInt();
			}
		}

		System.out.println("---MA TRAN THU HAI--- ");
		System.out.print("Nhap so hang n: ");
		int x = new Scanner(System.in).nextInt();
		System.out.print("Nhap so cot m: ");
		int y = new Scanner(System.in).nextInt();

		int mt2[][] = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("Nhap phan tu thu["+i+", "+j+"] = ");
				mt2[i][j] = inp.nextInt();
			}
		}
		
		System.out.println("Tong hai ma tran: ");
		for(int i = 0; i < mt1.length; i++) {
			for(int j = 0; j < mt2.length; j++) {
				System.out.print((mt1[i][j] + mt2[i][j]) +"\t");				
			}
			System.out.println();
		}
		
		System.out.println("Tru hai ma tran: ");
		for(int i = 0; i < mt1.length; i++) {
			for(int j = 0; j < mt2.length; j++) {
				System.out.print((mt1[i][j] - mt2[i][j]) +"\t");				
			}
			System.out.println();
		}
		
		int mt3[][] = new int[mt1.length][mt2[0].length];
		System.out.println(mt2[0].length);
		System.out.println("Tich hai ma tran: ");
		for(int i = 0; i <mt1.length; i++) {			
			for(int j = 0; j < mt2.length; j ++) {
				for(int l = 0; l < mt2[0].length; l++) {
					mt3[i][j] += mt1[i][l]*mt2[l][j];
				}
				System.out.print(mt3[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}
