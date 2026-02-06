package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 빈도정렬_2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new HashMap<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<len; i++){
            int input = Integer.parseInt(st2.nextToken());

            if (map.containsKey(input)){
                map.put(input, map.get(input) + 1);
            }else {
                map.put(input,1);
            }
        }




    }

}
