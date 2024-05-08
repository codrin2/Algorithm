import java.io.*;
import java.util.*;
class Node{
    int nodeN;
    int cnt;
    public Node(int nodeN, int cnt){
        this.nodeN = nodeN;
        this.cnt = cnt;
    }
}
public class Main {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean[] visited;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0;i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,1));
        }
        BFS(X);
        Collections.sort(arr);
        if(arr.size()==0){
            System.out.println(-1);
        }else{
            for(int i=0;i<arr.size();i++){
                System.out.println(arr.get(i));
            }
        }


    }
    public static void BFS(int start){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        visited[start] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            int nowCity = now.nodeN;
            int nowCnt = now.cnt;
            if(nowCnt == K){
                arr.add(nowCity);
            }else if(nowCnt > K) {
                return ;
            }

            for(int i=0;i<graph.get(nowCity).size();i++){
                Node next = graph.get(nowCity).get(i);
                int nextCity = next.nodeN;
                if(visited[nextCity])continue;
                visited[nextCity] = true;
                q.add(new Node(nextCity, nowCnt +1));
            }
        }
    }

}