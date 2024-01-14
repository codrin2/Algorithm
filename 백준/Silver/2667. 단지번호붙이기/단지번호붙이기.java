import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int[][] arr, visit;
    public static int cnt, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new int[n][n];
        int[] result = new int[n*n];
        int resultCnt = 0;

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            int j =0;
            for (String s : temp.split("")) {
                arr[i][j++] = Integer.parseInt(s);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    if (visit[i][j] == 0) {
                        cnt=1;
                        visit[i][j] = 1;
                        find(i, j);
                        result[resultCnt++] = cnt;
                    }
                }
            }
        }
        int[] real = new int[resultCnt];
        for (int i = 0; i < resultCnt; i++) {
            real[i] = result[i];
        }
        Arrays.sort(real);
        sb.append(resultCnt).append("\n");
        for (int i = 0; i < resultCnt; i++) {
            sb.append(real[i]).append("\n");
        }
        
        System.out.println(sb);

    }

    public static void find(int x, int y) {
        if (x < n-1) {
            if (arr[x+1][y] == 1 && visit[x + 1][y] == 0) {
                cnt++;
                visit[x+1][y] =1;
                find(x+1, y);
            }
        }

        if (y < n - 1) {
            if (arr[x][y+1] == 1 && visit[x][y + 1] == 0) {
                cnt++;
                visit[x][y+1] =1;
                find(x, y+1);
            }
        }

        if (x > 0) {
            if (arr[x-1][y] == 1 && visit[x - 1][y] == 0) {
                cnt++;
                visit[x-1][y] =1;
                find(x-1, y);
            }
        }

        if (y > 0) {
            if (arr[x][y-1] == 1 && visit[x][y - 1] == 0) {
                cnt++;
                visit[x][y-1] =1;
                find(x, y-1);
            }
        }
    }
}