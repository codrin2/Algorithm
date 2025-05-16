import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        int viewerCnt = times.length;
        long left = 1;
        Arrays.sort(times);
        long right = (long) times[viewerCnt -1] * n;
        long answer = 0;
        while(left <= right){
            long mid = (left + right)/2;
            long total = 0;
            for(int time : times){
                total += mid/time;
            }
            
            if(total < n){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}