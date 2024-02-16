import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			String s = bf.readLine();
			int cnt =0;
			Queue<Integer> num = new LinkedList<>();
			num.add(0);
			for(int i=0;i<s.length();i++) {
				num.add(Character.getNumericValue(s.charAt(i)));
			}
			int a= num.poll();
			int l= num.size();
			for(int i=0;i<l;i++) {
				int b=num.poll();
				if(a!=b) {
					cnt++;
					a=b;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
