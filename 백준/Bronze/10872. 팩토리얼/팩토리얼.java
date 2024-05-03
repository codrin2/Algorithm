import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        int ans = 1;
        if(max == 0){
            System.out.println(ans);
        }else{
            for(int i=1;i<max+1;i++){
                ans *=i;
            }
            System.out.println(ans);
        }
        
    }
}