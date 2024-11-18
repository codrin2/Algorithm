import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[14];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int startMoney = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int joonMoney = joon(startMoney);
		int sungMoney = sung(startMoney);

		if (joonMoney > sungMoney) {
			System.out.println("BNP");
		} else if (joonMoney < sungMoney) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}

	static int joon(int money) {
		int nowMoney = money;
		int cnt = 0;
		for (int i = 0; i < 14; i++) {
			if (nowMoney >= arr[i]) {
				int buyCnt = nowMoney / arr[i];
				cnt = cnt + buyCnt;
				nowMoney = nowMoney - (arr[i] * buyCnt);
			}
		}
		return nowMoney + cnt * arr[13];
	}

	static int sung(int money) {
		int nowMoney = money;
		int cnt = 0;
		int flag = 0;
		for (int i = 1; i < 14; i++) {
			if (arr[i - 1] < arr[i]) {
				if (flag < 0) {
					flag = 0;
				}
				flag++;
				if (flag >= 3) {
					nowMoney = nowMoney + arr[i] * cnt;
					cnt = 0;
				}
			} else if (arr[i - 1] > arr[i]) {
				if (flag > 0) {
					flag = 0;
				}
				flag--;
				if (flag <= -3) {
					int buyCnt = nowMoney / arr[i];
					cnt = cnt + buyCnt;
					nowMoney = nowMoney - arr[i] * buyCnt;
				}
			} else {
				if (flag >= 3) {
					nowMoney = nowMoney + arr[i] * cnt;
					cnt = 0;
				}
				if (flag <= -3) {
					int buyCnt = nowMoney / arr[i];
					cnt = cnt + buyCnt;
					nowMoney = nowMoney - arr[i] * buyCnt;
				}
			}
		}
		return nowMoney + cnt * arr[13];
	}
}