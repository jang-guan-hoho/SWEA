import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 사칙연산 {

	static int N;
	static int[][] tree;
	static String[] value;
	static Stack<Double> stack;
	
	public static void postOrder(int idx) {
		 
		if(idx!=0) {
			postOrder(tree[idx][0]);
			postOrder(tree[idx][1]);
			if(isOperator(value[idx])) { //노드 값이 연산자라면
				calculate(value[idx]); //연산 수행
			}
			else stack.push(Double.parseDouble(value[idx])); //연산자가 아니라면 stack에 push
		}
		
	}
	public static void calculate(String c) {
		
		double y = stack.pop();
		double x = stack.pop();
		if(c.equals("+")) {
			stack.push(x+y);
		}
		else if(c.equals("-")) {
			stack.push(x-y);
		}
		else if(c.equals("*")) {
			stack.push(x*y);
		}
		else if(c.equals("/")) {
			stack.push(x/y);
		}
	}
	private static boolean isOperator(String c) {
	       if (c.equals("+")|| c.equals("-") || c.equals("*") || c.equals("/"))
	    	   return true;
	       return false;
	 }
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input_cal3.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new int[N+1][2];
			value = new String[N+1]; //트리노드에 저장되는 값
			stack= new Stack<Double>();
			
			for(int i=1;i<=N;i++) {
				String[] tmp = br.readLine().split(" ");
				if(tmp.length==4) {
					int left = Integer.parseInt(tmp[2]);
					int right = Integer.parseInt(tmp[3]);
					tree[i][0]=left;
					tree[i][1]=right;
				}
				value[i]=tmp[1];
			
			}
			postOrder(1);
			int answer = Integer.parseInt(String.valueOf(Math.round(stack.pop()))); //결과값은 정수부만 출력
			System.out.println("#"+test_case+" "+answer);
	}
}
}