package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 기본적으로 우선순위 큐 문제인데, 우선순위 큐 내부 정렬로직이 아래와 같음
 * 1. 절댓값 기준 오름차순
 * 2. 절댓값이 같은 경우 실제 값이 작은게 앞에 들어감
 * */
public class b11286 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2){
                int abso1 = Math.abs(o1);
                int abso2 = Math.abs(o2);

                if (abso1<abso2){
                    return -1;
                }else if (abso1>abso2) {
                    return 1;
                }else{
                    if (o1<o2){
                        return -1;
                    }else if (o1>o2){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());

            if (temp==0) {
                if (queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll());
                }
            }
            else queue.offer(temp);
        }
    }
}
