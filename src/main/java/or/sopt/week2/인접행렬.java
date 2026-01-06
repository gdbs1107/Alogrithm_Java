package or.sopt.week2;

import java.io.*;
import java.util.*;

public class 인접행렬 {

    public static void main(String[] args) throws IOException{

        int[][] arr = {
                {0,1,1,1,0},
                {1,0,1,0,1},
                {1,1,0,1,0},
                {1,0,1,0,1},
                {0,1,0,1,0}
        };


        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if (arr[i][j] == 1){

                    // 뭐 이런식이다
                    DFS();
                    BFS();

                }
            }
        }

    }

    public static void DFS(){

    }

    public static void BFS(){

    }
}
