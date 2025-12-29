package or.sopt.week0.combination;

import java.io.*;
import java.util.*;

public class combination_recursion {

    /**
     * https://www.acmicpc.net/problem/15650
     *
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
     * 고른 수열은 오름차순이어야 한다.
     * */


    public static int[] arr;
    public static int n;
    public static int m;



    public static void main(String[] args) throws IOException {

        /**
         * StringTokenizer
         *
         * 문자열을 특정 구분자를 기준으로 잘라서 토큰 단위로 읽어오는 클래스
         * 기본 구분자로서 " "를 제공한다.
         *
         * 다른 문자열 구분자를 사용하고 싶으면 아래와 같이 쓸 수 있음
         * StringTokenizer st = new StringTokenizer("10,20,30", ",");
         *
         * Split()은 정규식을 기반으로 동작하기 때문에 StringTokenizer가 보다 빠르다고 할 수 있음
         * */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[m];

        recursion(1,0);
    }

    public static void recursion(int at, int depth) {
        if (depth == m) {
            for(int val: arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }


        for (int i = at; i <= n; i++) {

            arr[depth] = i;
            recursion(i + 1, depth + 1);

        }

    }

}
