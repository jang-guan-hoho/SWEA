package swea_d2;

import java.util.Scanner;

public class 시각덧셈 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0;t<T;t++) {
		int[] hour = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] min = new int[60];
		int[] inHour = new int[2];
		int[] inMin = new int[2];
		int[] ans = new int[2];
		for(int i=0;i<2;i++) {
			inHour[i]=sc.nextInt();
			inMin[i]=sc.nextInt();
		}
		if(inMin[0]+inMin[1]<60)
			ans[1]=inMin[0]+inMin[1];
		else {
			ans[1]=inMin[0]+inMin[1]-60;
			ans[0]++;
		}
		
		if(inHour[0]+inHour[1]+ans[0]<13) {
			ans[0]+=inHour[0]+inHour[1];
		}
		else
			ans[0]+=inHour[0]+inHour[1]-12;
		System.out.println("#"+(t+1)+" "+ans[0]+" "+ans[1]);
	}
}
}
