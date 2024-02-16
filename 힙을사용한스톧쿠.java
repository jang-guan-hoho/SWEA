import java.util.Scanner;

public class 힙을사용한스톧쿠 {
	static int[] heap;
	static int heapSize;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=1 ; t<=T;t++) {
			heap = new int [10];
			heapSize=0;
			boolean result = true;
			int [][] puz = new int[9][9];
			for(int r=0;r<9;r++) {
				for(int c=0;c<9;c++) {
					puz[r][c] = sc.nextInt();
				}
			}
			for(int r=0;r<9;r++) {
				for(int c=0;c<9;c++) {
					Push(puz[r][c]);
				}
				if(!check())
					result=false;
			}
			for(int c=0;c<9;c++) {
				for(int r=0;r<9;r++) {
					Push(puz[r][c]);
				}
				if(!check()) {
					result=false;
				}
			}
			for(int r=0;r<9;r=r+3) {
				for(int c=0;c<9;c=c+3) {
					for(int i=r;i<r+3;i++) {
						for(int j=c;j<c+3;j++) {
							Push(puz[i][j]);
						}
					}
					if(!check()) {
						result=false;
					}
				}
			}
			if(result) {
				System.out.println("#"+t+" "+1);
			}
			else
				System.out.println("#"+t+" "+0);
		}
	}
	static void Push(int data) {
		heap[++heapSize]=data;
		int ch = heapSize;
		int p = heapSize/2;
		while(p>0&&heap[ch]>heap[p]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			ch = p;
			p = ch/2;
		}
	}
	
	static int Pop() {
		int item = heap[1];
		heap[1]=heap[heapSize--];
		
		int p = 1;
		int ch =2;
		if(ch+1<=heapSize&& heap[ch]<heap[ch+1]) {
			ch++;
		}
		while(ch <= heapSize && heap[p]<heap[ch]) {
			int tmp = heap[p];
			heap[p]=heap[ch];
			heap[ch]=tmp;
			
			p=ch;
			ch= p*2;
			if(ch+1<=heapSize&& heap[ch]<heap[ch+1]) {
				ch++;
			}
			
		}
		return item;
	}
	static boolean check() {
		int[] ans = {9,8,7,6,5,4,3,2,1};
		int[] cmp = new int[9];
		boolean flag=true;
		for(int i=0;i<9;i++) {
			cmp[i] = Pop();
		}
		heapSize=0;
		for(int i=0;i<9;i++) {
			if(ans[i]!=cmp[i])
				flag=false;
		}
		return flag;
	}
}
