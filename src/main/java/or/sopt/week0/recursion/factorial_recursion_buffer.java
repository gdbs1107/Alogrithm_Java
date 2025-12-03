package or.sopt.week0.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial_recursion_buffer {


    /**
     * 사용자의 입출력을 받는 로직에서
     *
     * BufferReader VS Scanner 어떤 차이가 있을까?
     *
     * BufferReader는
     *
     * */

    static Long recursion(Long in){

        if (in <=1){
            return 1L;
        }else {
            return in * recursion(in-1);
        }
    }


    public static void main(String[] args) throws IOException {

        /**
         * 점화식: f(n) = f(n-1) + f(n-2)
         * 기저조건: n=1 or n=0 일때 재귀가 종료된다
         * */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long l = Long.parseLong(bufferedReader.readLine());

        Long recursion = recursion(l);
        System.out.println(recursion);
    }
}
