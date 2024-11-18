import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] number;
	static int[] operator;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		number = new int[N];
		operator = new int[4];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		cal(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	static void cal(int now, int depth) {
		if (depth == N) {
			max = Math.max(max, now);
			min = Math.min(min, now);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				if (i == 0) {
					operator[0]--;
					cal(now + number[depth], depth + 1);
					operator[0]++;
				}
				if (i == 1) {
					operator[1]--;
					cal(now - number[depth], depth + 1);
					operator[1]++;
				}
				if (i == 2) {
					operator[2]--;
					cal(now * number[depth], depth + 1);
					operator[2]++;
				}
				if (i == 3) {// todo: 나누기 음수 처리
					operator[3]--;
					cal(now / number[depth], depth + 1);
					operator[3]++;
				}
			}
		}
	}
}