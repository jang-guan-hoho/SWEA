import java.util.Scanner;
class queue{
	private int[] queue = new int [8];
	private int front = 0, rear = 0;
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public boolean isFull() {
		return (rear + 1)% queue.length == front;
	}
	
	public void add(int num) {
		queue[rear]=num;
		rear++;
		rear %= queue.length;
	}
	
	public int poll() {
		int tmp =queue[front];
		front++;
		front%=queue.length;
		return tmp;
	}
	public int peek() {
			int a=front;
			return queue[a%=queue.length];
	}
	
	
}

public class 암호생성기_원형큐_구현 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test=1; test<11;test++) {
			queue q = new queue();
			int t = sc.nextInt();
			for(int i=0;i<8;i++) {
				q.add(sc.nextInt());
			}
			int cnt = 1;
			while(q.peek()>cnt) {
				int a = q.poll()-cnt;
				cnt++;
				q.add(a);
				if(cnt>5)
					cnt=1;
			}
			q.poll();
			q.add(0);
			System.out.print("#"+test+" ");
			for(int i =0;i<8;i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}
