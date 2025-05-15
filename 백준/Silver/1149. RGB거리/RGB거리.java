import java.io.*;
import java.util.*;

public class Main {
    static int houseCnt;
    static int[][] cost;
    static int[][] dp;
    static Integer INF = 1000001;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        houseCnt = Integer.parseInt(br.readLine());
        cost = new int[houseCnt+1][4];
        dp = new int[houseCnt+1][4];

        for(int i=1;i<houseCnt+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1;j<4;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<houseCnt+1;i++){
            Arrays.fill(dp[i], INF);
        }

        // 점화식
        // dp[i][1~3] -> i번째 집이 1~3 색깔일때 최솟값
        for(int i=1;i<4;i++){
            dp[1][i] = cost[1][i];
        }
        
        for(int i=2;i<houseCnt+1;i++){
            for(int j=1;j<4;j++){
                int color = j+1;
                if(color > 3){
                    color = color%4 + 1;
                }
                int a = dp[i-1][color] + cost[i][j];
                color++;
                if(color > 3){
                    color = color%4 + 1;
                }
                int b = dp[i-1][color] + cost[i][j];
                int temp = Math.min(a,b);
                dp[i][j] = Math.min(dp[i][j],temp);
            }
        }
        
        // 출력
        int temp = Math.min(dp[houseCnt][1],dp[houseCnt][2]);
        int result = Math.min(temp, dp[houseCnt][3]);
        System.out.println(result);
    }
}
