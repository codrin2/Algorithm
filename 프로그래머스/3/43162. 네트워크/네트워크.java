class Solution {
    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(i, n, computers);
            answer++;
        }

        return answer;
    }

    static public void dfs(int i, int n ,int[][] computers) {
        int[] computer = computers[i];
        for(int j=0;j<n;j++){
            if (computer[j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(j, n, computers);
            }
        }
        
    
    }
}