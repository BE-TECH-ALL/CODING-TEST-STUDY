import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
public class Level2 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // 인접 리스트 초기화
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int cnt = 0;
        for (int i = 1; i < graph.length; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        for (int v : graph[vertex]) {
            if (visited[v] == false) {
                dfs(v);
            }
        }
    }
}
