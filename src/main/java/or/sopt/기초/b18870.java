package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 그러니까 n번째의 인덱스에서
 * 본인보다 작은 요소의 개수를 출력하는 코드를 만들어라 아님?
 * 존2나 쉬운데 제한시간도 2초임
 *
 * 어떻게 하면 좋을까
 * 입력받은 배열과 출력용 배열을 만든다
 * 그리고 비교하면 될 것 같은데 함정이 있겠찌. 일단 구현
 *
 * 음 역시 시간초과네
 * 이걸 해결하려면 어떻게 해야할까. 단순히 생각나는건 음....dp가 생각나긴함
 *
 * dp로 {n,값} 을 저장해서 나오면 바로 뱉을 수 있게하는게 좋지 않을까
 * 그럼 어쨌든 재탐색 비용이 사라지니까
 * 와 이건 좀 놀랍네 이래도 시간초과라고?
 *
 * 알고리즘 분류가 정렬이래
 * 정렬로 풀면...미리 배열을 정렬해두고 본인보다 작은 값이 나올때까지만 순회한다라는 아이디어인가
 * 미리 모든 애들에 대한 랭크를 다 매겨두고 보낸다 사실 dp와 비슷한 개념인데...
 * */
public class b18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        ArrayList<Integer> sorted = new ArrayList<>();
        Map<Integer,Integer> rank = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
            if (!sorted.contains(input[i])) sorted.add(input[i]);
        }

        Collections.sort(sorted);
        for (int i=0; i<sorted.size(); i++){
            rank.put(sorted.get(i),i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            sb.append(rank.get(input[i])).append(" ");
        }

        System.out.print(sb);
    }

}
