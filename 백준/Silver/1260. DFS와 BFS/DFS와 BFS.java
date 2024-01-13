import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int cnt1 = 0;
    public static int cnt2 = 0;
    public static int[] visitDFS, visitBFS;
    public static int[] resultDFS, resultBFS;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visitDFS = new int[node + 1];
        visitBFS = new int[node + 1];
        resultDFS = new int[node];
        resultBFS = new int[node];

        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        for (int i = 1; i < node + 1; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(start);
        BFS(start);

        for (int i = 0; i < cnt1; i++) {
            sb1.append(resultDFS[i]).append(" ");
        }
        for (int i = 0; i < cnt2; i++) {
            sb2.append(resultBFS[i]).append(" ");
        }

        System.out.println(sb1);
        System.out.println(sb2);

    }

    public static void DFS(int start) {
        visitDFS[start] =1;
        resultDFS[cnt1++] = start;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (visitDFS[next] == 0) {
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        visitBFS[start] =1;
        queue.add(start);
        while (queue.size() != 0) {
            int now = queue.poll();
            resultBFS[cnt2++] = now;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (visitBFS[next] == 0) {
                    queue.add(next);
                    visitBFS[next] = 1;
                }
            }

        }
    }
}