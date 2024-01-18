package swea_d2;

import java.util.Scanner;

public class 새로운_불면증_치료 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int[] num = new int[10];
			boolean goal = false;
			int i = 1;
			int n = sc.nextInt();
			while(goal==false) {
				int sheep = i*n;
				do {
					num[sheep%10]++;
					sheep=sheep/10;
				}while(sheep>0);
				if(num[0]!=0&&num[1]!=0&&num[2]!=0&&num[3]!=0&&num[4]!=0&&num[5]!=0&&
						num[6]!=0&&num[7]!=0&&num[8]!=0&&num[9]!=0){
				goal=true;
			}
				else {
					i++;
				}
		}
			System.out.println("#"+t+" "+i*n);
	}

}
}
