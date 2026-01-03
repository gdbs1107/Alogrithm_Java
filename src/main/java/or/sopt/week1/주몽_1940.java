package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 주몽_1940 {


    /**
     * 이렇게 접근하면 안된다는거지.
     * 이미 사용된 재료는 다시 사용되면 안됨
     *
     * 헐 메모리 초과래 레전드다
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer,Integer> visited = new HashMap<>();
        int result = 0;

        String input = br.readLine();
        String[] tokens = input.split(" ");

        for (int i=0; i<N; i++){
            int a = Integer.parseInt(tokens[i]);
            arr[i] = a;
            visited.put(arr[i],0);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(visited);

        for (int j=0; j<arr.length; j++){

            // 만약 해당 값이 사용됐으면 skip하는 로직이 필요
            if (visited.get(arr[j])==1){
                continue;
            }

            for (int h=j; h<arr.length; h++){

                // 만약 해당 값이 사용됐으면 skip하는 로직이 필요
                if (visited.get(arr[h])==1){
                    continue;
                }

                if(arr[j]+arr[h]>=M){
                    result++;
                    visited.put(arr[j],1);
                    visited.put(arr[h],1);

                    System.out.println(result);
                }
            }
        }

        System.out.print(result);
    }
}
