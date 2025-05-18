import java.io.*;
import java.util.*;

public class Main {
    static int nowA, nowC, nowG, nowT;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String word = br.readLine();
        String[] words = word.split("");

        st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int cCnt = Integer.parseInt(st.nextToken());
        int gCnt = Integer.parseInt(st.nextToken());
        int tCnt = Integer.parseInt(st.nextToken());

        // 초기 세팅
        nowA = 0;
        nowC = 0;
        nowG = 0;
        nowT = 0;
        int res = 0;
        for (int i = 0; i < P; i++) {
            add(words[i]);
        }

        if(nowA >= aCnt && nowC >= cCnt && nowG >= gCnt && nowT >= tCnt) {
            res++;
        }

        // 슬라이딩 윈도우
        for (int i = 1; i < S-P+1; i++) {
            remove(words[i-1]);
            add(words[i+P-1]);
            if(nowA >= aCnt && nowC >= cCnt && nowG >= gCnt && nowT >= tCnt) {
                res++;
            }
        }

        System.out.println(res);
    }

    static void add(String word) {
        switch (word) {
            case "A":
                nowA++;
                break;
            case "C":
                nowC++;
                break;
            case "G":
                nowG++;
                break;
            case "T":
                nowT++;
                break;
        }
    }

    static void remove(String word) {
        switch (word) {
            case "A":
                nowA--;
                break;
            case "C":
                nowC--;
                break;
            case "G":
                nowG--;
                break;
            case "T":
                nowT--;
                break;
        }
    }
}