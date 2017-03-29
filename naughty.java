import java.util.Scanner;

public class naughty {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int n = scan.nextInt(), days = scan.nextInt();
			SegmentTree[][] trees = new SegmentTree[10][10];
			for(int i = 1; i < 10; i++)
				for(int j = 0; j <= i; j++)
					trees[i][j] = new SegmentTree((int)Math.ceil((double)n / (i + 1)));
			
			for(int d = 1; d <= days; d++) {
				int s = scan.nextInt() - 1, k = scan.nextInt(), p = scan.nextInt();
				trees[k - 1][s % k].update(s / k, s / k + p - 1, 1);
			}
			
			int ans = 0, ans2 = -1;
			for(int i = 0; i < n; i++) {
				int res = 0;
				for(int j = 2; j <= 10; j++)
					res += trees[j - 1][i % j].query(i / j, i / j);
				
				if(res > ans2) {
					ans2 = res;
					ans = i + 1;
				}
			}
			
			System.out.printf("House %d should get the biggest and best gift next Christmas.\n", ans);
		}
		scan.close();
	}
	
	public static class SegmentTree {
		public int[] sum, delta;
		public int n;
		
		public SegmentTree(int n) {
			this.n = n;
			sum = new int[4 * n + 1];
			delta = new int[4 * n + 1];
		}
		
		private void prop(int i) {
			set(i * 2, delta[i]);
			set(i * 2 + 1, delta[i]);
			delta[i] = 0;
		}
		
		private void set(int i, int value) {
			delta[i] += value;
			sum[i] += value;
		}
		
		public void update(int left, int right, int value) {
			update(1, 0, n - 1, left, Math.min(right, n - 1), value);
		}
		
		private void update(int i, int lr, int rr, int left, int right, int value) {
			if(lr == left && rr == right) {
				set(i, value);
			} else {
				prop(i);
				int mid = (lr + rr) / 2;
				if(left <= mid)
					update(i * 2, lr, mid, left, Math.min(mid, right), value);
				if(mid < right)
					update(i * 2 + 1, mid + 1, rr, Math.max(mid + 1, left), right, value);
				sum[i] = sum[i * 2] + sum[i * 2 + 1];
			}
		}
		
		public int query(int left, int right) {
			return query(1, 0, n - 1, left, right);
		}
		
		private int query(int i, int lr, int rr, int left, int right) {
			if(lr == left && rr == right) {
				return sum[i];
			} else {
				prop(i);
				int mid = (lr + rr) / 2;
				int res = 0;
				if(left <= mid)
					res += query(i * 2, lr, mid, left, Math.min(mid, right));
				if(mid < right)
					res += query(i * 2 + 1, mid + 1, rr, Math.max(mid + 1, left), right);
				return res;
			}
		}
	}
}