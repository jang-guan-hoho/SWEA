package swea_d4;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기_스택사용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1; test<=T;test++) {
			String s = sc.next();
			Stack<Character> st = new Stack<>();
			int cnt=0;
			char c =' ';
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==')'&&st.peek()=='('&&c!=')') {
					st.pop();
					cnt+=st.size();
					c=s.charAt(i);
				}
				else if(s.charAt(i)==')') {
					st.pop();
					cnt++;
					c=s.charAt(i);
				}
				else {
					st.push(s.charAt(i));
					c=s.charAt(i);
				}
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
