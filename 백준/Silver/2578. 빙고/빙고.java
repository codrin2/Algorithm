import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] arr = new int[5][5];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                int num = Integer.parseInt(st.nextToken());
                bingo(num);
                if (check() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    public static void bingo(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == n) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    public static int check() {
        int cnt = 0;
        int row;
        int col;
        int xy = 0;
        int yx = 0;
        int index = 0;
        for (int i = 0; i < 5; i++) {
            row = 0;
            col = 0;
            for (int j = 0; j < 5; j++) {
                row += arr[i][j];
                col += arr[j][i];
                if (i == j) {
                    xy += arr[i][j];
                }
                if (i == index && j == 4 - index) {
                    yx += arr[i][j];
                    index++;
                }
            }
            if (row == -5) {
                cnt++;
            }
            if (col == -5) {
                cnt++;
            }
            if (xy == -5) {
                cnt++;
            }
            if (yx == -5) {
                cnt++;
            }
        }
        return cnt;

    }
}