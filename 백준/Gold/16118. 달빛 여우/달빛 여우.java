import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int to;
    int weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cost;
    int boost; // 0: 이전에 부스터 안씀, 1: 이전에 부스터 씀

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public Node(int idx, int cost, int boost) {
        this.idx = idx;
        this.cost = cost;
        this.boost = boost;
    }

    public int compareTo(Node o) {
        return this.cost - o.cost; // cost 오름차순
    }
}

public class Main {
    static int tree;
    static int road;
    static List<List<Edge>> graph = new ArrayList<>();
    static int count = 0;
    static int[] foxDist;
    static int[][] wolfDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        foxDist = new int[tree + 1];
        wolfDist = new int[2][tree + 1]; // 두 상태별 저장

        for (int i = 0; i <= tree; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 오솔길의 weight에 2를 곱함 (여우, 늑대 비교를 위한 통일된 기준)
        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight * 2));
            graph.get(end).add(new Edge(start, weight * 2));
        }

        fox();
        wolf();

        // 각 노드마다 여우와 늑대(두 상태 중 최소값)를 비교
        for (int i = 2; i <= tree; i++) {
            int foxTime = foxDist[i];
            int wolfTime = Math.min(wolfDist[0][i], wolfDist[1][i]);
            if (foxTime < wolfTime) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void fox() {
        Arrays.fill(foxDist, Integer.MAX_VALUE);
        foxDist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (foxDist[now.idx] < now.cost) continue;
            for (Edge edge : graph.get(now.idx)) {
                int newDist = now.cost + edge.weight;
                if (newDist < foxDist[edge.to]) {
                    foxDist[edge.to] = newDist;
                    pq.add(new Node(edge.to, newDist));
                }
            }
        }
    }

    static void wolf() {
        // 2차원 배열 초기화
        for (int i = 0; i < 2; i++) {
            Arrays.fill(wolfDist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        wolfDist[0][1] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int curState = now.boost;
            if (wolfDist[curState][now.idx] < now.cost) continue;
            for (Edge edge : graph.get(now.idx)) {
                int nextState = 1 - curState; // 상태 전환 (빠름->느림, 느림->빠름)
                int newCost;
                if (curState == 0) { // 빠른 상태일 때: 이동 비용은 edge.weight/2
                    newCost = now.cost + edge.weight / 2;
                } else { // 느린 상태일 때: 이동 비용은 edge.weight*2
                    newCost = now.cost + edge.weight * 2;
                }
                if (newCost < wolfDist[nextState][edge.to]) {
                    wolfDist[nextState][edge.to] = newCost;
                    pq.add(new Node(edge.to, newCost, nextState));
                }
            }
        }
    }
}