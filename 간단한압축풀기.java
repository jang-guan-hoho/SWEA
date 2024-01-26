import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 간단한압축풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=0;t<T;t++) {
			List<String> list = new ArrayList<>();
			int N= sc.nextInt();
			int cnt =1;
			for(int num=0;num<N;num++) {
				String c = sc.next();
				int tgt = sc.nextInt();
				for(int i=0;i<tgt;i++)
					list.add(c);
			}
			for(int i=0;i<list.size();i++) {
				if(i==10*cnt) {
					list.set(i, "\n"+list.get(i));
					cnt++;
				}
			}
			System.out.println("#"+(t+1));
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}
}
