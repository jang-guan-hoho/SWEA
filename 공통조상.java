import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	
	Node(){}
	Node(int data){
		this.data =data;
	}
}
public class 공통조상 {
	static List<Integer> list; // generic의 타입으로는 클래스,참조형만 가능.
	static List<Integer> list2;
	static int i=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int test=1; test<=n;test++) {
			list = new ArrayList<>();
			list2 = new ArrayList<>();
			int idx =0;
			st = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			Node[] nodes = new Node[l+1];
			for(int i=1;i<l+1;i++) {
				nodes[i] = new Node();
				nodes[i].data = i;
			}
			i=0;
			nodes[1].data=1;
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<e;i++) {
				int a=Integer.parseInt(st.nextToken()); // 부모
				int b=Integer.parseInt(st.nextToken()); // 자식
				if(nodes[a].left != null)
					nodes[a].right= nodes[b];
				else
					nodes[a].left=nodes[b];
				nodes[b].parent=nodes[a];
			}
			preorder(nodes[1],first,list);
			
			
			
			Integer[] arr = list.toArray(new Integer[list.size()]);
			preorder(nodes[1],second, list2);
			Integer[] arr2 = list2.toArray(new Integer[list2.size()]);
			
			for(int i=arr.length-1;i>=0;i--) {
				for(int j=arr2.length-1;j>=0;j--) {
					if(arr[i].equals(arr2[j])) {
						idx=arr2[j];
					}
				}
			}
			count(nodes[idx]);
			System.out.print("#"+test+" "+nodes[idx].data+" "+i);
			System.out.println();
		}
		
	}
	static void preorder(Node node,int tgt, List<Integer> list) {
		if(node == null) {
			return;
		}
		
		if(node.data==tgt) {
			find(node, list);
			return;
		}
		preorder(node.left,tgt,list);
		preorder(node.right,tgt,list);
	}
	static void find(Node node,List<Integer> list) {
		if(node.parent==null)return;
		list.add(node.parent.data);
		find(node.parent,list);
	}
	static void count(Node node) {
		if(node == null) {
			return ;
		}
		i++;
		count(node.left);
		count(node.right);
	}
}
