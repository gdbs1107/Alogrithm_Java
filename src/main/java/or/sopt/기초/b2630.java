package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2630 {

    static int[][] arr;
    static int white;
    static int blue;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }


    static void search(int y, int x, int n){

        int temp = arr[y][x];
        boolean flag = true;

        for (int i=y; i<y+n; i++){
            for (int j=x; j<x+n; j++){
                if (arr[i][j]!=temp) {
                    flag=false;
                    break;
                }
            }

            if (!flag) break;
        }


        if (flag){
            if (temp==1) blue++;
            if (temp==0) white++;
        }else{

            int next_n = n/2;
            search(y,x,next_n);
            search(y+next_n,x,next_n);
            search(y,x+next_n,next_n);
            search(y+next_n,x+next_n,next_n);
        }

    }
}
