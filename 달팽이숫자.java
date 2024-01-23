package swea_d2;

import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int N=sc.nextInt();
			int[][]arr=new int[N][N];
			int r=0,c=0,cnt=0;
			int l=0;
			while(cnt<N*N-1) {
				for(;c<N-1-l;c++) {
					arr[r][c]=++cnt;
				}
				for(;r<N-1-l;r++) {
					arr[r][c]=++cnt;
				}
				for(;c>0+l;c--) {
					arr[r][c]=++cnt;
				}
				for(;r>0+l;r--) {
					arr[r][c]=++cnt;
				}
				l++;
				c=r=l;
			}
			if(arr[N/2][N/2]==0)
				arr[N/2][N/2]=++cnt;
			System.out.print("#"+(1+t));
			for(int i=0;i<N;i++) {
				System.out.println();
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
