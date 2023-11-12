import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (n == 1) {
            System.out.println(dp[1]);
        } else if (n == 2) {
            dp[2] = arr[1] + arr[2];
            System.out.println(dp[2]);
        } else {
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i < n+1; i++) {
                dp[i] = Math.max(dp[i-1],Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-2]+arr[i]));
            }

            System.out.println(dp[n]);

        }

    }

}