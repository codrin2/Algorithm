import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int des;
    int wt;

    public Edge(int des, int wt) {
        this.des = des;
        this.wt = wt;
    }
}

public class Main {
    public static int n, m, INF=Integer.MAX_VALUE;
    public static long[] dis;
    public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dis[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(source).add(new Edge(destination, weight));
        }

        if (bellmanpord()) {
            sb.append(-1);
        } else {
            for (int i = 2; i < n + 1; i++) {
                if (dis[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dis[i]).append("\n");
                }
            }
        }

        System.out.println(sb);



    }

    public static boolean bellmanpord() {
        dis[1] = 0;
        boolean update = false;

        for (int i = 1; i < n; i++) {
            update = false;
            for (int j = 1; j <= n; j++) {
                for (Edge temp : graph.get(j)) {
                    if (dis[j]!=INF&&dis[temp.des]>dis[j]+temp.wt) {
                        dis[temp.des] = dis[j] + temp.wt;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        for (int j = 1; j <= n; j++) {
            for (Edge temp : graph.get(j)) {
                if (dis[j]!=INF&&dis[temp.des]>dis[j]+temp.wt) {
                    dis[temp.des] = dis[j] + temp.wt;
                    return true;
                }
            }
        }
        return false;
    }
}