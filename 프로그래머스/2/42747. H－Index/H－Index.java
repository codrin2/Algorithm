import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = Arrays.stream(citations)
                              .boxed()
                              .toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());
        
        for(int i = 0; i < arr.length; i++){
            int h = i + 1;  // h 후보값 (지금까지 본 논문 수)
            
            // h편의 논문이 h회 이상 인용되었는가?
            if(arr[i] >= h){
                answer = h;  // 조건 만족, 계속 갱신
            } else {
                break;  // 조건 불만족, 더 이상 증가 불가
            }
        }
        
        return answer;
    }
}