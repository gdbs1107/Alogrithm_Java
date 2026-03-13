package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 이것은!! 너무나도 쉬운 우선순위 큐 문제네요
 * */
public class b1927_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp==0){
                if (queue.isEmpty()){
                    System.out.println(0);
                }else {
                    int num = queue.poll();
                    System.out.println(num);
                }
            }else{
                queue.offer(temp);
            }
        }
    }
}
