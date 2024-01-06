import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		String[] input = bf.readLine().split(" ");
		int[] result = new int[num];
		int[] nums = new int[num];
		for(int i = 0; i < num; i++)
			nums[i] = Integer.parseInt(input[i]);
		int[] nums_count = new int[1000001];
		for(int i = 0; i < num; i++)
			nums_count[nums[i]]+=1;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < num; i++) {
			if(stack.isEmpty())
				stack.push(i);
			while(!stack.isEmpty() && nums_count[nums[stack.peek()]] < nums_count[nums[i]]) {
				result[stack.pop()] = nums[i];
			}
			stack.push(i);
		}	
		while(!stack.isEmpty())
			result[stack.pop()] = -1;
		
		for(int i = 0; i < num; i++)
			bw.write(result[i]+" ");
		bw.flush();
		return;
	}
}