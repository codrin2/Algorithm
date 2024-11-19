import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Spin {
	int time;
	String dir;

	Spin(int x, String y) {
		this.time = x;
		this.dir = y;
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

public class Main {
	static int N;
	static int K;
	static int[][] map;

	// 북, 동, 남, 서 (0,1,2,3)
	static int[] dx = new int[]{0, 1, 0, -1};
	static int[] dy = new int[]{-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N+1][N+1];
		// 사과는 1
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		Queue<Spin> spin = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			spin.add(new Spin(time, dir));
		}
		Queue<Point> point = new LinkedList<>();
		point.add(new Point(1, 1));
		int time = 0;
		int dir = 1;
		int nowx = 1;
		int nowy = 1;
		map[nowx][nowy] = 2;

		while (true) {
			time++;
			int nx = nowx + dy[dir];
			int ny = nowy + dx[dir];
			if (nx < 1 || ny < 1 || nx > N || ny > N || map[nx][ny] == 2) {
				break;
			}
			if (map[nx][ny] == 0) {
				Point del = point.poll();
				map[del.x][del.y] = 0;
			}
			if(!spin.isEmpty()) {
				if (time == spin.peek().time) {
					if ((spin.peek().dir).equals("L")) {
						dir = (dir - 1) < 0 ? 3: (dir-1);
					}
					if ((spin.peek().dir).equals("D")) {
						dir = (dir + 1) > 3 ? 0: (dir+1);
					}
					spin.poll();
				}
			}
			map[nx][ny] = 2;
			point.add(new Point(nx, ny));
			nowx = nx;
			nowy = ny;
		}
		System.out.println(time);

	}
}