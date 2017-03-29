import java.util.Scanner;

public class knights {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt();
			int tmp = n;
			String pirates = "", knights = "", ninjas = "";
			while(tmp > 0) {
				int x = tmp % 10;
				tmp /= 10;
				
				if(x == 0)
					ninjas = "ninjas";
				if(x == 1)
					knights = "knights ";
				if(x > 4)
					pirates = "pirates ";
			}
			
			System.out.println((n + " " + knights + pirates + ninjas).trim());
		}
		scan.close();
	}
}