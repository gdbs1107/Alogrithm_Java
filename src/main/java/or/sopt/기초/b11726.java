package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11726 {

    /**
     * n=2: 2
     * n=3: 3
     * n=4: 5
     */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        if (n>3){
            for (int i=3; i<=n; i++){
                arr[i] = (arr[i-1] + arr[i-2])%10007;
            }
        }

        System.out.print(arr[n]);
    }
}
