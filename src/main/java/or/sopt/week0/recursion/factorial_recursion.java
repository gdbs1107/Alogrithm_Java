package or.sopt.week0.recursion;

import java.util.Scanner;

public class factorial_recursion {

    /**
     * https://www.acmicpc.net/problem/10872
     *
     * 배운점
     * 1. 백준을 자바로 제출 할때는 불필요한 print를 제외해야 합니다.
     * 2. 클래스를 Main으로 두어야 합니다.
     * 3. 아주 작은 부분도 잘 챙겨야합니다. (recursion 메서드의 in이 0,1 인 경우를 고려하지 않았음)
     *
     * 4. 그리고 만약 해당 input 값이 13이라면 int로 바인딩이 불가능합니다.
     * int의 범위는 2,147,483,648 ~ 2,147,483,647 이기 때문에 13!은 초과해서 바인딩을 하지 못하고 1278945280 이러한 값이 나오게 되죠.
     * 그래서 범용적인 구현으로는 long으로 구현해주어야 합니다.
     *
     *
     * */

    static long recursion(long in){

        if (in <=1){
            return 1;
        }else {
            return in * recursion(in-1);
        }
    }


    public static void main(String[] args) {

        /**
         * 점화식: f(n) = f(n-1) + f(n-2)
         * 기저조건: n=1 or n=0 일때 재귀가 종료된다
         * */
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();

        long recursion = recursion(n);
        System.out.println(recursion);
    }
}
