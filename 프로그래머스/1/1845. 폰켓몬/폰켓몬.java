import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int temp, cnt = 1;
        int size = nums.length;
        Arrays.sort(nums);
        temp = nums[0];
        for(int i =1;i<size;i++){
            if(nums[i] != temp)
                cnt++;
            temp = nums[i];
        }
        if(cnt > (size/2)){
            answer = size/2;
        }else{
            answer = cnt;
        }
        return answer;
    }
}