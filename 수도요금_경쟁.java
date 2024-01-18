package swea_d2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 수도요금_경쟁{
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P= Integer.parseInt(st.nextToken());
            int Q= Integer.parseInt(st.nextToken());
            int R= Integer.parseInt(st.nextToken());
            int S= Integer.parseInt(st.nextToken());
            int W= Integer.parseInt(st.nextToken());
            //1리터당 P원       
            //기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금, 초과량에 대해 1리터당 S원
            int ans =0;
            if(W<=R) {
                 ans= Math.min(Q, W*P);
            }else {
                ans = Math.min(W*P, Q+(W-R)*S);
            }
             
            System.out.println("#"+tc+" "+ans);
             
             
             
        }
         
    }
 
}