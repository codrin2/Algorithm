import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int j = 0;
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i =0; i < participant.length; i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i], 1);
            }else{
                map.replace(participant[i], map.get(participant[i]) + 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            if(map.get(completion[i]) == 1){
                map.remove(completion[i]);
            }else{
                map.replace(completion[i], map.get(completion[i]) - 1);
            }
        }
        
        Set<String> keys = map.keySet();
        for (String key : keys) {
            answer += key;
        }
        
        return answer;
    }
}