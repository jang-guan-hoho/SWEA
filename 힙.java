import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 힙 {
	static long [] heap;
	static int heapSize;

	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int test=1;test<=T;test++) {
			StringBuilder sb =new StringBuilder();
			sb.append("#").append(test).append(" ");
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			heapSize=0;
			heap = new long[n+1];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				int key = Integer.parseInt(st.nextToken());
				if(key == 1) {
					heapPush(Integer.parseInt(st.nextToken()));
				}
				else {
						sb.append(heapPop()).append(" ");

				}
			}
			System.out.println(sb);
		}
	}
	static void heapPush(long data) {
		heap[++heapSize]=data;
		int ch=heapSize;
		int p = heapSize/2;
		if(ch+1<=heapSize && heap[ch]<heap[ch+1]) {
			ch++;
		}
		while(p>0&&heap[ch]>heap[p]) {
			long tmp = heap[ch];
			heap[ch]=heap[p];
			heap[p]=tmp;
			
			ch=p;
			p=ch/2;
		}
	}
	static long heapPop() {
		if(heapSize==0) {
			return -1;
		}
		long item=heap[1];
		
		int p=1;
		int ch=p*2;
		heap[1]=heap[heapSize--];
		if(ch+1<=heapSize && heap[ch]<heap[ch+1]) {
			ch++;
		}
		while(ch<=heapSize&&heap[p]<heap[ch]) {
			long tmp = heap[p];
			heap[p]=heap[ch];
			heap[ch]=tmp;
			
			p=ch;
			ch=p*2;
			if(ch+1<=heapSize && heap[ch]<heap[ch+1]) {
				ch++;
			}
		}
		return item;
	}
}
