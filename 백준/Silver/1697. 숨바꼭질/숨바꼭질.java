import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<Integer> queue = new LinkedList<>();
    public static int n, k;
    public static int[] visit, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new int[100001];
        result = new int[100001];

        visit[n] = 1;
        bfs(n);

        System.out.println(result[k]);
    }

    public static void bfs(int x) {
        queue.add(x);
        while (queue.size() != 0) {
            int now = queue.poll();
            if(now+1<=100000) {
                if (visit[now + 1] == 0) {
                    queue.add(now + 1);
                    result[now + 1] = result[now] + 1;
                    visit[now + 1] = 1;
                }
            }
            if(now-1>=0) {
                if (visit[now - 1] == 0) {
                    queue.add(now - 1);
                    result[now - 1] = result[now] + 1;
                    visit[now - 1] = 1;
                }
            }
            if (now * 2 <= 100000) {
                if (visit[now * 2] == 0) {
                    queue.add(now * 2);
                    result[now * 2] = result[now] + 1;
                    visit[now * 2] = 1;
                }
            }
        }
    }
}
