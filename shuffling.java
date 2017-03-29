import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shuffling {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt(), k = scan.nextInt();
			int[] perm = new int[n];
			for(int i = 0; i < n; i++)
				perm[scan.nextInt() - 1] = i;
			
			int[] ans = new int[n];
			boolean[] used = new boolean[n];
			for(int i = 0; i < n; i++) {
				if(used[i])
					continue;
				
				List<Integer> cycle = new ArrayList<Integer>();
				int cur = i;
				while(!used[cur]) {
					cycle.add(cur);
					used[cur] = true;
					cur = perm[cur];
				}
				
				for(int j = 0; j < cycle.size(); j++) {
					ans[cycle.get((j + k) % cycle.size())] = cycle.get(j) + 1;
				}
			}
			
			boolean first = true;
			for(int i = 0; i < n; i++, first = false)
				System.out.printf("%s%d", first ? "" : " ", ans[i]);
			System.out.println();
		}
		scan.close();
	}
}