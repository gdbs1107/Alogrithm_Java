package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1463 {

    static int min = 99999999;
    // 10의 6승을 포함하는 배열은 OOM이다 Heap 터짐
    // 그럼 리스트로 만들어야하나
    // 아 아니지... 어차피 N의 값만 포함하는 배열이면 되는거잖아. 그러면 굳이 정수 N이 최대값일 필요가 없지
    static int[][] arr;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        fun(n,0);
        System.out.print(min);
    }

    static void fun(int n, int cnt){
        if (n==1){
            min = Math.min(min,cnt);
            return;
        }


        /**
         * 만약에 여기서 n과 cnt를 담은 메모리를 만들고
         * 그 값을 꺼내올 수 있다고 가정해보자. 그럼 뭘 할 수 있는데?
         *
         * 그럼 이미 거긴 계산이 완료된 거니까 return하면 되지
         * */
        if (arr[n-1][cnt+1]==0){
            fun(n-1, cnt+1);
        }else{
            return;
        }

        // cnt++은 후위연산자라 cnt를 올리고 나서 ++이 된다.
        if (n%3==0) {
            if (arr[n/3][cnt+1]==0){
                fun(n/3, cnt+1);
            }else{
                return;
            }
        }

        if (n%2==0) {
            if (arr[n/2][cnt+1]==0){
                fun(n/2, cnt+1);
            }else{
                return;
            }
        }
    }

}
