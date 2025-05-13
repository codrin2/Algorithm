import java.io.*;
import java.util.*;

class Point{
    int x,y,z;
    Point(int a, int b, int c){
        x = a;
        y = b;
        z = c;
    }
}

public class Main {
    static int row, col, len;
    static int[][][] tomato, visit;
    static int[] dx = {-1, 0, 1 ,0 ,0 ,0};
    static int[] dy = {0, 1, 0 ,-1 ,0 ,0};
    static int[] dz = {0, 0, 0 ,0 ,1 ,-1};
    static Queue<Point> q = new LinkedList();

    public static void main(String[] args) throws IOException {


        //최소 몇일
        // 처음부터 모든 토마토가 익으면 0 -> 체크시 0이 없음
        // 익지 못하는 상황이면 -1 -> BFS 모두 끝났는데도 체크시 0이 남아있는 경우

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        tomato = new int[len][col][row];
        visit = new int[len][col][row];

        for(int i =0;i<len;i++){
            for(int j =0;j<col;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<row;k++){
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i =0;i<len;i++){
            for(int j =0;j<col;j++){
                for(int k=0;k<row;k++){
                    if(tomato[i][j][k] == 1){
                        q.add(new Point(k,j,i));
                    }
                }
            }
        }

        if(checkRaw()){
            // BFS
            while(!q.isEmpty()){//계속 반복인데 언제 끝나야하지? -> 방문하지 않은 1이 없는 경우
                Point now = q.poll();
                int nowX = now.x;
                int nowY = now.y;
                int nowZ = now.z;
                for(int i=0;i<6;i++){
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];
                    int nextZ = nowZ + dz[i];
                    // 정상인 경우 전파 진행
                    if(0 <= nextX && nextX <row && 0 <= nextY && nextY <col && 0 <= nextZ && nextZ<len && tomato[nextZ][nextY][nextX] == 0){
                        tomato[nextZ][nextY][nextX] = 1;
                        visit[nextZ][nextY][nextX] = visit[nowZ][nowY][nowX] + 1;
                        q.add(new Point(nextX, nextY, nextZ));
                    }
                }
            }
            // 일 수 체크 어떻게? -> 현재 단계에서 1의 개수만큼 전파시키면 끝
            // visit을 사용하면 되는데 이걸 활용 못했다

            //출력
            if(checkRaw()){// 모두 익히 못함
                System.out.println(-1);
            }else{
                System.out.println(checkMax());
            }
            
        }else{
            //출력
            System.out.println(0);
        }
        
    }

    // check로직
    static boolean checkRaw(){
        for(int i =0;i<len;i++){
            for(int j =0;j<col;j++){
                for(int k=0;k<row;k++){
                    if(tomato[i][j][k] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // 최댓값 탐색
    static int checkMax(){
        int max = 0;
        for(int i =0;i<len;i++){
            for(int j =0;j<col;j++){
                for(int k=0;k<row;k++){
                    max = Math.max(visit[i][j][k], max);
                }
            }
        }
        return max;
    }
}
