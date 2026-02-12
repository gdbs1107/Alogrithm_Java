package or.sopt.큰돌.week3.보충문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b_15649 {

    public static int N;	// 정적변수로 변경
    public static int M;	// 정적변수로 변경
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정적변수 N과 M을 초기화해준다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        // 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
        dfs(0);
        System.out.println(sb);

    }

    /**
     * depth는 자리수를 의미한다
     * visited는 방문한 i를 의미한다: i=2라면 2까진 다 방문했으니 3을 방문하라 를 의미하게 되는거임
     *
     * 그리고 visit하고 난 뒤에는 어차피 다시 그 i를 방문할 일이 없고 + 다음 depth때도 방문해야하기 때문에 반드시 원복시켜야하는거임
     * */
    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 이렇게 만들어진 depth는 재귀 특성 상, 계속해서 depth를 파고 들어가기 때문에 visit를 유지 할 수 있는거임
        // 특정 자리수를 고정해두고 다음 자리의 수를 정한다
        // 근데 왜 i+1을 arr[i]에 넣는걸까 헷갈리게: 출력해야하는 숫자가 1부터라그래. 그러니까 숫자 인풋 배열을 만들어두면 보다 직관적이게 풀 수 있음
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

}