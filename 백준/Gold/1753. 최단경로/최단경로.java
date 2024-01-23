import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList[] al;
    public static int[] dist;
    public static int v, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;

        al = new ArrayList[v];
        dist = new int[v];

        for (int i = 0; i < v; i++) {
            al[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            al[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v; i++) {
            if(dist[i]== Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (pq.size() != 0) {
            Node now = pq.poll();

            int len = al[now.v].size();
            for (int i = 0; i < len; i++) {
                Node next = (Node) al[now.v].get(i);

                if (dist[next.v] > now.w + next.w) {
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

}
class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n){
        return this.w - n.w;
    }
}