import java.io.*;
import java.util.*;

public class Main {
	static char[][] map = new char[12][6];
	static boolean[][] visit;
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int popCnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		while (true) {
			boolean isPop = false;
			visit = new boolean[12][6];

			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !visit[i][j]) {
						if (bfs(i, j)) {
							isPop = true;
						}
					}
				}

			}
			if (isPop) {
				down();
				popCnt++;
			} else {
				break;
			}
		}
		System.out.println(popCnt);
	}

	static boolean bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> pop = new LinkedList<>();
		visit[x][y] = true;
		queue.add(new Point(x, y));
		pop.add(new Point(x, y));
		char color = map[x][y];

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6) {
					if (!visit[nx][ny] && map[nx][ny] == color) {
						visit[nx][ny] = true;
						queue.add(new Point(nx, ny));
						pop.add(new Point(nx, ny));
					}
				}
			}
		}

		// 4개 도달 시 터트림
		if (pop.size() >= 4) {
			for (Point p : pop) {
				map[p.x][p.y] = '.';
			}
			return true;
		} else {
			return false;
		}

	}

	static void down() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] == '.') {
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}

	}


}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}