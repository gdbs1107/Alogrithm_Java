package or.sopt.큰돌.week3.보충문제;

import java.util.*;
import java.io.*;


/**
 * 그냥 접근 방식 자체가 틀려버린 문제이다
 * 난 연속된 수열로만 생각해서 이렇게 풀게되면
 *
 * 5 0
 * -7 -3 -2 5 8
 *
 * 입력이 이럴 경우 {-7,5} 를 포함할 수 없게됨
 * */
public class b_1182{

    static int[] num;
    static int n;
    static int s;
    static int result;
    static ArrayList<int[]> visited = new ArrayList<>();

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

        for (int i=0; i<num.length; i++){
            dfs(0,i);
        }

        System.out.print(result);
    }

    // 길이만큼 배열을 만든다
    static void dfs(int start, int len){
        int temp = 0;
        int[] tempArr = new int[len+1];

        // 만약 start+len == num.length-1 과 같다면 return
        if ((start+len)==num.length-1) return;


        // start부터 시작해서 len까지 묶는다
        for (int i=0; i<=len; i++){
            tempArr[i] = num[start+i];
            temp += num[start+i];
        }

        // 만약 그 값이 s와 같다면 result++
        // 방문처리가 안되어있다면을 묶인 값을 다 더하고 방문처리
        if (visited.contains(tempArr)) dfs(start++, len);

        if (temp==s) result++;
        visited.add(tempArr);

        // 결과와 상관없이 start+1,len으로 재귀한다
        // start++로 하면 후위증가라 함수가 호출되고 나서 start가 증가해버린다
        dfs(start+1, len);
    }
}
