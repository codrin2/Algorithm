import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] dp;
    static int N;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i]++;
            recur(2, i);
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % MOD;
        }
        System.out.println(result);
    }

    static void recur(int k, int now) {
        if(k==N+1)
            return;

        for(int i = 0; i < now + 1; i++) {
            dp[k][now] = (dp[k][now] + dp[k-1][i]) % MOD;
        }

        recur(k+1, now);
    }
}