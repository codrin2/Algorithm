import java.util.*;

class Solution {
    private Map<String, Integer> m;
    
    public int solution(String[][] clothes) {
        m = new HashMap<>();
        int answer = 1;
        
        // 세팅
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String kind = cloth[1];
            if(m.containsKey(kind)){
                int now = m.get(kind);
                m.put(kind, now + 1);
            }else {
                m.put(kind, 1);
            }
        }
        
        // 계산
        // 안입기 추가
        int size = m.size();
        for(int v : m.values()) {
            answer = answer * (v + 1);
        }
        
        return answer - 1;
    }
}