/*
package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1966 {

    */
/**
     * t개의 반복을하는데
     * n까지의 숫자가 큐에 들어가고
     * 만약 뒤에 본인보다 숫자가 높은 숫자가 존재한다면 -> q.offer(q.poll())
     *
     * 중요도가 같은 문서가 여러개일 수 있다는게 포인트네
     * 이걸 어떻게 표현할 수 있을까
     *
     * flag로 m번째의 인덱스에 있는 값을 저장하고
     * flag보다 크거나 같은 값이 뒤에 존재한다면
     * 그 안에서 큰 값만 존재한다면 q.offer(q.poll())
     * 같은값만 존재한다면 그냥 출력
     *
     * 아니지 그래도 답이 안나오는데
     * flag와 함께 인덱스가 같이 움직여야 할 것 같은데
     * m을 계속 같이 넘기다가 만약 m이 0이라면 -> q.size()가 된다.
     *
     * 그리고 만약 flag==q.peek() && m==0 일때만 답이 된다
     * 정리해보자
     *
     *
     *
     * while (true){
     *     if (q.peek()==flag){
     *         if (m==0){
     *             Sys...(result);
     *             break;
     *         }
     *
     *         q.add(a.poll());
     *         m--;
     *         result++;
     *         continue;
     *     }
     *
     *     // 여기는 peek가 flag와 다름 -> 답이 아님
     *     q.add(q.poll());
     *     result++;
     * }
     *
     * 아 안된다. 큐 내부에 peek보다 더 큰 숫자가 존재하는지는 어떻게 판단할 수 있을까
     *
     * *//*

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int tar = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();

    */
/*        st = new StringTokenizer(br.readLine());
            for (int i=0; i<len; i++){
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int max = q.peek();
            result = 0;
            for (int i=0; i<len; i++){
                int temp = q.poll();
                max = Math.max(max,temp);
                q.offer(temp);
            }

            if (temp==max){
                q.pop();
                result++;
            }else{
                q.offer(temp);
            }
        }
    }*//*


}
*/
