package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 1번연산, 2번연 3번연산이 존재한다
 * 1번은 그냥 pop
 * 2번은 offer(poll())
 * 3번은 이게 문젠데 이거 하려면 양방향큐(Deque)를 써야하는게 아닌가?
 *
 * 있다고 치고, 주어진 원의 순서대로 뽑는데에 든 turn의 수를 만들어야한다가 중요하다.
 * 음 재귀를 써야하나?
 *
 * while(true) 로 두고
 * peek가 n이 나올때가지로 둬야겠는데?
 *
 * 그리고 1,2,3번 연산을 다 태워버려
 * 똑같잖아 그냥 완탐임
 *
 * 모든 경우의수를 돌릴 필요가 없고
 * peek가 n보다 작으면 n이 나올때까지 뽑아서 뒤로 넘기면 됨
 * peek가 n보다 크다면 n이 나올때까지 앞으로 넘기면 됨
 *
 * 아 근데 최소값을 뽑아야하는거잖아....
 *
 * 절반을 쪼개서 앞뒤로 인덱스를 비교하는게 아이디어였던 것 같다.
 * 사실상 구현문제
 * */
public class b1021 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<Integer>();

        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
        int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < M; i++) {

            // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;
            /*
             *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을
             *  현재 덱의 절반 크기에서 -1 감소시킨다.
             *
             *  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
             *  인덱스는 1이기 때문
             */
            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            }
            else {
                half_idx = deque.size() / 2;
            }


            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if(target_idx <= half_idx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                for(int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for(int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }

            }
            deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
        }

        System.out.println(count);


    }
}
