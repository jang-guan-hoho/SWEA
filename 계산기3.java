import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
 
public class 계산기3 { 
    public static String change(int n,String s) {
        Map<Character, Integer> value = new HashMap<>();
        value.put('+', 1);
        value.put('*', 2);
        value.put('(', 0);
        Stack<Character> arr = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(') { // 스탯밖에 (은 제일 높은 우선순위!
            	arr.push(c);
            }else if(c==')') {
            	while(arr.peek()!='(') {
            		ans+=arr.pop();
            	}
            	arr.pop();
            }else if(c >= '0'&&c<='9') { // 숫자면 그대로 출력
                ans+=c;
            }else { // 연산자라면.
            if(!arr.isEmpty()) { // 스택이 비어있지 않다면.
                    // 현재 c보다 크거나 같으면 출력한다.
                    // 현재 c보다 작다면 c를 그 위에 push한다.
                while(!arr.isEmpty()&&value.get(c)<=value.get(arr.peek())) {
                    ans+=arr.pop();
                }
                arr.push(c);
                }else // 스택이 비어있다면.
                arr.push(c);
            }
        }
         
        while(!arr.isEmpty())
            ans+=arr.pop();
     
        return ans;
    }
    public static long cal(String s) {
        Stack<Long> arr= new Stack<>();
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if(c >= '0'&&c<='9') {
                long j=Character.getNumericValue(c);
                arr.push(j);
            }else if(c=='+') {
                long ans = arr.pop()+arr.pop();
                arr.push(ans);
            }else {
                long ans = arr.pop()*arr.pop();
                arr.push(ans);
            }
        }
        return arr.pop();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        for(int t=1;t<11;t++) {
            int n=sc.nextInt();
            String s = sc.next();
            String ans = change(n,s);
            long result = cal(ans);
            System.out.println("#"+t+" "+result);
        }
    }
}

