import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder answer = new StringBuilder();
        for(String s : str) {
            answer.append(s);
        }
        
        if(answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}