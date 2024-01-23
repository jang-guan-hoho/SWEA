package swea_d2;

import java.util.Arrays;
import java.util.Scanner;

public class 두개의숫자열 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0; t<T;t++)
	{
		int ans = 0;
		int M=sc.nextInt();
		int N=sc.nextInt();
		int max=Math.max(M, N);
		int min=Math.min(M, N);
		int[] Ai = new int[min];
		int[] Bj = new int[max];
		if(min==M) {
			for(int i=0; i<min;i++)
			Ai[i] = sc.nextInt();
			for(int i=0; i<max;i++)
			Bj[i] = sc.nextInt();}
		else {
			for(int i=0; i<max;i++)
				Bj[i] = sc.nextInt();
			for(int i=0; i<min;i++)
				Ai[i] = sc.nextInt();
		}
		int[] mul = new int[max-min+1];
		for(int i =0; i<max-min+1;i++) {
			for(int j=0;j<min;j++) {
				mul[i]+=Ai[j]*Bj[j+i];
				}
			}
		for(int x:mul) {
			if(ans<x)
				ans=x;
		}
		System.out.println("#"+(t+1)+" "+ans);
	}
}
}
