package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2531 {

    /**
     * 9,7,30,2,25가 있을때
     * 연속하지 않을때 숫자를 가져오는 경우는 (9, 7, 30, 2), (30, 2, 7, 9), (2, 7, 9, 25)
     *
     * 한 위치에서 k개의 연속된 초밥을 먹을 경우 할인가격으로 제공함
     * 해당 이벤트에 참여할 경우 쿠폰에 적힌 초밥을 하나 더 무료로 제공함 (이건 무조건임)
     * 위의 내용에 한하면, (2, 7, 9, 25) 일때가 가장 큰 값임. 이건 연속한 수니까 그런거임
     *
     *
     * 1. 메뉴에 있는 초밥의 가짓수: d
     * 2. 초밥 벨트에 놓여진 초밥의 수: N
     * 3. 연속해서 먹는 초밥의 수: K
     * 4. 쿠폰 번호: c
     *
     * 이때, 손님이 먹을 수 있는 초밥의 최대 가짓수
     *
     * ----------------------------------------
     *
     * 그럼 가짓수가 가장 많은 경우는 무조건 연속하는 경우 아니야?
     * 연속함 + 쿠폰에 적힌 초밥이 아니어야함 (그래야 추가로 더 받으니까)
     *
     * 그럼 슬라이딩 윈도우를 써서 k개가 연속하는 경우를 받고
     * 하나의 슬라이드에서 무엇을 검증해야하는지 확인해야함
     * 1. 초밥의 가짓수가 max인지
     * 2. c초밥이 포함되어 있진 않은
     * 초밥 가짓수가 MAX면
     *
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초밥의 가짓수
        int n = Integer.parseInt(st.nextToken());
        // 초밥 갯수
        int d = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 초밥수
        int k = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        int c = Integer.parseInt(st.nextToken());

        int[] cho = new int[n];
        for (int i=0; i<n; i++){
            cho[i] = Integer.parseInt(br.readLine());
        }

        // 최대 초밥의 가짓수 정리(이게 정답)
        int res = 0;
        int start = 1;
        int end = k;

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<k; i++){
            temp.add(cho[i]);
        }

        while (start != n) {
            if (end > n) end = end % n;

            // 이전에 있던걸 지우고
            temp.remove(cho[start - 1]);
            // 새로운 end를 넣는다
            if (!temp.contains(cho[end])) temp.add(cho[end]);

            // 만약 k를 포함하고 있다면 최대 가짓수가 될 수 없음
            if (temp.contains(c)) {
                start++;
                end++;
                continue;
            }


            res = Math.max(temp.size()+1, res);
            start++;
            end++;
        }

        System.out.print(res);
    }

}
