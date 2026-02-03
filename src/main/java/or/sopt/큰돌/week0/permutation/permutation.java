package or.sopt.큰돌.week0.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class permutation {

    /**
     * https://www.acmicpc.net/problem/10974
     *
     * */

    public static void main(String[] args) throws IOException {

        // 배열을 선언합니다. 리스트는 메모리와 속도 측면에서 불리합니다.
        int[] arr;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(rd.readLine());

        arr = new int[input];

        // input 만큼의 배열을 만들어야함 -> 0번 인덱스부터 1로 채웁니다 -> 자연스럽게 오름차순 배열이 완성
        for(int i=0; i<input; i++){
            arr[i]= i+1;
        }
        per(arr,0,input,input);
    }




    /**
     *
     * @Param arr: 목표 배열입니다.
     * @Param depth: 현재 탐색중인 인덱스를 의미합니다.
     * @Param length: 배열의 총 길이를 나타냅니다.
     * @Param target: 순열의 길이를 나타냅니다.
     * */
    static void per(int[] arr,int depth, int length, int target){

        // 기저조건 입니다. depth가 r이라는 뜻은
        if(depth == target){
            print(arr,target);
            return;
        }


        for (int i =depth; i<length; i++){
            swap(arr,depth,i);
            per(arr,depth+1,length,target);
            swap(arr,depth,i);

        }
    }

    private static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    private static void print(int[] arr, int r) {
        for(int i =0; i<r; i++){
            System.out.print(arr[i]+"");
        }System.out.println();
    }
}
