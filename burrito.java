import java.util.Scanner;

public class burrito {
	public static void main(String[] args) {
		final double PI = 3.141592653589793;
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			double v = scan.nextDouble(), r = scan.nextDouble();
			double l = v / PI / r / r, c = 2 * PI * r;
			
			double w = scan.nextDouble(), ll = scan.nextDouble();
			System.out.printf("Burrito #%d: %s\n", z, works(w, ll, r, l, c) || works(ll, w, r, l, c) ? "Don't worry, the burrito fits!" : "Looks like a cold burrito today.");
		}
		scan.close();
	}
	
	public static boolean works(double w, double ll, double r, double l, double c) {
		return w >= c && (ll - l) / 2.0 >= r;
	}
}