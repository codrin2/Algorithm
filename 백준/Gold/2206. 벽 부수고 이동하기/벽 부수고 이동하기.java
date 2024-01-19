import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Queue<int[]> queue = new LinkedList<>();
    ;
    public static int[][] arr;
    public static int[][][] visit;
    public static int column, row;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        arr = new int[column][row];
        visit = new int[column][row][2];

        for (int i = 0; i < column; i++) {
            String temp = br.readLine();
            for (int j=0;j<row;j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        queue.add(new int[]{0, 0, 0});
        visit[0][0][0]=1;
        bfs();

        if (visit[column - 1][row - 1][0] == 0 && visit[column - 1][row - 1][1] == 0) {
            System.out.println(-1);
        } else if (visit[column - 1][row - 1][0] == 0) {
            System.out.println(visit[column - 1][row - 1][1] );
        } else if (visit[column - 1][row - 1][1] == 0) {
            System.out.println(visit[column - 1][row - 1][0] );
        } else {
            System.out.println(Math.min(visit[column - 1][row - 1][0] , visit[column - 1][row - 1][1]));
        }

    }

    public static void bfs() {
        while (queue.size() != 0) {
            int[] temp = queue.poll();
            int nowX = temp[0];
            int nowY = temp[1];
            int flag = temp[2];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < column && nextY < row) {
                    if (visit[nextX][nextY][flag] == 0) {
                        if (arr[nextX][nextY] == 1 && flag == 0) {
                            visit[nextX][nextY][1] = visit[nowX][nowY][flag] + 1;
                            if (nextX == column - 1 && nextY == row - 1) return;
                            queue.add(new int[]{nextX, nextY, 1});
                        } else if (arr[nextX][nextY] == 0) {
                            visit[nextX][nextY][flag] = visit[nowX][nowY][flag] + 1;
                            if (nextX == column - 1 && nextY == row - 1) return;
                            queue.add(new int[]{nextX, nextY, flag});
                        }
                    }
                }
            }
        }
    }
}