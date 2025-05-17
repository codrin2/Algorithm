class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dp = new int[n+1][n+1];
        
        for(int[] result : results){
            dp[result[0]][result[1]] = 1;
        }
        
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(dp[i][k] + dp[k][j] == 2){
                        dp[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            boolean check = true;
            for(int j=1;j<n+1;j++){
                if(i==j) continue;
                if(dp[i][j] == 0 && dp[j][i] == 0){
                    check = false;
                }
            }
            if(check) answer++;
        }
        
        return answer;
    }
}