import java.util.Arrays;
import java.util.Scanner;

public class 힙을사용한농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T;t++) {
			int N = sc.nextInt();
			sc.nextLine();
			int[][] map = new int[N][N];
			int ans=0;
			for(int r=0;r<N/2;r++) {
				String s = sc.nextLine();
				for(int c=N/2-r;c<=N/2+r;c++) {
					map[r][c] = Character.getNumericValue(s.charAt(c));
				}
			}
			for(int i=0, r=N/2;r<N;r++,i++) {
				String s = sc.nextLine();
				for(int c=i;c<N-i;c++) {
					map[r][c] = Character.getNumericValue(s.charAt(c));
				}
			}
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					ans+=map[r][c];
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
