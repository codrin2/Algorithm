import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static HashSet<String> h;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        h = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            h.add(now);
        }

        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (h.contains(check)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}