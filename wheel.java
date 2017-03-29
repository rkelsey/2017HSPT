import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class wheel {
	public static int[] memo;
	public static List<Integer>[] edgeList;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt(); scan.nextLine();
			String[][] arr = new String[n][];
			for(int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split("\\s+");
				arr[i] = new String[] {arr[i][0], arr[i][arr[i].length - 1]};
			}
			
			Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
			for(int i = 0; i < n; i++) {
				String s = arr[i][0];
				if(!map.containsKey(s))
					map.put(s, new ArrayList<Integer>());
				map.get(s).add(i);
			}
			
			edgeList = new List[n];
			
			for(int i = 0; i < n; i++)
				edgeList[i] = map.get(arr[i][1]);
			
			memo = new int[n];
			Arrays.fill(memo, -1);
			int ans = 0;
			for(int i = 0; i < n; i++)
				ans = Math.max(ans, 1 + go(i));
			
			System.out.printf("Puzzle #%d: %d\n", z, ans);
		}
		scan.close();
	}
	
	public static int go(int node) {
		if(memo[node] > -1)
			return memo[node];
		else if(edgeList[node] == null)
			return 0;
		
		int ans = 0;
		for(int adj : edgeList[node])
			ans = Math.max(ans, 1 + go(adj));
		return memo[node] = ans;
	}
}