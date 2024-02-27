import java.util.Arrays;
import java.util.Scanner;

public class 정렬 {
	static int N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
//		selectionSort();
//		insertionSort();
		bubbleSort();
		System.out.println(Arrays.toString(num));
	}

	static void selectionSort() {
		// 선택정렬
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (min >= num[j]) {
					min = num[j];
					idx = j;
				}
			}
			if (num[i] > num[idx])
				tmp(i, idx);
		}
	}

	 public static void insertionSort() {
		 // 삽입 정렬
	        for (int i = 1; i < num.length; i++) {
	            // 선택 데이터
	            int key = num[i];
	            //비교 데이터
	            int j = i - 1;

	            // 이전의 원소가 더 크다면 데이터는 하나씩 밀려난다.
	            while (j >= 0 && num[j] > key) {
	            	num[j + 1] = num[j];
	                j--;
	            }
	            num[j + 1] = key;
	        }
	    }
	 
	 public static void bubbleSort() {
		 // 버블 정렬
		 for(int i=1;i<N;i++) {
			 for(int j=1;j<N-i;j++) {
				 if(num[j-1]>num[j]) {
					 tmp(j, j-1);
				 }
			 }
		 }
	 }

	static void tmp(int idx1, int idx2) {
		int temp = 0;
		temp = num[idx1];
		num[idx1] = num[idx2];
		num[idx2] = temp;
	}
}
