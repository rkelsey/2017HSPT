import java.util.Arrays;
import java.util.Scanner;

public class shoes {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = scan.nextInt();
			
			Arrays.sort(arr);
			int ans = 0;
			for(int i = 0; i < n; i++) {
				if(i < n - 1 && arr[i + 1] - arr[i] <= 2)
					i++;
				ans++;
			}
			
			System.out.printf("Litter #%d: %d\n", z, ans);
		}
		scan.close();
	}
}