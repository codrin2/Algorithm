import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Integer>> event = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();;
    public static int[] visit = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 101; i++) {
            event.add(new ArrayList<>());
        }

        for (int i=0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            event.get(start).add(finish);
        }
        queue.add(1);
        bfs();

        System.out.println(visit[100]);
    }

    public static int ladderOrSnake(int x) {
        if (event.get(x).size()==1) {
            return event.get(x).get(0);
        }
        return x;
    }

    public static void bfs() {
        while (queue.size() != 0) {
            int now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int next = ladderOrSnake(now + i + 1);
                if (next<=100) {
                    if (visit[next]==0) {
                        visit[next] = visit[now]+1;
                        if(next==100)return;
                        queue.add(next);
                    }
                }
            }
        }
    }
}