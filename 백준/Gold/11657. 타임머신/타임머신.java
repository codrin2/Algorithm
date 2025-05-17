import java.io.*;
import java.util.*;

class Edge {
    int start, end, cost;
    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] dis = new long[N+1]; // 1~N번 도시
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, cost));
        }
        Arrays.fill(dis, INF);
        dis[1] = 0;


        // 벨만포드
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if(dis[edge.start] != INF && dis[edge.end] > dis[edge.start] + edge.cost) {
                    dis[edge.end] = dis[edge.start] + edge.cost;
                }
            }
        }

        // 음수 사이클
        for (Edge edge : edges) {
            if(dis[edge.start] != INF && dis[edge.end] > dis[edge.start] + edge.cost) {
                System.out.println(-1);
                return;
            }
        }

        for(int i = 2; i < N+1; i++) {
            if (dis[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dis[i]);
            }
        }
    }
}