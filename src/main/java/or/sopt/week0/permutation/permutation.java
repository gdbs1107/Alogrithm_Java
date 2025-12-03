package or.sopt.week0.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class permutation {

    /**
     * https://www.acmicpc.net/problem/10974
     * */

    public static void main(String[] args) throws IOException {

        int[] arr;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Integer input = Integer.parseInt(rd.readLine());

        arr = new int[input];

        // input 만큼의 배열을 만들어야함
        for(int i=0; i<input; i++){
            arr[i]= i+1;
        }
        per(arr,0,input,input);
    }




    static void per(int[] arr,int depth, int n, int r ){
        if(depth == r){
            print(arr,r);
            return;
        }


        for (int i =depth; i<n; i++){
            swap(arr,depth,i);
            per(arr,depth+1,n,r);
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
