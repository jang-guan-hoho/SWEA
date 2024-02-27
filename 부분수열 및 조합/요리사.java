
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 요리사 {
	static int N; // 식재료 갯수
	static int[][] map;
	static int[] idg;
	static int[] oidg;
	static int[] all_idg;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {

			N = sc.nextInt();
			map = new int[N][N];
			idg = new int[N / 2];
			oidg = new int[N / 2];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// 정보 받아오기
			idg_pick(0, 0);
			System.out.println("#"+test+" "+min);
			min=Integer.MAX_VALUE;
		}
	}

	static void idg_pick(int idx,int sidx) {
		if(sidx == (N/2)) {
			other_idg();
			if(min>favor()) {
				min=favor();
			}
			return;
		}
		
		for(int i=idx; i<=(N/2)+sidx;i++) {
			idg[sidx] = i;
			idg_pick(i+1,sidx+1);
		}
	}

	static int favor() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N / 2; j++) {
				sum1 += map[idg[i]][idg[j]] + map[idg[j]][idg[i]];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N / 2; j++) {
				sum2 += map[oidg[i]][oidg[j]] + map[oidg[j]][oidg[i]];
			}
		}
		return Math.abs(sum1-sum2);
	}

	static void other_idg() {
		all_idg = new int[N];
		for(int i=0;i<N;i++) {
			all_idg[i]=i;
		}
		int idx=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N/2;j++) {
				if(idg[j]==i)
					all_idg[i]=-1;
			}
		}
		for(int i=0;i<N;i++) {
			if(all_idg[i]!=-1)
				oidg[idx++]=all_idg[i];
		}
	}
}
