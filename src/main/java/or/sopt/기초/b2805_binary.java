package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2805_binary {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long max = 0;

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long low = 0;
        long high = max;

        while (low<high){
            long mid = (low+high)/2;
            long target = 0;

            for (int val : tree){
                if (val-mid>0) target += val-mid;
            }

            if (target<m){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        System.out.print(low-1);
    }
}
