package swea_d2;

import java.util.Scanner;

public class 회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans=1;
		for(int t=0; t<T;t++)
		{
			String text = sc.next();
			char[] arr = new char[text.length()];
			char[] arr2 = new char[text.length()];
			for(int i=0;i<text.length();i++) {
				arr[i]=text.charAt(i);
				arr2[text.length()-(i+1)]=text.charAt(i);
			}
			for(int i=0;i<text.length();i++) {
				if(arr[i]==arr2[i])
					ans=1;
				else
					ans=0;
			}
				System.out.println("#"+(t+1)+" "+ans);
		}
	}

}
