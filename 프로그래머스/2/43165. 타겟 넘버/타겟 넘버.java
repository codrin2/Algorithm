class Solution {
    static int cnt;

    public int solution(int[] numbers, int target) {

        dfs(0, 0, numbers, target);
        
        return cnt;
    }

    static public void dfs(int depth, int now, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (target == now) {
                cnt++;
            }
            return;
        }
        int nowNum = numbers[depth];

        dfs(depth + 1, now + nowNum, numbers, target);
        dfs(depth + 1, now - nowNum, numbers, target);
    }
}