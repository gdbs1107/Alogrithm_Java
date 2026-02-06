package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 기상캐스터_10709 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] arr = new char[y][x];
        int[][] result = new int[y][x];

        for (int i=0; i<y; i++){
            String line = br.readLine();

            for (int j=0; j<x; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                if (arr[i][j] == 'c'){

                    int temp = 1;

                    // 만약 c를 만났다면 그 뒤의 모든 배열 인덱스에 +1
                    for (int k=j+1; k<x; k++){
                        result[i][k] = temp;
                        temp++;
                    }
                }
            }
        }


        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
               // 만약 arr = c이면 무조건 0
                if (arr[i][j]=='c'){
                    result[i][j] = 0;
                }
                // 만약 arr =c가 아닌데 result가 0이라면 -> -1
                if (arr[i][j]!='c' && result[i][j]==0){
                    result[i][j] = -1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                sb.append(result[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);

    }
}
