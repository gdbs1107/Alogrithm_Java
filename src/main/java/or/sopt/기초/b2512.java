package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2512 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int money = Integer.parseInt(br.readLine());

        int low = 0;
        int high = max+1;

        while (low<high){
            int result = 0;
            int mid = (low+high)/2;

            for (int val: arr){
                if (val<mid) result += val;
                else result += mid;
            }

            if (result <= money){
                low = mid+1;
            }else {
                high = mid;
            }
        }

        System.out.print(low-1);
    }

}
