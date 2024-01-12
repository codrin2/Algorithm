import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visit;
    public static int cnt = 1;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visit = new int[node + 1];

        for (int i = 0; i < node+1; i++) {
            graph.add(new ArrayList <Integer>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (int i = 1; i < node+1; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(start);

        for (int i = 1; i < node+1; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int node) {
        queue.add(node);
        visit[node] = cnt++;
        while (queue.size() != 0) {
            int now = queue.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nowNode = graph.get(now).get(i);
                if (visit[nowNode] == 0) {
                    queue.add(nowNode);
                    visit[nowNode] = cnt++;
                }
            }
        }
    }

}