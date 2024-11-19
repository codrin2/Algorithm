import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] wheel = new int[5][9];
	static int[][] doing;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 5; i++) {
			String input = br.readLine();
			String[] numbers = input.split("");
			int cnt = 1;
			for (String number : numbers) {
				wheel[i][cnt] = Integer.parseInt(number);
				cnt++;
			}
		}
		N = Integer.parseInt(br.readLine());
		doing = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			doing[i][0] = Integer.parseInt(st.nextToken());
			doing[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			int wheelNum = doing[i][0];
			int direct = doing[i][1];
			rotate(wheelNum, direct);
		}
		int result =0;
		if(wheel[1][1]==1) result +=1;
		if(wheel[2][1]==1) result +=2;
		if(wheel[3][1]==1) result +=4;
		if(wheel[4][1]==1) result +=8;
		System.out.println(result);
	}

	static void rotate(int wheelNum, int direct) {
		if (wheelNum == 1) {
			if (wheel[wheelNum][3] != wheel[wheelNum + 1][7]) {
				if (wheel[wheelNum + 1][3] != wheel[wheelNum + 2][7]) {
					if (wheel[wheelNum + 2][3] != wheel[wheelNum + 3][7]) {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum + 2, direct);
						moving(wheelNum + 3, direct * (-1));
					} else {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum + 2, direct);
					}
				} else {
					moving(wheelNum, direct);
					moving(wheelNum + 1, direct * (-1));
				}
			} else {
				moving(wheelNum, direct);
			}
		} else if (wheelNum == 2) {
			if (wheel[wheelNum-1][3] == wheel[wheelNum][7]) {
				if (wheel[wheelNum][3] != wheel[wheelNum + 1][7]) {
					if (wheel[wheelNum + 1][3] != wheel[wheelNum + 2][7]) {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum + 2, direct);
					} else {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
					}
				} else {
					moving(wheelNum, direct);
				}
			} else {
				if (wheel[wheelNum][3] != wheel[wheelNum + 1][7]) {
					if (wheel[wheelNum + 1][3] != wheel[wheelNum + 2][7]) {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum + 2, direct);
					} else {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum + 1, direct * (-1));
					}
				} else {
					moving(wheelNum, direct);
					moving(wheelNum - 1, direct * (-1));
				}
			}
		}else if (wheelNum == 3) {
			if (wheel[wheelNum][3] == wheel[wheelNum + 1][7]) {
				if (wheel[wheelNum - 1][3] != wheel[wheelNum][7]) {
					if (wheel[wheelNum - 2][3] != wheel[wheelNum - 1][7]) {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum - 2, direct);
					} else {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
					}
				} else {
					moving(wheelNum, direct);
				}
			} else {
				if (wheel[wheelNum - 1][3] != wheel[wheelNum][7]) {
					if (wheel[wheelNum - 2][3] != wheel[wheelNum - 1][7]) {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum - 2, direct);
					} else {
						moving(wheelNum, direct);
						moving(wheelNum + 1, direct * (-1));
						moving(wheelNum - 1, direct * (-1));
					}
				} else {
					moving(wheelNum, direct);
					moving(wheelNum + 1, direct * (-1));
				}
			}
		}else if (wheelNum == 4) {
			if (wheel[wheelNum-1][3] != wheel[wheelNum][7]) {
				if (wheel[wheelNum -2][3] != wheel[wheelNum -1][7]) {
					if (wheel[wheelNum -3][3] != wheel[wheelNum -2][7]) {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum - 2, direct);
						moving(wheelNum - 3, direct * (-1));
					} else {
						moving(wheelNum, direct);
						moving(wheelNum - 1, direct * (-1));
						moving(wheelNum - 2, direct);
					}
				} else {
					moving(wheelNum, direct);
					moving(wheelNum - 1, direct * (-1));
				}
			} else {
				moving(wheelNum, direct);
			}
		}
	}

	static void moving(int wheelNum, int direct) {
		int[] cmp = new int[9];
		for (int i = 1; i < 9; i++) {
			cmp[i] = wheel[wheelNum][i];
		}

		for (int i = 1; i < 9; i++) {
			if (i + (-1) * direct == 0) {
				wheel[wheelNum][i] = cmp[8];
			} else if (i + (-1) * direct == 9) {
				wheel[wheelNum][i] = cmp[1];
			} else {
				wheel[wheelNum][i] = cmp[i+ (-1)*direct];
			}
		}
	}
}