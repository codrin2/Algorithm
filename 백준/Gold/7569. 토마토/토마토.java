import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<int[]> queue = new LinkedList<int[]>();;
    public static int no1=0, result=Integer.MIN_VALUE, column, row, height;
    public static int[][][] tomato, visit;
    public static int[] hx = {0, 0, 0, 0, 1, -1};
    public static int[] dx = {0, 1, 0, -1, 0, 0};
    public static int[] dy = {1, 0, -1, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        tomato = new int[height][column][row];
        visit = new int[height][column][row];


        for(int h =0;h<height;h++) {
            for (int i = 0; i < column; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < row; j++) {
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                        visit[h][i][j] = 1;
                    }
                }
            }
        }
        bfs();

        for (int h = 0; h < height; h++) {
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (tomato[h][i][j] == 0) {
                        no1 = 1;
                    }
                    result = Math.max(result, visit[h][i][j]);
                }
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
            int nowH = now[0];
            int nowX = now[1];
            int nowY = now[2];
            for (int i = 0; i < 6; i++) {
                int nextH = nowH + hx[i];
                int nextX = nowX + dx[i];
                int nextY= nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextH >= 0 && nextX < column && nextY < row && nextH < height) {
                    if (visit[nextH][nextX][nextY] == 0 && tomato[nextH][nextX][nextY] == 0) {
                        visit[nextH][nextX][nextY] = visit[nowH][nowX][nowY] + 1;
                        tomato[nextH][nextX][nextY] = 1;
                        queue.add(new int[]{nextH, nextX, nextY});
                    }
                }
            }
        }
    }
}