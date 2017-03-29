import java.util.Scanner;

public class shift {
	public static void main(String[] args) {
		final String SPECIAL = "~!@#$%^&*()_+{}|:\"<>?";
		Scanner scan = new Scanner(System.in);
		int runs = scan.nextInt(); scan.nextLine();
		for(int z = 1; z <= runs; z++) {
			char[] ch = scan.nextLine().toCharArray();
			int ans = 0;
			boolean prevShift = false;
			for(int i = 0; i < ch.length; i++) {
				if(Character.isUpperCase(ch[i]) || SPECIAL.indexOf(ch[i]) >= 0) {
					if(!prevShift)
						ans++;
					prevShift = true;
				} else {
					prevShift = false;
				}
			}
			
			System.out.printf("The shift key was pressed %d times.\n", ans);
		}
		scan.close();
	}
}