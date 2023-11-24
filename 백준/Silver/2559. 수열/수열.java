import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] input = new int[n];
        int result = -100 * k;
        int sum = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(st.nextToken());
            input[i] = num;
            sum += num;
            if(i >= k ){
                sum -= input[i-k];
            }
            if(i >= k-1){
                result = Math.max(result,sum);
            }
        }
        System.out.println(result);
    }
}