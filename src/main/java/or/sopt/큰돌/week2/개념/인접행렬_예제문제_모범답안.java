package or.sopt.큰돌.week2.개념;
public class 인접행렬_예제문제_모범답안 {

    // 이중 배열을 만들어두고
    static int n = 10;
    static int[][] g = new int[n][n];
    static boolean[] visited = new boolean[n];

    public static void main(String[] args) {

        // 1번: 인접행렬 세팅
        g[1][2] = g[2][1] = 1;
        g[1][3] = g[3][1] = 1;
        g[3][4] = g[4][3] = 1;

        // 2번: 0번부터 방문 안 한 노드 찾고 DFS로 이어서 방문/출력
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next = 0; next < n; next++) {
            if (g[v][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}