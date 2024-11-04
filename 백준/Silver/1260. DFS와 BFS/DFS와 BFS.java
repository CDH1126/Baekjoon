import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 정점 개수
        int m = sc.nextInt();  // 간선 개수
        int v = sc.nextInt();  // 시작 정점

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);  // 오름차순 정렬
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        bfsWithoutQueue(v);
    }

    static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfsWithoutQueue(int start) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        visited[start] = true;
        int index = 0;

        while (index < list.size()) {
            int node = list.get(index++);
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    list.add(next);
                }
            }
        }
    }
}
