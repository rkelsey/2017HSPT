import java.util.Scanner;

public class diamond {
	public static char[][] grid;
	public static boolean[][] good;
	public static int rows, cols;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			rows = scan.nextInt();
			cols = scan.nextInt();
			grid = new char[rows][cols];
			for(int i = 0; i < rows; i++)
				grid[i] = scan.next().toCharArray();
			
			good = new boolean[rows][cols];
			for(int i = 0; i < rows; i++)
				for(int j = 0; j < cols - 1; j++)
					go(i, j, j + 1, true);
			
			System.out.printf("Slab #%d:\n", z);
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++)
					System.out.print(good[i][j] ? grid[i][j] : ".");
				System.out.println();
			}
		}
		scan.close();
	}
	
	public static boolean go(int r, int c1, int c2, boolean top) {
		if(r >= rows || c1 < 0 || c2 >= cols)
			return false;
		
		if(top && grid[r][c1] == '/' && grid[r][c2] == '\\')
			if(go(r + 1, c1, c2, false) | go(r + 1, c1 - 1, c2 + 1, true))
				return good[r][c1] = good[r][c2] = true;
		
		if(!top && grid[r][c1] == '\\' && grid[r][c2] == '/')
			if(c1 + 1 == c2 || go(r + 1, c1 + 1, c2 - 1, false))
				return good[r][c1] = good[r][c2] = true;
		return false;
	}
}