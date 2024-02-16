import java.util.Scanner;

public class 힙을사용한백만장자 {
	static long[] heap;
	static int heapSize=1;
	static long money=0;
	static long goods=0;
	static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1 ; test<=T;test++) {
			int n = sc.nextInt();
			heap = new long[3^(n+1)];
			int[] day = new int[n];
			for(int i=0;i<n;i++) {
				day[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++) {
				
			}
		}
	}
	static void heapPush(long data) {
		heap[++heapSize]=data;
		
		int ch = heapSize;
		int p = heapSize/3;
		
		while(p>0 && heap[ch]>heap[p]) {
			long tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			ch=p;
			p=ch/3;
		}
	}
	static long heapPop() {
		long item = heap[1];
		
		heap[1] = heap[heapSize--];
		
		int p = 1;
		int ch = p*3;
		if(ch+1<=heapSize && heap[ch]<heap[ch+1]) {
			ch++;
		}else if(ch+2<=heapSize && heap[ch+1]<heap[ch+2]) {
			ch+=2;
		}
		while(ch<=heapSize && heap[ch]>heap[p]) {
			long tmp=heap[ch];
			heap[ch]=heap[p];
			heap[p]=tmp;
			
			p=ch;
			ch=p*3;
		}
		return item;
	}
	static void buy(long price) {
		goods+=price;
		cnt++;
		money-=price;
		heapPush(money);
	}
	static void sell(long price) {
		goods=0;
		money+=(price-goods)*cnt;
		cnt=0;
		heapPush(money);
	}
}
