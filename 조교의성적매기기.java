import java.util.Arrays;
import java.util.Scanner;

public class 조교의성적매기기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=0;t<T;t++) {
			int num = sc.nextInt();
			int tgt = sc.nextInt();
			int[][] score = new int[num][3];
			int[] ss=new int[num];
			String[] grade= {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			for(int r=0;r<num;r++) {
				for(int c=0;c<3;c++) {
					score[r][c] = sc.nextInt();
				}
			}
			for(int r=0;r<num;r++) {
				score[r][0]*=35;
				score[r][1]*=45;
				score[r][2]*=20;
				score[r][0]+=score[r][1]+score[r][2];
				score[r][1]=r+1;//학생 점수 별 번호매기기
				ss[r]=score[r][0];
			}
			Arrays.sort(ss);
			for(int r=0;r<num;r++) {
				for(int i=0;i<num;i++) {
					if(ss[r]==score[i][0])
						score[i][2]=num-r;//등수 매기기
				}
			}
			for(int r=0;r<num;r++) {
				for(int i=1;i<11;i++) {
				if(score[r][2]<=(num/10)*i&&score[r][0]>100)
					score[r][0]=i;
				}
			}
			for(int r=0;r<num;r++) {
				if(score[r][1]==tgt)
					System.out.println("#"+(t+1)+" "+grade[score[r][0]-1]);
		}
		}
	}
}
