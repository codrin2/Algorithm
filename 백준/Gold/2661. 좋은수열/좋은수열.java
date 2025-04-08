import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recur(0);
    }

    static void recur(int depth) {
        if (depth == N) {
            System.out.println(result.toString());
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            result.append(i);
            if (check(depth+1)) {
                recur(depth + 1);
            }
            result.deleteCharAt(result.length() - 1);
        }
    }

    static boolean check(int depth) {
        for (int i = 1; i <= depth / 2; i++) {
            String back = result.substring(result.length() - i, result.length());
            String front = result.substring(result.length() - i * 2, result.length() - i);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}