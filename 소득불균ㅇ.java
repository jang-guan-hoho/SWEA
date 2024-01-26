package swea_d3;

import java.util.Scanner;

public class 소득불균ㅇ {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=0;t<T;t++) {
			int n =sc.nextInt();
			int[] num=new int[n];
			float ans=0;
			int cnt=0;
			for(int i=0;i<n;i++) {
				num[i]=sc.nextInt();
				ans+=num[i];
			}
			ans=ans/n;
			for(double x: num) {
				if((double)x<=ans)
					cnt++;
			}
			System.out.print("#"+(t+1)+" "+cnt);
			System.out.println();
		}
	}
}
