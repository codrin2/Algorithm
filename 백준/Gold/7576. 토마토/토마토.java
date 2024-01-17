import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<int[]> queue = new LinkedList<int[]>();;
    public static int no1=0, result=Integer.MIN_VALUE, column, row;
    public static int[][] tomato, visit;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        tomato = new int[column][row];
        visit = new int[column][row];

        for(int i =0;i<column;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visit[i][j]=1;
                }
            }
        }
        bfs();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (tomato[i][j] == 0) {
                    no1=1;
                }
                result = Math.max(result, visit[i][j]);
            }
        }

        if (no1 == 1) {
            System.out.println(-1);
        } else {
            System.out.println(result-1);
        }
    }

    public static void bfs() {
        if (queue.size() == 0) {
            no1 =1;
            return;
        }
        while (queue.size() != 0) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY= nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < column && nextY < row) {
                    if (visit[nextX][nextY] == 0 && tomato[nextX][nextY] == 0) {
                        visit[nextX][nextY] = visit[nowX][nowY] + 1;
                        tomato[nextX][nextY] = 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}