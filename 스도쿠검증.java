import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 스도쿠검증 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=1;t<=T;t++) {
		int ans = 1;
		int[][] arr = new int[9][9];
		int[] cmp = {1,2,3,4,5,6,7,8,9};
		Set<Integer> cnt = new HashSet<>();
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		for(int r=0;r<9;r++) {
			cnt.clear();
			for(int c=0;c<9;c++) {
				cnt.add(arr[r][c]);
			}
			if(cnt.size()!=9)
				ans=0;
		}
		for(int c=0;c<9;c++) {
			cnt.clear();
			for(int r=0;r<9;r++) {
				cnt.add(arr[r][c]);
			}
			if(cnt.size()!=9)
				ans=0;
		}
		for(int r=0;r<9;r+=3) {
			for(int c=0;c<9;c+=3) {
				cnt.clear();
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						cnt.add(arr[r+i][c+j]);
					}
				}
				if(cnt.size()!=9)
					ans=0;
			}
		}
		System.out.println("#"+t+" "+ans);
	}
}
}
