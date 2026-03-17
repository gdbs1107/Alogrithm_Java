package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2798_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] card = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                for (int k=j+1; k<n; k++){
                    int temp = card[i] + card[j] +card[k];

                    if (temp<=m && temp>result){
                        result = temp;
                    }
                }
            }
        }

        System.out.print(result);
    }
}