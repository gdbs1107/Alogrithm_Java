package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 음 일단 왜 10장의 카드랑 20장의 카드를 정렬하는데에 30번의 연산이 필요한지는 모르겠지만,
 * 일단 n,m장의 카드를 정렬할때 n+m의 연산이 필요하다는 점화식이 있는거임
 *
 * 연산자체는 기본적으로 피보나치 같은데
 * 아니지 피보나치도 아니지
 *
 * 근데 문제에서 보면 우선순위대로 정렬하고 그걸 큐에담아서 연산을 하는게 가장 작은 경우의 수인 것 같은데?
 * 그럼 연산 점화식은 어떻게 될까?
 * a,b,c가 있을때
 * (a+b)+((a+b)+c)+((a+b+c)+d) 인거니까
 *
 * result에 이전의 (result+이번에 큐에서 나온값) 을 더하면 되는거 아님요?
 * */
public class b1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            q.offer(Integer.parseInt(br.readLine()));
        }

        if (q.size()<=2){
            if (q.size()==1) {
                System.out.print(0);
                return;
            }
            System.out.print(q.poll() + q.poll());
            return;
        }

        /**
         * 큐에서 값을 두개 빼고 두 값을 더한후 다시 큐에 넣는다
         * */
        int result = 0;
        while (q.size()>1){
            int a = q.poll();
            int b = q.poll();
            int temp = a+b;
            result = result+temp;

            q.offer(temp);
        }

        System.out.print(result);
    }
}
