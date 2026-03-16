package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 3,1,2,3,4,1,1,2
 * 일때 3~3 사이에 물이 가둬지고
 *
 * n이 나옴 -> 본인보다 같거나 큰 n이 나올때까지: 본인-현재 블록값을 반복함
 * 그러다가 본인보다 같거나 큰 블록이 나오면 그때 result에 값을 반영하고 그 블록이 새로운 n이 됨
 *
 * 아니지 물을 가두는 웅덩이가 끝나는 기준은 다음과 같음
 * 1. 본인이랑 같거나, 본인보다 큰 블록이 나옴
 * 2. 쭉 이어지다가 갑자기 블록이 작아짐
 *
 * 그러면 지금까지의 물을 저장하고, 그 블록이 새로운 n이 됨
 *
 *
 * ---
 *
 * 그럼 로직이 어떻게 되냐
 * 1. W를 기준으로 순회를 시작함
 * 2. 현재의 블록을 cur로 저장함
 * 3. 그리고 다음 블록으로 진행하는데 이때 위의 두가지 경우가 아니라면 result에 cur-now값을 갱신해나감
 * 4. ㅡㄱ러다가 위의 두가지 경우에 다다르면 flag를 해당 값으로 초기화하고 result ㅇㅋㅇㅋ
 *
 * 근데 와중에 예외가 있다는거임.
 * w가 끝까지 갔거나
 *
 *
 * ---
 *
 * 잠깐 아에 다시 생각해보자. 어차피 구현문제니까 추상적 알고리즘을 떠올리고 그걸 코드로 구현만하면 된다
 * 처음 블록 n과 같거나 보다 큰 블록이 오면 그게 하나의 웅덩이가 됨
 * (+ 다음 블록보다 본인이 큰 경우에도 거기서 웅덩이가 닫힘)
 * 그럼 본인보다 큰 블록이 올때까지의 y축과 x축을 저장해두었다가 본인보다 큰 블록이 왔을때 이를 곱하면 되는 것이 아닌가?
 *
 * 그리고 걸린 블록이 새로운 축이 되는거지
 *
 * 이때 만약 w의 끝에 도달했다면 이게 제일 문젠데...
 * 만약 본인보다 이전의 4 1 1 1 이라면 웅덩이가 안생겨서 그냥 0이됨
 * 4 1 1 2 1 이라면 (2 1) 에서 이전에 웅덩이가 닫히는구나
 *
 * 그럼 w가 끝에 도달한 경우, 해당 블록이 끝기둥이 돼서 cur보다 작으면 걔가 y가 되면 되네
 *
 *
 * 정리해보자
 * 현재 기둥: cur
 * 이번 턴에 탐색하는 기둥: now
 *
 * arr을 돌면서 cur과 now를 비교함
 * 1. if now>=cur 이라면, result += ((now-cur) * cur) 하고 cur = now가 됨
 * 2. if arr[i]>arr[i+1] 인 경우, result += ((now-cur) * Math.min(now,cur)) 하고 cur = now가 됨
 *
 * 그리고 만약 i가 w에 도달하면 result += ((now-cur) * Math.min(now,cur)) 하고 cur = now가 됨
 * */
public class b14719 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<w; i++){
            for (int j=0; j<h; j++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int cur_h = arr[0];
        int cur_w = 0;
        int result = 0;
        for (int i=1; i<arr.length; i++){

            int now = arr[i];
            // cur보다 크거나 같으면 result += ((now-cur) * Math.min(now,cur)) 하고 cur = now가 됨
            if (now>=cur_h){
                result += ((i-cur_w) * Math.min(now,cur_h));
                cur_h = now;
                cur_w = i;
                continue;
            }

            // 끝까지 다다랐으면 result += ((now-cur) * Math.min(now,cur)) 하고 cur = now가 됨
            if (i==arr.length){
                result += ((i-cur_w) * Math.min(now,cur_h));
            }
        }

        System.out.print(result);

    }
}
