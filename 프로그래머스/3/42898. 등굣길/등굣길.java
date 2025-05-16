class Solution {
    static int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        // puddle 세팅
        int puddleCnt = puddles.length;
        for(int i=0;i<puddleCnt;i++){
            int x = puddles[i][1];
            int y = puddles[i][0];
            dp[x-1][y-1] = -1;
        }
        
        // 가로 줄 세팅
        boolean isPuddle = false;
        for(int i=0;i<m;i++){
            if(dp[0][i] == -1){
                isPuddle = true;
            }
            if(isPuddle){
                dp[0][i] = -1;
            }else{
                dp[0][i] = 1;
            }
        }
        
        // 세로 줄 세팅
        isPuddle = false;
        for(int i=0;i<n;i++){
            if(dp[i][0] == -1){
                isPuddle = true;
            }
            if(isPuddle){
                dp[i][0] = -1;
            }else{
                dp[i][0] = 1;
            }
        }
        
        // 점화식
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j] == -1) continue;
                
                if(dp[i-1][j] != -1){
                    dp[i][j] += dp[i-1][j]% MOD;
                }
                
                if(dp[i][j-1] != -1){
                    dp[i][j] += dp[i][j-1]% MOD;
                }
            }
        }
        
        int answer = dp[n-1][m-1] % MOD;
        return answer;
    }
}