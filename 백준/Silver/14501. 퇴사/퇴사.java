import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalDay = Integer.parseInt(br.readLine());
		int[] t = new int[totalDay];
		int[] p = new int[totalDay];
		int[] dp = new int[totalDay+1];
		StringTokenizer st;
		for (int i = 0; i < totalDay; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < totalDay; i++) {
			if (i + t[i] < totalDay + 1) {
				dp[i + t[i]] = Math.max(dp[i] + p[i], dp[i + t[i]]);
				for (int j = i + t[i]+ 1; j < totalDay + 1; j++) {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
			}
		}
		System.out.println(dp[totalDay]);
	}
}