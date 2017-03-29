import java.util.Scanner;

public class power {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++)
			System.out.println((1 << scan.nextInt()) - 1);
		scan.close();
	}
}