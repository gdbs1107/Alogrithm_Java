package or.sopt.큰돌.week3.보충문제;

import java.util.*;
import java.io.*;

/**
 * 이건 틀린 로직임 -> 이렇게 구현하면 1 2 3/3의 경우에는 경우의 수가 3보다 커서 num[depth]에서 터져버림
 *
 *
 * */
public class b_15649_2{

    static int n;
    static int m;
    static int[] num;
    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];

        for (int i=0; i<n; i++){
            num[i] = i+1;
        }

        dfs(0,"");

        Collections.sort(result);
        for (int i=0; i<result.size(); i++){
            String temp = String.valueOf(result.get(i));
            StringBuilder sb = new StringBuilder();

            for (int j=0; j<temp.length(); j++){
                sb.append(temp.charAt(j)).append(" ");
            }

            System.out.println(sb);
        }
    }

    static void dfs(int depth, String input){

        if (depth==m && input.length()==m){
            int temp = Integer.parseInt(input);
            if (!visited.contains(temp)){
                result.add(temp);
            }

            return;
        }

        StringBuilder sb = new StringBuilder(input);
        dfs(depth+1, String.valueOf(sb.append(num[depth])));
        dfs(depth+1, input);
    }
}