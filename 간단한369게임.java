package swea_d2;

import java.util.Arrays;
import java.util.Scanner;

public class 간단한369게임 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	String[] num = new String[N];
	int cnt=0;
	for(int i=1; i<=N;i++) {
		num[i-1]=Integer.toString(i);
	}
	String[] ans = Arrays.copyOf(num, N);
	for(int i=0;i<N;i++) {
		for(int j=0;j<num[i].length();j++) {
			char c = num[i].charAt(j);
			if(c=='3'||c=='6'||c=='9') {
				cnt++;
				ans[i]="-";
			}
		}
		if(ans[i].equals("-")) {
			for(int k=0;k<cnt-1;k++)
				ans[i]+="-";
			cnt=0;
		}
		else {
			ans[i]=num[i];
			cnt=0;
		}
	}
	for(int i=0;i<N;i++) {
		System.out.print(ans[i]+" ");
	}
}
}
