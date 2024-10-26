import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            if (input.matches(".*FBI.*")) {
                result.add(i+1);
            }
        }

        if (result.isEmpty()) {
            System.out.println("HE GOT AWAY!");
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if ((i+1) != result.size()) {
                System.out.print(" ");
            }
        }
    }
}
