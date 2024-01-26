package swea_d3;

import java.util.Scanner;

public class 조별과제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			System.out.println("#"+(t+1)+" "+n/3);
		}
	}
}
