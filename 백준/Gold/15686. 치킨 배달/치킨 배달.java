import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
	static int M;
	static int[][] city;
	static int min = Integer.MAX_VALUE;
	static boolean[] open;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		person = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					person.add(new Point(i, j));
				} else if (city[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		open = new boolean[chicken.size()];
		dfs(0,0);

		System.out.println(min);
	}

	static void dfs(int start, int cnt) {
		int cityMin = 0;
		if (cnt == M) {
			for (int i = 0; i < person.size(); i++) {
				int distance;
				int personMin = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						distance = Math.abs(person.get(i).x - chicken.get(j).x)+
							Math.abs(person.get(i).y - chicken.get(j).y);
						personMin = Math.min(personMin, distance);
					}
				}

				cityMin += personMin;
			}
			min = Math.min(min, cityMin);
		}
		for (int i = start; i < chicken.size(); i++) {
			open[i] = true;
			dfs(i + 1, cnt + 1);
			open[i] = false;
		}
	}
}