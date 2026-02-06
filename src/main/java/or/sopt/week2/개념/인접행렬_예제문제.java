package or.sopt.week2.개념;

import java.io.*;

public class 인접행렬_예제문제 {

    public static void main(String[] args) throws IOException{

        int[][] arr = {
                {0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };

        int[] visited = new int[8];

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){

                if (arr[i][j]==1 && visited[i]==0){
                    System.out.print(i);
                    visited[i]=1;
                    continue;
                }

            }
        }

    }
}
