import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static List<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for(int i =0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        for(int i : arr){
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}