package swea_d2;

import java.util.Scanner;

public class 파스칼삼ㄱ가형{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int t=1;t<=T;t++) {
        int numRows = sc.nextInt();

        // 파스칼 삼각형 출력
        System.out.println("#"+t);
        printPascalTriangle(numRows);
    }
    }

    // 파스칼 삼각형 출력 함수
    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(binomialCoefficient(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }
    }
}

