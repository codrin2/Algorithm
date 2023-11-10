import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n,max=-1;
    public static int[][] arr;
    public static int[][] sum;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        sum = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j]=-1;
            }
        }

        sum[0][0] = arr[0][0];

        for (int i = 0; i < n; i++) {
            if (ms(n - 1, i) > max) {
                max = ms(n - 1, i);
            }
        }
        System.out.println(max);

    }

    public static int ms(int a, int i) {
        if (sum[a][i] != -1) {
            return sum[a][i];
        }

        if (i == 0) {
            sum[a][i] = ms(a-1,i)+arr[a][i];
        } else if (a == i) {
            sum[a][i] = ms(a - 1, i - 1)+arr[a][i];
        } else {
            sum[a][i] = Math.max(ms(a-1,i-1),ms(a-1,i))+arr[a][i];
        }
        return sum[a][i];
    }
}