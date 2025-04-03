import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;
    static int moveCount = 0;
    static Deque<int[]> bomb =  new ArrayDeque<>();
    static Deque<int[]> moveStack = new ArrayDeque<>();
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            char[] chars = temp.toCharArray();
            for(int j = 0; j < C; j++) {
                if (Objects.equals(chars[j], 'I')) {
                    board[i][j] = 1;
                } else if (Objects.equals(chars[j], 'R')) {
                    board[i][j] = 2;
                } else {
                    board[i][j] = 0;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        char[] moving = st.nextToken().toCharArray();
        for(int i = 0; i < moving.length; i++) {
            int dirt = Integer.parseInt(String.valueOf(moving[i]));
            boolean isFinish = move(dirt);
            if(isFinish) {
                System.out.println("kraj " + moveCount);
                return;
            }
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i][j] == 0) {
                    System.out.print(".");
                } else if (board[i][j] == 1) {
                    System.out.print("I");
                } else {
                    System.out.print("R");
                }
            }
            System.out.println();
        }
    }
    // 2가 같은 위치 만나면 삭제
    static boolean move(int direction) {
        int targetX = 0, targetY = 0;
        outer:
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                    moveCount++;
                    int nextX = i + dx[direction];
                    int nextY = j + dy[direction];
                    if (board[nextX][nextY] == 2) {
                        return true;
                    }
                    board[nextX][nextY] = 1;
                    targetX = nextX;
                    targetY = nextY;
                    break outer;
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(board[i][j] == 2) {
                    int min = Integer.MAX_VALUE;
                    int minX=0, minY=0;
                    for (int k = 1; k <= 9; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                            continue;
                        }
                        int now = Math.abs(targetX - nextX) + Math.abs(targetY - nextY);
                        if(min > now) {
                            min = now;
                            minX = nextX;
                            minY = nextY;
                        }
                    }
                    board[i][j] = 0;
                    if (board[minX][minY] == 1) {
                        return true;
                    }
                    moveStack.push(new int[]{minX, minY});
                }
            }
        }

        while(!moveStack.isEmpty()) {
            int[] move = moveStack.pop();
            int x = move[0];
            int y = move[1];
            if (board[x][y] == 2) {
                bomb.push(new int[]{x, y});
            }
            board[x][y] = 2;
        }

        while(!bomb.isEmpty()) {
            int[] toBomb = bomb.pop();
            board[toBomb[0]][toBomb[1]] = 0;
        }

        return false;
    }
}