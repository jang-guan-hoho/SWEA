import java.util.Scanner;

public class 준환이의운동관리 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T =sc.nextInt();
	for(int t=0;t<T;t++) {
		int[] hours = new int[3];
		int ans=0;
		for(int i=0;i<hours.length;i++)
			hours[i]=sc.nextInt();
		if(hours[0]>hours[2])
			ans= hours[0]-hours[2];
		else if(hours[1]<hours[2])
			ans=-1;
		System.out.println("#"+(t+1)+" "+ans);
	}
}
}
