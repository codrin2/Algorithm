import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int val;
    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}

class Edge {
    int to, weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int cityCnt, busCnt;
    static int[] dis;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCnt = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());
        dis = new int[cityCnt + 1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < cityCnt+1; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < busCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dis[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dis[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dis[now.idx] < now.val) continue;
            List<Edge> edges = graph.get(now.idx);
            for(Edge edge : edges){
                int cost = edge.weight;
                if(dis[now.idx] + cost < dis[edge.to]){
                    dis[edge.to] = Math.min(dis[edge.to], dis[now.idx] + cost);
                    pq.add(new Node(edge.to, dis[edge.to]));
                }
            }
        }
    }
}
