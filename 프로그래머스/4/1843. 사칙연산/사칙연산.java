class Solution {
    public int solution(String arr[]) {
        int size = arr.length;
        int numCnt = size/2 + 1;
        int opCnt = size/2; 
        int[] num = new int[numCnt];
        String[] op = new String[size/2];
        int[][][] dp = new int[numCnt][numCnt][2];
        
        // 숫자, 연산자 분리
        for(int i=0;i<size;i++){
            if(i%2==0){
                num[i/2] = Integer.parseInt(arr[i]);
            }else{
                op[i/2] = arr[i];
            }
        }
        
        // 결국 최댓값을 구해야한다
        // - 일 경우에는 max - min, + 일 경우에는 max + max 가 되어야 하다
        // 그럼 min을 만드려면? - 일 경우에는 min - max, + 일 경우에는 min + min 을 수행해야한다
        // 즉 계산 과정에서 min과 max 둘다 구해야한다
        
        // dp 설계는? dp[i][j] -> i 부터 j까지 최댓값
        // 0 min, 1 max
        
        // bottom up 으로 설계
        for(int i=0;i<numCnt;i++){
            dp[i][i][0] = num[i];
            dp[i][i][1] = num[i];
        }
        
        for (int len = 2; len <= numCnt; len++) {
    for (int i = 0; i <= numCnt - len; i++) {
        int j = i + len - 1;
        dp[i][j][0] = Integer.MAX_VALUE;
        dp[i][j][1] = Integer.MIN_VALUE;

        for (int k = i; k < j; k++) {
            String operator = op[k];

            int[] left = dp[i][k];
            int[] right = dp[k+1][j];

            for (int a : left) {
                for (int b : right) {
                    int result;
                    if (operator.equals("+")) result = a + b;
                    else result = a - b;

                    dp[i][j][0] = Math.min(dp[i][j][0], result);
                    dp[i][j][1] = Math.max(dp[i][j][1], result);
                }
            }
        }
    }
}
        
        // 출력
        int answer = dp[0][size/2][1];
        return answer;
    }
}