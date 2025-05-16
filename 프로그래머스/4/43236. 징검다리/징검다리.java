import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int answer = 0;
        
        while(left<=right){
            int mid = (left + right)/2;
            if(check(mid, rocks, n, distance)){
                answer = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return answer;
    }
    static boolean check(int mid, int[] rocks, int n, int distance) {
        int prev = 0;
        int removed = 0;
        for(int rock : rocks){
            if(rock - prev < mid){
                removed++;
            } else {
                prev = rock;
            }
        }
        if(distance - prev < mid){
            removed++;
        }
        
        
        if(removed <= n){
            return true;
        }else{
            return false;
        }
    }
}