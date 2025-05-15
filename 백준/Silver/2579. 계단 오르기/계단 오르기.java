import java.io.*;
import java.util.*;

public class Main {
    static int stair;
    static int[] scores;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stair = Integer.parseInt(br.readLine());
        scores = new int[stair+1];
        dp = new int[stair+1][3];
        
        for(int i=1;i<stair+1;i++){
            scores[i] = Integer.parseInt(br.readLine());
        }

        // 점화식
        dp[1][1] = scores[1];
        dp[1][0] = Math.max(dp[1][1], dp[1][2]);
        for(int i=2;i<stair+1;i++){
            dp[i][1] = dp[i-2][0] + scores[i];
            dp[i][2] = dp[i-1][1] + scores[i];
            dp[i][0] = Math.max(dp[i][1], dp[i][2]);
        }

        // 출력 -> 총 점수의 최댓값
        System.out.println(dp[stair][0]);
    }
}
