import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] dp;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1]=0;
        for (int i = 2; i < n + 1; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i-1],Math.min(dp[i/3],dp[i/2]))+1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[n]);

    }
}