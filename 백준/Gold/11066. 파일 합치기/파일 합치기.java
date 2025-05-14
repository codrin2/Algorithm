import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int l=0;l<T;l++){
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] file = new int[K+1];
            int[] prefixSum = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            for (int i=1;i<K+1;i++){
                file[i] = Integer.parseInt(st.nextToken());
            }
            // 누적합 구하기
            for (int i = 1; i < K + 1; i++) {
                prefixSum[i] = prefixSum[i-1] + file[i];
            }
            // 점화식 dp[i][j] -> i부터 j까지 파일합병 최소 비용
            // bottom up 방식
            for(int len =2;len<=K;len++){
                for(int i=1;i<=K-len+1;i++){
                    int j = i+len-1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int cost = dp[i][k] + dp[k+1][j] + prefixSum[j]-prefixSum[i-1];
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}
