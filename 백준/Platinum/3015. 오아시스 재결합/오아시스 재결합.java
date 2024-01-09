import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long result = 0;
		Stack<int[]> s = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && s.peek()[0] < arr[i]) {
				result+= s.pop()[1];
			}
			
			if(s.isEmpty()) {
				s.push(new int[] {arr[i],1});
			}else {
				if(s.peek()[0] > arr[i]) {
					s.push(new int[] {arr[i],1});
					result++;
				} else {
					result+= s.peek()[1]++;
					if(s.size()>1) result++; 
				}
			}
		}
		System.out.println(result);
	}
}