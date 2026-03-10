package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1158 {

    /**
     * 포인트는 한 명이 죽었을때 자리가 한자리 댕겨져야 한다는건데...
     * 그럼 선입선출이나 후입선출과 같은 stack&queue로는 못푸는거 아닌가?
     *
     * 배열로 죽이고->정렬->죽이고->정렬?
     * 제한시간 2초니까 충분할 것 같긴한데 해볼까
     * 말이 안됨 배열의 자료는 삭제 할 수가 없잖아
     *
     * 힌트가 queue라면...
     * k배수대로 뛰는데 1k,2k,3k...
     * 만약 7 3 일때
     *
     * 3,6 죽고 남은건
     * 12457
     * 그럼 다음엔 7,1,2해서 2가 죽음
     * 그 다음엔 4 5 7해서 7이 죽고
     * 그럼 4,5가 남음
     *
     * 배열에 있고 queue에 계속 넣는거임
     * 1,2,3 넣고 3을 pop한다.
     * 4,5,6 넣고 6을 pop한다
     * 7,1,2 넣고 2를 pop한다
     *
     * 오 ㄱㅊ은데? 그럼 7다음 1,2라는건 어떻게 알 수 있을까
     * while (!queue.isEmpty()) 까지 계속 queue를 순회할 수 있다면?
     * pop하고 add를 반복해서 뒤로 보내면 되잔하아 캬캬
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n];

        for (int i=1; i<=n; i++){
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;

        while (q.size()>1){
            if (count%k==0) {
                int temp = q.poll();
                sb.append(temp).append(", ");
            }else{
                q.offer(q.poll());
            }

            count = count+1;
        }

        sb.append(q.poll());
        sb.append(">");
        System.out.print(sb);
    }
}
