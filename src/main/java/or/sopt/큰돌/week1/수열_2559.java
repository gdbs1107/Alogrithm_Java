package or.sopt.큰돌.week1;

import java.util.*;
import java.io.*;

public class 수열_2559 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int result = 0;

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] arr = new int[(n/k)];

        int[] temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for (int j=0; j<n; j++){

            if (j+k > temp.length){
                break;
            }

            for (int l=0; l<k; l++){
                System.out.println("aaaaaa"+l+j);
                result = result + temp[j+l];
                System.out.println("중간점검  "+ result);
            }

            arr[j] = result;
            result = 0;
        }

        System.out.print(Arrays.toString(arr));


    }

}
