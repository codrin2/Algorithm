import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] profit;
    static int[][] dp;
    static int[][] path;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        profit = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        path = new int[M + 1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j=1;j<M+1;j++){
                profit[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        // dp[i][j] -> i : 금액, j : 회사, k : j-1까지 투자한 금액
        for(int i = 1; i <= M; i++){// 회사
            for(int cost = 1; cost <= N; cost++){// 총 금액
                for(int k = 0; k <= cost; k++){// j 회사에 투자할 금액
                    int val = dp[i-1][cost-k] + profit[i][k];
                    if (val > dp[i][cost]) {
                        dp[i][cost] = val;
                        path[i][cost] = k;
                    }
                }
            }
        }

        int cost = N;
        int company = M;
        while (company > 0) {
            int temp = path[company][cost];
            stack.push(temp);
            cost -= temp;
            company--;
        }

        System.out.println(dp[M][N]);
        for(int i = 1; i <= M; i++){
            System.out.print(stack.pop() + " ");
        }

    }
}