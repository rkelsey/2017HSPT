import java.util.Scanner;

public class jump {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt();
		for(int z = 1; z <= runs; z++) {
			int x = scan.nextInt(), y = scan.nextInt(), n = scan.nextInt();
			int right = x, back = y, front = 0, left = 0;
			
			System.out.printf("Trip #%d:\n", z);
			for(int i = 0; i < n; i++) {
				char com = scan.next().charAt(0);
				switch(com) {
				case 'L':
					if(left == 0)
						x = Math.max(1, x - 1);
					else
						left--;
					break;
				case 'R':
					if(left + x == right)
						x = Math.max(1, x - 1);
					left++;
					break;
				case 'F':
					if(front == 0)
						y = Math.max(1, y - 1);
					else
						front--;
					break;
				case 'B':
					if(front + y == back)
						y = Math.max(1, y - 1);
					front++;
				}
				System.out.println(x * y);
			}
			System.out.println();
		}
		scan.close();
	}
}