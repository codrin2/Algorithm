import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static long min = Long.MAX_VALUE;
    static int idx1, idx2, idx3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                    idx1 = i;
                    idx2 = left;
                    idx3 = right;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        long[] result = {arr[idx1], arr[idx2], arr[idx3]};
        Arrays.sort(result);
        System.out.println(arr[idx1] + " " + arr[idx2] + " " + arr[idx3]);
    }
}