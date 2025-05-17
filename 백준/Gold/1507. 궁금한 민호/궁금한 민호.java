import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 0부터 N-1까지
        int[][] dp = new int[N][N];

        // 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j] == dp[i][k] + dp[k][j]로 대체가 가능하다면
        // dp[i][j]는 필요없는 간선이므로 제거

        boolean[][] remove = new boolean[N][N];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i == k || j == k) continue;

                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        System.out.println(-1);
                        return;
                    }

                    if (dp[i][j] == dp[i][k] + dp[k][j]) {
                        remove[i][j] = true;
                    }
                }
            }
        }

        // 총합 계산
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || remove[i][j]) continue;
                result += dp[i][j];
            }
        }
        System.out.println(result / 2);
    }
}
