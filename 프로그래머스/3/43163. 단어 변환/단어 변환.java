import java.util.*;

class Node {
    String now;
    int cnt = 0;
    public Node(String a, int b) {
        now = a;
        cnt = b;
    }
}

class Solution {
    static HashSet<String> h = new HashSet<>();
    static HashSet<String> v = new HashSet<>();

    public int solution(String begin, String target, String[] words) {
        for (String word : words) {
            h.add(word);
        }

        if (!h.contains(target)) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            String now = n.now;
            int cnt = n.cnt;

            if (now.equals(target)) {
                return cnt;
            }

            for (int i = 0; i < now.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String next = now.substring(0, i) + c + now.substring(i + 1);
                    if (h.contains(next) && !v.contains(next)) {
                        q.add(new Node(next, cnt + 1));
                        v.add(next);
                    }
                }
            }
        }

        return 0;
    }
}