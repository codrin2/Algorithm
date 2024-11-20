import java.io.*;
import java.util.*;

public class Main {
	static int x,y,N,M, cmdCnt;
	static int[][] map;
	static int[] cmd;
	static int[] dice = new int[7];
	static int[] dx = new int[]{0, 0, 0, -1, 1};
	static int[] dy = new int[]{0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		cmdCnt = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cmd = new int[cmdCnt];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cmdCnt; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < cmdCnt; i++) {
			int dir = cmd[i];
			int newX = x + dx[dir];
			int newY = y + dy[dir];
			// 지도를 벗어나면 안된다
			if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
				continue;
			}
			x = newX;
			y = newY;
			roll(dir);
			// 0이면 주사위 바닥면을 복사 (지도 <- 주사위)
			// 0이 아니면 주사위 바닥면에 복사 (지도 -> 주사위)
			if (map[newX][newY] == 0) {
				map[newX][newY] = dice[6];
			} else {
				dice[6] = map[newX][newY];
				map[newX][newY] = 0;
			}
		}
	}
	// 주사위 전개도는 고정으로 본다
	static void roll(int dir) {
		int tmp = dice[1];
		switch (dir) {
			case 1:
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = tmp;
				break;
			case 2:
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = tmp;
				break;
			case 3:
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = tmp;
				break;
			case 4:
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = tmp;
				break;
		}
		System.out.println(dice[1]);
	}
}