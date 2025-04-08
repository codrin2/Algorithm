import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = (int) (Long.parseLong(br.readLine()) % 1500000);
        int pisano = 1500000;
        pi = new long[pisano+1];
        pi[0] = 0;
        pi[1] = 1;
        for(int i = 2; i <= pisano; i++) {
            pi[i] = (pi[i-1] + pi[i-2]) % 1000000;
        }
        System.out.println(pi[size]);
    }
}