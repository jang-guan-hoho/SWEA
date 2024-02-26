package 알고리즘공부;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class 단순2진암호코드 {
     
    static int [] [] num = {
            {0,0,0,1,1,0,1},
            {0,0,1,1,0,0,1},
            {0,0,1,0,0,1,1},
            {0,1,1,1,1,0,1},
            {0,1,0,0,0,1,1},
            {0,1,1,0,0,0,1},
            {0,1,0,1,1,1,1},
            {0,1,1,1,0,1,1},
            {0,1,1,0,1,1,1},
            {0,0,0,1,0,1,1}
    };// 암호문 저장
    static int [] idx = new int[2];
    static int [] check=new int [7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T;t++) {
            int[] ans = new int[8];
            boolean result = true;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int [][] film = new int [N][M];
            for(int r=0;r<N;r++) {
                String s = br.readLine();
                for(int c=0;c<M;c++) {
                    film[r][c] = Character.getNumericValue(s.charAt(c));
                }
            }// 영상 정보 저장
            end:
            for(int r=0;r<N;r++) {
                for(int c=M-1;c>=0;c--) {
                    if(film[r][c]==1) {
                        idx[0]=r;
                        idx[1]=c;
                        break end;
                    }
                }
            } // 유효한 암호문의 뒷자리가 전부 1로 끝나므로 뒤에서부터 탐색
            int index = 0;
            for(int i=idx[1]-55;i<=idx[1];i+=7) {
                for(int j=i;j<i+7;j++) {
                    check[j-i]=film[idx[0]][j];
                }
                for(int k=0;k<10;k++) {
                    for(int y=0;y<7;y++) {
                        if(num[k][y]==check[y]) {
                            result = true;
                        }else {
                            result = false;
                            break;
                        }
                    }
                    if(result) {
                        ans[index++]=k;
                    }
                }
            }
            int cnt=ans[1]+ans[3]+ans[5]+ans[7]+(ans[0]+ans[2]+ans[4]+ans[6])*3;
            cnt %=10;
            if(cnt == 0) {
                System.out.println("#"+t+" "+(ans[0]+ans[1]+ans[2]+ans[3]+ans[4]+ans[5]+ans[6]+ans[7]));
            }else
                System.out.println("#"+t+" "+0);
             
             
        }
    }
}