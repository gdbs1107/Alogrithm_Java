package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 주몽_2트_1940 {

    /**
     * 투 포인터 문제이다.
     *
     * 배열의 앞과 뒤에서부터 시작해서 M보다 작다면 start부분을 한칸씩 앞으로 옮겨주는 것이다
     * 이게 가능한 이유는,
     *
     * end에 있는 값과 더해도 M이 되지 못한다면 그것은 그 자체로 M이 될 수 없는 요소이기 때문이다.
     * 그리고 알겠지만 이런 구현에 있어서 배열은 반드시 정렬되어 있어야한다.
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;

        while(start<end){

            if(arr[start]+arr[end]>M){
                end--;
            }else if(arr[start]+arr[end]<M){
                start++;
            }else {
                end --;
                start ++;

                result ++;
            }
        }

        System.out.print(result);

    }
}
