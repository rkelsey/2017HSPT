import java.util.Scanner;
import java.util.TreeMap;

public class yertle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt(), w = scan.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for(int i = 0; i < n - 1; i++) {
				int x = scan.nextInt();
				if(!map.containsKey(x))
					map.put(x, 0);
				map.put(x, map.get(x) + 1);
			}
			
			int maxHeight = 1;
			int nTurtles = 1;
			while(nTurtles <= n) {
				maxHeight++;
				nTurtles += maxHeight;
			}
			maxHeight--;
			
			double[][] arr = new double[maxHeight][maxHeight + 2];
			for(int i = 1; i < maxHeight; i++) {
				int[] weight = new int[i + 2];
				for(int j = 1; j <= i; j++)
					weight[j] = w;
				
				for(int j = 1; j <= i + 1; j++)
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j] + weight[j - 1] + weight[j]) / 2;
			}
			
			int ans = 1;
			loop:for(int i = 1; i < maxHeight; i++) {
				for(int j = 1; j <= i + 1; j++) {
					Integer match = map.ceilingKey((int)Math.ceil(arr[i][j]));
					if(match == null)
						break loop;
					
					int val = map.get(match);
					if(val == 1)
						map.remove(match);
					else
						map.put(match, val - 1);
				}
				ans++;
			}
			
			System.out.printf("Pond #%d: %s\n", z, ans == 1 ? "Poor Yertle." : String.format("The pyramid is %d turtles high!", ans));
		}
		scan.close();
	}
}