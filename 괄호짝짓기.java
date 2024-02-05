package swea_d4;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test=1; test<11;test++) {
			Stack<Character> st = new Stack<>();
			int N = sc.nextInt();
			String s= sc.next();
			boolean result = true;
			for(int i=0;i<N;i++) {
				if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('|| s.charAt(i)=='<')
					st.push(s.charAt(i));
				else if(s.charAt(i)=='}'&&st.peek()=='{')
					st.pop();
				else if(s.charAt(i)==']'&&st.peek()=='[')
					st.pop();
				else if(s.charAt(i)==')'&&st.peek()=='(')
					st.pop();
				else if(s.charAt(i)=='>'&&st.peek()=='<')
					st.pop();
				else {
					result = false;
					break;
				}
			}
			if(result) {
				System.out.println("#"+test+" "+1);
			}
			else
				System.out.println("#"+test+" "+0);
		}
	}
}
