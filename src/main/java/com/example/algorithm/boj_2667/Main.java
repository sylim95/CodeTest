package com.example.algorithm.boj_2667;


import java.util.*;

public class Main {


    static int[][] arr;
    static boolean[][] visited;
    static int n;
//    static List<Integer> apart = new ArrayList<>();
    static int[] apart = new int[25 * 25];
    static int apartLength;

    static int[] positionX = {-1,1,0,0};
    static int[] positionY = {0,0,-1,1};
    static Queue<Point> queue = new LinkedList<>();


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();*/
        n = 7;
        arr = new int[n][n];
        visited = new boolean[n][n];

        /*for(int i = 0; i < n; i++) {
            String str = scanner.next();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }*/
        arr = new int[][]{
                {0,1,1,0,1,0,0},
                {0,1,1,0,1,0,1},
                {1,1,1,0,1,0,1},
                {0,0,0,0,1,1,1},
                {0,1,0,0,0,0,0},
                {0,1,1,1,1,1,0},
                {0,1,1,1,0,0,0}
        };

        /*for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    apartLength++;
                    apart.add(bfs(i, j));
                }
            }
        }*/

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    apartLength++;
                    dfs(i, j);
                }
            }
        }

        /*apart.sort(Integer::compareTo);
        System.out.println(apartLength);
        for(int at : apart) {
            System.out.println(at);
        }*/
        System.out.println(apartLength);
        Arrays.sort(apart);
        for(int at : apart) {
            if(at != 0) {
                System.out.println(at);
            }
        }
    }

    public static void dfs(int a, int b) {
        visited[a][b] = true;
        apart[apartLength]++;

        for(int i = 0; i < 4; i++) {
            int dx = a + positionX[i];
            int dy = b + positionY[i];

            if(dx < 0 || dy < 0 || dx > n || dy > n) {
                continue;
            }

            if(dx == n || dy == n) {
                break;
            }

            if(!visited[dx][dy] && arr[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }

    public static int bfs(int a, int b) {
        int count = 0;
        visited[a][b] = true;
        queue.add(new Point(a, b));

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int i = 0; i < 4; i++) {
                int dx = p.x + positionX[i];
                int dy = p.y + positionY[i];

                if(dx < 0 || dy < 0 || dx > n || dy > n) {
                    continue;
                }

                if(dx == n || dy == n) {
                    break;
                }

                if(!visited[dx][dy] && arr[dx][dy] == 1) {
                    queue.add(new Point(dx, dy));
                    visited[dx][dy] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
