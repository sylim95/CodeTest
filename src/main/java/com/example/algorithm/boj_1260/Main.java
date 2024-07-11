package com.example.algorithm.boj_1260;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        V = Integer.valueOf(st.nextToken());

        arr = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");

        check = new boolean[N + 1];

        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int V) {
        check[V] = true;
        sb.append(V + " ");
        for(int i = 0; i < arr.length; i++) {
            if(!check[i] && arr[V][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        queue.add(V);
        check[V] = true;

        while(!queue.isEmpty()) {
            V = queue.poll();
            sb.append(V + " ");

            for(int i = 1; i <= N; i++) {
                if(!check[i] && arr[V][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
