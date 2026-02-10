package or.sopt.기초.week2.unsolved;

import java.util.*;
import java.io.*;

// 자기보다 뒤에있는 애들을 카운팅한다는 개념에서 '순위'라는 개념으로 옮겨보자
// 시간초과나서 틀림
public class b_18870 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];

        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            ArrayList<Integer> visited = new ArrayList<>();
            int temp = arr[i];

            // 여기가 문제같은데
            for (int j=0; j<arr.length; j++){
                if (temp>arr[j] && !visited.contains(arr[j])){
                    result[i]++;
                    visited.add(arr[j]);
                }
            }

            sb.append(result[i]).append(" ");
        }


        System.out.print(sb);
    }
}