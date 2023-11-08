import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int T;
    public static Long[] arr = new Long[101];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(pado(Integer.parseInt(br.readLine()))).append('\n');
        }

        System.out.println(sb);
    }

    public static Long pado(int n) {
        if (arr[n] != null) {
            return arr[n];
        }

        if (n == 0) {
            return arr[0]=0L;
        } else if (1 <= n && n <= 3) {
            return arr[n]=1L;
        } else if (n == 4) {
            return arr[n]=2L;
        }

        arr[n] = pado(n-1) + pado(n-5);
        return pado(n);
    }
}