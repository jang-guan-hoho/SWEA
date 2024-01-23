package swea_d2;

import java.util.Scanner;

public class 날짜계산기 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
	for(int t=0;t<T;t++) {
		int month1=sc.nextInt();
		int day1=sc.nextInt();
		int month2=sc.nextInt();
		int day2=sc.nextInt();
		int ans=0;
		for(int i=month1-1;i<month2-1;i++)
			ans+=day[i];
		ans+=day2-day1+1;
		System.out.println("#"+(t+1)+" "+ans);
	}
}
}
