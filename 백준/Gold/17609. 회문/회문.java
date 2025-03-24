import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            System.out.println(recur(arr[i], 0, arr[i].length() - 1, 0));
        }
    }

    static int recur(String temp, int front, int back, int count) {
        if (count > 1) return 2;

        while (front < back) {
            if (temp.charAt(front) == temp.charAt(back)) {
                front++;
                back--;
            } else {
                int a = recur(temp, front + 1, back, count + 1);
                int b = recur(temp, front, back - 1, count + 1);
                return Math.min(a, b);
            }
        }
        return count;
    }
}