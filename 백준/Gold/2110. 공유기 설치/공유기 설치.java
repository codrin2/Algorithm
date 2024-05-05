import java.io.*;
import java.util.*;
public class Main {
    public static int N, C;
    public static int[] home;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for(int i=0;i<N;i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int min = 1;
        int max = home[N-1] - home[0]+1;
        while(min < max){
            int mid = (min+max)/2;
            if(canInstall(mid) < C){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);

    }
    public static int canInstall(int mid){
        int before = home[0];
        int cnt = 1;
        for(int i =1;i<N;i++){
            if(home[i]- before >= mid){
                before = home[i];
                cnt++;
            }
        }
        return cnt;
    }
}