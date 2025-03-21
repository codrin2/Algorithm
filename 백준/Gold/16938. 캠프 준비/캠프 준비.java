import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] problem;
    static int[] check;
    static int N, L, R, X;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        problem = new int[N];
        check = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(problem);

        for (int i = 2; i <= N; i++) {
            choose(-1,0, i);
        }

        System.out.println(result);
    }
    static void choose(int last, int nowCount, int maxCount) {
        if(nowCount == maxCount){
            check();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(i > last && check[i] == 0){
                check[i] = 1;
                choose(i,nowCount + 1, maxCount);
                check[i] = 0;
            }
        }
    }

    static void check() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(check[i] == 1){
                min = Math.min(min, problem[i]);
                max = Math.max(max, problem[i]);
                count = count + problem[i];
            }
        }
        if(max - min >= X && count >= L && count <= R){
            result++;
        }
    }
}