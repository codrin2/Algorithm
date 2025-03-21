import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] student;
    static int[] index;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        student = new int[N][M];
        index = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(student[i]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;


        for(int i =0 ; i < N ; i++){
            int temp = student[i][index[i]];
            if (temp < min) {
                min = temp;
                minIndex = i;
            }
            if (temp > max) {
                max = temp;
                maxIndex = i;
            }
        }
        twoPointer(index[minIndex]++, maxIndex);
        System.out.println(minResult);
    }

    static void twoPointer(int minIndex, int maxIndex) {
        if (index[minIndex] >= M) {
            return;
        }

        int min = student[minIndex][index[minIndex]];
        int max = student[maxIndex][index[maxIndex]];
        int nowMinIndex = minIndex;
        int nowMaxIndex = maxIndex;

        for(int i =0 ; i < N ; i++){
            int temp = student[i][index[i]];
            if (temp < min) {
                min = temp;
                nowMinIndex = i;
            }
            if (temp > max) {
                max = temp;
                nowMaxIndex = i;
            }
        }
        minResult = Math.min(max - min, minResult);
        index[nowMinIndex]++;

        twoPointer(nowMinIndex, nowMaxIndex);
    }
}