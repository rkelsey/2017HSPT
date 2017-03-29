import java.util.Scanner;

public class ladders {
	public static int length, width, height;
	public static char[][][] grid;
	public static boolean[][][] visited;
	
	public static final int[] DR = {1, -1, 0, 0, 0, 0};
	public static final int[] DC = {0, 0, 1, -1, 0, 0};
	public static final int[] DZ = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			length = scan.nextInt();
			width = scan.nextInt();
			height = scan.nextInt();
			
			grid = new char[height][length][width];
			for(int i = 0; i < height; i++)
				for(int j = 0; j < length; j++)
					grid[i][j] = scan.next().toCharArray();
			
			int startz = -1, startr = -1, startc = -1;
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < length; j++) {
					for(int k = 0; k < width; k++) {
						if(grid[i][j][k] == 'S') {
							startz = i;
							startr = j;
							startc = k;
						}
					}
				}
			}
			
			visited = new boolean[height][length][width];
			visited[startz][startr][startc] = true;
			System.out.printf("Map #%d: %s\n", z, dfs(startz, startr, startc) ? "Yes" : "No");
		}
		scan.close();
	}
	
	public static boolean dfs(int z, int r, int c) {
		if(grid[z][r][c] == 'E')
			return true;
		
		if(grid[z][r][c] == '*' && z + 1 < height && grid[z + 1][r][c] == '*') {
			if(visited[z + 1][r][c])
				return false;
			visited[z + 1][r][c] = true;
			return dfs(z + 1, r, c);
		}
		
		int lim = grid[z][r][c] == '#' ? 6 : 4;
		for(int i = 0; i < lim; i++) {
			int ddz = z + DZ[i], ddr = r + DR[i], ddc = c + DC[i];
			if(!inBounds(ddz, ddr, ddc) || visited[ddz][ddr][ddc])
				continue;
			
			if(i >= 4 && grid[ddz][ddr][ddc] != '#')
				continue;
			
			visited[ddz][ddr][ddc] = true;
			if(dfs(ddz, ddr, ddc))
				return true;
		}
		return false;
	}
	
	public static boolean inBounds(int z, int r, int c) {
		return z >= 0 && z < height && r >= 0 && r < length && c >= 0 && c < width;
	}
}