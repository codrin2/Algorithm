import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        int size1 = word1.length;
        int size2 = word2.length;

        dp = new int[size2 + 1][size1 + 1];

        for (int i = 1; i <= size2; i++) {
            for (int j = 1; j <= size1; j++) {
                if (word1[j - 1] == word2[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        ToString(word2, size1, size2);
        System.out.println(dp[size2][size1]);
        System.out.println(sb);


    }

    static void ToString(char[] str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while (i > 0 && j > 0) {
            if (dp[j][i] == dp[j - 1][i]) {
                j--;
            } else if (dp[j][i] == dp[j][i - 1]) {
                i--;
            } else {
                st.push(str[j - 1]);
                i--;
                j--;
            }

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}