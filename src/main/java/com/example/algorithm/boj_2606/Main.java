package com.example.algorithm.boj_2606;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int computer, v;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        computer = Integer.valueOf(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        v = Integer.valueOf(st2.nextToken());

        arr = new int[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for(int i = 1; i <= v; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            // 그래프 생성
            //    1   2   3   4
            // 1  0   1 ...
            // 2
            // 3
            // 4
            arr[a][b] = arr[b][a] = 1;
        }
        System.out.println(bfs(1));
    }

    public static int bfs(int start) {
        int count = 0;

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int q = queue.poll();
            for(int i = 1; i <= computer; i++) {
                if (!visited[i] && arr[q][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
