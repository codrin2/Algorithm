import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static int N,M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(maxResult);
    }
    static void DFS(int count) {
        if (count == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    DFS(count+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void BFS() {
        int[][] tempArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            tempArr[i] = arr[i].clone();
        }

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempArr[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY <M && tempArr[nextX][nextY] == 0) {
                    tempArr[nextX][nextY] = 2;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }
        findSafe(tempArr);
    }

    static void findSafe(int[][] tempArr) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempArr[i][j] == 0) {
                    count++;
                }
            }
        }
        maxResult = Math.max(maxResult, count);
    }
}