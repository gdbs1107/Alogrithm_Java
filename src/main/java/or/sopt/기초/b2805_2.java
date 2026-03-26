package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2805_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int len = max;
        int result = 0;
        while (true){

            result = 0;

            for (int i=0; i<n; i++){
                int temp =  tree[i] - len;
                if (temp > 0){
                    result += temp;
                }
            }

            if (result>=m) break;
            else len = len-1;
        }

        System.out.print(len);
    }
}
