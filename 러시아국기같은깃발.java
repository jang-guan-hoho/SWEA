import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {
	static int search(char color,char[][] flag,int start, int end) {
		int cnt=0;
		for(int r=start;r<end;r++) {
			for(int c=0;c<flag[1].length;c++) {
				if(flag[r][c]!=color) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] flag = new char[N][M];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				String s= st.nextToken();
				for(int c=0;c<M;c++) {
					flag[r][c]= s.charAt(c);
				}
			}
			int min = Integer.MAX_VALUE;
			for(int w=0;w<=N-3;w++) {
				int sum =0;
				for(int r=N-1;r>=w+2;r--) {
					sum=search('W',flag,0,w+1)+search('B',flag,w+1,r)+search('R',flag,r,N);
					if(min > sum) {
						min = sum;
				}
				}
			}
			System.out.println("#"+t+" "+min);
//			for(int r=0;r<N;r++) {
//				System.out.println();
//				for(int c=0;c<M;c++) {
//					System.out.print(flag[r][c]+" ");
//				}
//			}
			
		}
	}
}
