import java.util.Scanner;

public class 최빈수구하기 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0; t<T;t++) {
		int num = sc.nextInt();
		int[] student = new int[1000];
		int[] score = new int[101];
		int max=Integer.MIN_VALUE;
		int ans =-1;
		for(int i=0;i<student.length;i++) {
			student[i]=sc.nextInt();
		}
		for(int i=0;i<student.length;i++) {
			score[student[i]]++;
		}
		for(int i=0;i<score.length;i++) {
			if(max<=score[i]) {
				max=score[i];
				ans=i;
			}
		}
		System.out.println("#"+num+" "+ans);
	}
}
}
