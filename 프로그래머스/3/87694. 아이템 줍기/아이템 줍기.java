import java.util.*;


class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 2;
                }
            }
        }

        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private int bfs(int[][] map, int sx, int sy, int ex, int ey) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];

        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 목표 지점 도착
            if (x == ex && y == ey) {
                return dist / 2;  // 2배 확대했으니 다시 나누기
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;

                // 방문 체크
                if (visited[nx][ny]) continue;

                // 테두리(1)만 이동 가능
                if (map[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

        return 0;
    }
}