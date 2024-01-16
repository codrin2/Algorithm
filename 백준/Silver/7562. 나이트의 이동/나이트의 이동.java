import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<int[]> queue;
    public static int cnt,length;
    public static int[][] visit;
    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for(int i =0;i<test;i++) {
            queue = new LinkedList<int[]>();
            length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            visit = new int[length][length];
            visit[x1][y1] = 1;
            bfs(x1,y1,x2,y2);
            sb.append(visit[x2][y2]-1).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x1, int y1, int x2, int y2) {
        queue.add(new int[] {x1,y1});
        while (queue.size() != 0) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY= nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < length && nextY < length) {
                    if (visit[nextX][nextY] == 0) {
                        visit[nextX][nextY] = visit[nowX][nowY]+1;
                        if(nextX==x2&&nextY==y2) return;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}