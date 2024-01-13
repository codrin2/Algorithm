import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int cnt = 0;
    public static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visit = new int[node + 1];

        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        findVirus(1);

        System.out.println(cnt-1);

    }

    public static void findVirus(int start) {
        cnt++;
        visit[start] =1;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (visit[next] == 0) {
                findVirus(next);
            }
        }
    }
}