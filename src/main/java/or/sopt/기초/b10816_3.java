package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * n개의 수에 대해서 m의 숫자가 주어질때
 * 각 m의 숫자를 몇개 가지고 있는지 출력하라
 *
 * 딱봐도 그냥 탐색하면 시간초과 난다.
 * 그럼 HashMap? 아니지 HashMap은 여러개를 탐색하지 못한다. 같은 문자는 같은 hash값을 갖게 되기 때문
 * 그러면 key에는 값을 넣고 value에 인덱스를 추가한다는 아이디어는?
 * 이건 ㄱㅊ은거같은데
 *
 * 그럼 이걸 이분탐색으로 풀어야한다?
 * */
public class b10816_3 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (!map.containsKey(temp)){
                sb.append(0).append(" ");
            }else{
                sb.append(map.get(temp)).append(" ");
            }
        }

        System.out.print(sb);
    }
}
