import java.io.*;
import java.util.*;

public class Main {
	static int N, M, x, y, d;
	static int[][] map;
	static int count=0;
	static int[] dx = {-1, 0, 1, 0};//북, 동, 남, 서
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean();
		System.out.println(count);
	}
	static void clean() {
		while (true) {
			if (map[x][y] == 0) {
				map[x][y] = 2;
				count++;
			}
			boolean canClean = false;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 0) {
						canClean = true;
						break;
					}
				}
			}
			if (!canClean) {
				int backDir = (d + 2) % 4;
				int nx = x + dx[backDir];
				int ny = y + dy[backDir];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1) {
					x = nx;
					y = ny;
				} else {
					break;
				}
			} else {
				d = (d + 3) % 4;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
			}
		}
	}
}