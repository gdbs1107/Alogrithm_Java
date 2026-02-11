package or.sopt.큰돌.week3.보충문제;

import java.util.*;
import java.io.*;


// 백트래킹 이런거 신경안쓰고 그냥 브루트포스로 갈기면?
// 결국 해당 원소를 포함했는가의 여부라는 점을 감안하자
public class b_1182_2 {

    static int n;
    static int s;
    static int[] num;
    static int result = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if (s==0) result--;
        System.out.print(result);
    }

    static void dfs(int depth, int sum){
        if (depth==n){
            if (sum==s){
                result++;
            }
            return;
        }

        // 해당 인덱스를 포함하지 않았을 때
        dfs(depth+1, sum);
        // 해당 인덱스를 포함했을 때
        dfs(depth+1, sum+num[depth]);
    }

}
