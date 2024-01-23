package swea_d2;

import java.util.Scanner;

public class 패턴마다의길이 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0; t<T;t++)
	{
		String text = sc.next();
		int i = 1;
		String st1;
		String st2;
		do {
			st1 = text.substring(0, i);
			st2 = text.substring((i+1),2*i+1);
			i++;
		}while(!st1.equals(st2));
			System.out.println("#"+(t+1)+" "+i);
	}
}
}
