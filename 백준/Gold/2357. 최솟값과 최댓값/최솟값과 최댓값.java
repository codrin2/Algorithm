import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] minTree, maxTree;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        minTree = new int[4*N];
        maxTree = new int[4*N];

        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        initMin(1,N,1);
        initMax(1,N,1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            get(1, N, 1, a, b);
            System.out.println(min + " " + max);
        }
    }

    static void initMin(int start, int end, int node) {
        if (start == end) {
            minTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            initMin(start, mid, node*2);
            initMin(mid + 1, end, node*2+1);
            if ((node * 2 + 1) == 0) {
                minTree[node] = arr[node*2];
            } else {
                minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);

            }}
    }

    static void initMax(int start, int end, int node) {
        if (start == end) {
            maxTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            initMax(start, mid, node*2);
            initMax(mid + 1, end, node*2+1);
            maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
        }
    }

    static void get(int start, int end, int node, int a, int b) {
        if(b < start || end < a) return;
        if (a <= start && end <= b) {
            min = Math.min(min, minTree[node]);
            max = Math.max(max, maxTree[node]);
            return;
        }
        int mid = (start+end)/2;
        get(start, mid, node*2, a, b);
        get(mid + 1, end, node*2+1, a, b);
    }
}