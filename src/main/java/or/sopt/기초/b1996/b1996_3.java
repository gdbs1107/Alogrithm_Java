package or.sopt.기초.b1996;


import java.util.*;
import java.io.*;

/**
 * 1. 큐 내부에 배열을 넣는다는 idea
 * 2. 배열을 선언하는 방식
 * 3. Queue도 결국 List의 구현체 -> 인덱스로의 접근이 가능하다는 사실
 *
 * 결국 이또한 복합인덱스의 개념을 활용할 수 있는거임
 * 가장 큰 병목이 같은 1을 어떻게 처리할까...였는데 이는 나한테 주어진 리소스가 unique하지 않다 때문이었고
 * 이를 unique하게 만들 수 있다면 해결이 가능한 부분이었던 것.
 * */
public class b1996_3 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int[] tar = new int[2];
            for (int j=0; j<n; j++){
                int priority = Integer.parseInt(st.nextToken());

                // 인덱스와 우선순위를 저장한다
                int[] temp = {j,priority};
                q.offer(temp);
                if (j==m){
                    tar = new int[]{j, priority};
                }
            }

            int[] cur = q.peek();
            int[] max = cur;
            int result = 0;
            for (int j=0; j<q.size(); j++){

                // 큐의 i번째 인덱스의 1번원소 즉, 우선순위가 cur의 우선순위보다 높다면 cur은 뒤로 보내야함
                if (q.get(j)[1]>cur[1]){
                    max = q.get(j);
                }
            }

            if (max[1]!=cur[1]){
                q.offer(q.poll());
            }else{
                if (max[0]==tar[0]){
                    System.out.println(result+1);
                }else{
                    q.poll();
                    result++;
                }
            }
        }
    }
}
