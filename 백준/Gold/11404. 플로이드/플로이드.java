import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, INF = Integer.MAX_VALUE;
    public static long[][] dis;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dis = new long[n + 1][n + 1];
        StringTokenizer st;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dis[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int wt = Integer.parseInt(st.nextToken());
            if (dis[start][des] != INF) {
                dis[start][des] = Math.min(dis[start][des], wt);
            }else dis[start][des] = wt;
        }
        for (int i = 1; i < n + 1; i++) {
            dis[i][i] = 0;
        }

        Floyd();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dis[i][j] != INF) {
                    sb.append(dis[i][j]).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void Floyd() {
        for (int i = 1; i < n + 1; i++) {
            for (int x = 1; x < n + 1; x++) {
                for (int y = 1; y < n + 1; y++) {
                    if (dis[x][y] > dis[x][i] + dis[i][y]) {
                        dis[x][y] = dis[x][i] + dis[i][y];
                    }
                }

            }
        }
    }
}