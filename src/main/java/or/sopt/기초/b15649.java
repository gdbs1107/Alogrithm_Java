package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 순수한 조합문제네
 * 근데 순서가 상관이 있는 순열이네
 *
 * 일반적인 완탐이면 안되지않나? 그럼 순서가 고려가 안되는
 * 그냥 이중반복하고 contains로 있는지 없는지 판단한다면?
 * 아니지 m중반복을 해야하는데 그러면
 *
 * 1부터 시작해서 조합
 * 2부터 시작해서 조합....해서 contains로 판단?
 *
 * 각 자리의 숫자를 랜덤으로 돌려서 중복되지 않음을 판단한다면?
 *
 * 중복되면 안된다 -> HashMap?
 *
 *
 * ---------------------
 *
 * 재귀를 활용한 백트래킹이 맞는 구현인데 + 방문처리를 진행한다
 * 그러면 방문했다는 기준은 해당 임시값에 그 숫자가 들어있어야한다는거고
 * 그럼 만약 1을 포함하지 않아서 방문처리가 안된 경우 어떻게 다시 1로 돌아오지? (ex.2 1)
 * depth가 n을 넘어가면 depth%n 의 인덱스를 찾는다?
 * 그럼 만약 1 2 3인 경우 n은 3이고 인덱스는 2임, 이때 depth가 3으로 가면 그냥 N으로 나눠야겠네
 *
 *
 * */
public class b15649 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] num;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        num = new int[n];

        for (int i=0; i<n; i++){
            num[i] = i+1;
        }

        fun("",0);

        System.out.println(sb);
    }

    static void fun(String temp, int depth){

        // temp의 길이가 m과 같으면 들여쓰기
        // 근데 이것만이 기저사례면 계속 빈칸만 들어가는 경우 무한재귀가 되어버림
        if (temp.length()==m){
            for (int i=0; i<m; i++){
                sb.append(temp.charAt(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (depth>8){
            if (temp.length()==0){
                return;
            }
        }

        String tar = String.valueOf(num[depth%num.length]);

        fun(temp, depth+1);
        // temp가 tar를 포함하고 있지않다면 -> temp에 추가해서 재귀
        if (!temp.contains(tar)) fun(temp+tar, depth+1);
    }

}
