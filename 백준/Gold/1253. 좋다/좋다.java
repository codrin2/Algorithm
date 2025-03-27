import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            long sum;
            while (left < right) {
                sum = arr[left] + arr[right];
                if (arr[i] == sum && i!= left && i!= right) {
                    cnt++;
                    break;
                } else if (arr[i] < sum) {
                    right--;
                } else if (arr[i] > sum) {
                    left++;
                } else {
                    if(i==right && arr[right] == arr[right-1]) {
                        right--;
                    } else if (i == left && arr[left] == arr[left + 1]) {
                        left++;
                    } else {
                        right--;
                        left++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}