import java.util.Scanner;

public class 중간평균값구하기 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t=0; t<T;t++) {
		int[] num = new int[10];
		int max= Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		float sum=0;
		for(int i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
		}
		for(int x : num) {
			sum+=x;
			if(max<x)
				max=x;
			if(min>x)
				min=x;
		}
		sum-= (max+min);
		System.out.printf("#%d %.0f",(t+1),sum/8);
		System.out.println();
	}
}

}
