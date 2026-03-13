package or.sopt.기초;

import java.util.*;
import java.io.*;


/**
 *
 * */
public class b10816_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> dp = new HashMap<>();

        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
            if (!dp.containsKey(input[i])){
                dp.put(input[i],1);
            }else{
                dp.put(input[i], dp.get(input[i])+1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (dp.containsKey(temp)){
                sb.append(dp.get(temp)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }
}
