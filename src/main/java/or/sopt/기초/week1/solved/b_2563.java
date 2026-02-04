package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

public class b_2563 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        int result = 0;

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x부터 x+10까지
            for (int j=x; j<x+10; j++){
                for (int k=y; k<y+10; k++){
                    arr[j][k]++;
                }
            }
        }

        // arr[i][j]가 1이상이면 result++
        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (arr[i][j]>=1){
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}
