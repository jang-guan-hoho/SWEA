import java.util.Scanner;

public class 단조 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int [] num=new int[N];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					int a = num[i]*num[j];
					if(check(a)) {
						if(max<a)
							max=a;
					}
				}
			}
			if(max>0) {
				System.out.println("#"+t+" "+max);
			}else
				System.out.println("#"+t+" "+-1);
		}
	}
	static boolean check(int num) {
		String s = String.valueOf(num);
		for(int i=0;i<s.length()-1;i++) {
			if(Character.getNumericValue(s.charAt(i))>Character.getNumericValue(s.charAt(i+1))) {
				return false;
			}
		}
		return true;
	}
}
