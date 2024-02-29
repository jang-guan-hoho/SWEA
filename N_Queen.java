import java.io.*;
 
public class Solution {
    static int board[]; 
    static int answer;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num;
 
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(br.readLine());
            board = new int[num];
            answer = 0;
            countNQueenCase(num, 0);
            System.out.println("#" + i + " " + answer);
        }
    }
 
    public static void countNQueenCase(int n, int curr) {
        boolean isPossible;     
        if (curr == n) {        
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {        
            isPossible = true;
            for (int j = 0; j < curr; j++) {
                if (board[j] == i || i == board[j]+(curr - j) || i == board[j]-(curr - j)) {        //직선, 대각선 확인 
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                board[curr] = i;
                countNQueenCase(n, curr + 1);
            }
        }
    }
 
}
