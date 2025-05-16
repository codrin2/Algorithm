import java.util.*;

class Solution {
    static List<List<Integer>> l = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int verCnt = edge.length;
        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n + 1; i++) {
            l.add(new ArrayList<>());
        }
        
        // 간선 세팅
        for(int i=0;i<verCnt;i++){
            l.get(edge[i][0]).add(edge[i][1]);
            l.get(edge[i][1]).add(edge[i][0]);
        }
        
        // BFS
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            List<Integer> nextList = l.get(now);
            for(Integer next : nextList){
                if(visited[next]) continue;
                visited[next] = true;
                cost[next] = cost[now] + 1;
                q.add(next);
            }
        }
        
        int max = 0;
        for(int i=1;i<n+1;i++){
            if(max < cost[i]){
                answer = 1;
                max = cost[i];
            }else if(max == cost[i]){
                answer++;
            }
        }
        
        return answer;
    }
}