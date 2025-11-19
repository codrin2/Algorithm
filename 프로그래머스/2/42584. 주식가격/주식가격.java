class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            for(int j = i + 1; j < prices.length; j++) {
                time++;  // 일단 무조건 1초 경과
                
                if(prices[i] > prices[j]) {  // 가격이 떨어졌으면
                    break;  // 더 이상 확인 안 함
                }
            }
            answer[i] = time;
        }
        
        return answer;
    }
}