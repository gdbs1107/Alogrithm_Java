package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * int[][] map = new int[][];
 * int result = 0
 * */
public class b11660 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[n+1][n+1];
        for (int i=0; i<n; i++){
            sum[i][0] = 0;
        }

        for (int i=0; i<=n; i++){
            for (int j=1; j<=n; j++){
                sum[i][j] = sum[i][j-1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            int temp = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j <= x2; j++){
                temp += sum[j][y2] - sum[j][y1 - 1];
            }

            sb.append(temp).append("\n");
        }

        System.out.print(sb);
    }

}
