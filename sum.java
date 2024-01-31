import java.util.Scanner;

public class sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			int[] sum = new int[202];
			int max = Integer.MIN_VALUE;
			for(int r=0;r<100;r++) {
				for(int c=0;c<100;c++) {
					arr[r][c]=sc.nextInt();
				}
			}
			for(int r=0;r<100;r++) {
				for(int c=0;c<100;c++) {
					sum[r]+=arr[r][c];
				}
			}
			for(int c=0;c<100;c++) {
				for(int r=0;r<100;r++) {
					sum[c+100]+=arr[r][c];
				}
			}
			for(int r=0;r<100;r++) {
				sum[200]+=arr[r][r];
			}
			for(int i=0;i<100;i++) {
				sum[201]+=arr[i][99-i];
			}
			for(int i:sum) {
				if(max<i)
					max=i;
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
