package swea_d2;

import java.util.Scanner;

public class 백만장자프로젝트 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0; t<T;t++)
	{
		int ans=0;
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		int max =-1;
		int target=0;
		int tar=0;
		for(int i=0;i<num;i++) {
			if(max<arr[i]) {
				max=arr[i];
				target=i;
			}
		}
		while(max==0) {
			for(int i=tar;i<=target;i++) {
				ans+=(max-arr[i]);
				arr[i]=0;
			}
			max =-1;
		for(int i=0;i<num;i++) {
			if(max<arr[i]) {
				max=arr[i];
				tar=target;
				target=i;
			}
		}
		}
		System.out.println(target);
			System.out.println("#"+(t+1)+" "+ans);
	}
}
}
