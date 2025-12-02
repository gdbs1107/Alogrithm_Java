package or.sopt.week0;

import java.util.Scanner;

public class factorial_recursion {

    /**
     * https://www.acmicpc.net/problem/10872
     * */

    static int recursion(int in){

        if (in <=1){
            return in;
        }else {
            System.out.println("현재값: "+in);
            return in * recursion(in-1);
        }
    }


    public static void main(String[] args) {

        /**
         * 점화식: f(n) = f(n-1) + f(n-2)
         * 기저조건: n=1 or n=0 일때 재귀가 종료된다
         * */
        Scanner in = new Scanner(System.in);
        System.out.println("재귀할 숫자를 입력하세요: ");
        int n = in.nextInt();

        int recursion = recursion(n);
        System.out.println(recursion);
    }
}
