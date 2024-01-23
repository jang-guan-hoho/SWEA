package swea_d2;

import java.util.Scanner;

public class 가랏RC카 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=1;t<=T;t++) {
		int N = sc.nextInt();
		int ans =0;
		int speed =0;
		for(int i=0;i<N;i++) {
			int command=sc.nextInt();
			if(command ==1) {
				speed+=sc.nextInt();
			}
			else if(command==2) {
				speed-=sc.nextInt();
				if(speed<=0)
					speed=0;
			}
			ans+=speed;
		}
		System.out.println("#"+(t)+" "+ans);
	}
}
}
