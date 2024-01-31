import java.util.Scanner;

public class ladder1 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int start_c=0;
			int start_r=99;
			int[] dc = {-1,1,0};
			int[] dr = {0,0,-1};
			int T = sc.nextInt();
			int[][] arr = new int[100][102];
			for(int r=0;r<100;r++) {
				for(int c=1;c<101;c++) {
					arr[r][c]=sc.nextInt();
					if(arr[r][c] ==2)
						start_c=c;
				}
			}
			while(start_r>0) {
			for(int i=0;i<3;i++) {
				int nr=start_r+dr[i];
				int nc=start_c+dc[i];
				if(arr[nr][nc]==1) {
					arr[start_r][start_c]=0;
					start_r=nr;
					start_c=nc;
				}
			}}
			System.out.println("#"+T+" "+(start_c-1)+" ");
		}
	}
}
