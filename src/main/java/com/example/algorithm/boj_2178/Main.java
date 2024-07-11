package com.example.algorithm.boj_2178;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] arr;
    static Queue<Point> queue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String input = scanner.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        visited[0][0] = true;
        System.out.println(bfs(new Point(0, 0, 1)));
    }

    public static int bfs(Point point) {
        queue.add(point);
        int[] rangeX = {-1,1,0,0};
        int[] rangeY = {0,0,-1,1};

        int dx,dy;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x == N-1 && p.y == M-1) {
                return p.cnt;
            }

            for (int i = 0; i < 4; i++) {
                dx = p.x + rangeX[i];
                dy = p.y + rangeY[i];

                if (dx > N-1 || dy > M-1 || dx < 0 || dy < 0) {
                    continue;
                }

                if (arr[dx][dy] == 1 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.add(new Point(dx, dy, p.cnt + 1));
                }
            }
        }

        return 0;
    }
}
