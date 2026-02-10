package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

// 자기보다 뒤에있는 애들을 카운팅한다는 개념에서 '순위'라는 개념으로 옮겨보자
// 시간초과나서 틀림


/**
 * 모든 배열의 요소를 다 돌면서 카운팅하는게 아닌,
 * 정렬로 빠르게 랭킹을 매기고 그 값을 가져오기만 하기 때문에 시간에 있어서 보다 효율적인 것 같다
 * */
public class b_18870_2 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] old = new int[n];
        int[] sorted = new int[n];
        Map<Integer,Integer> ranked = new HashMap<>();

        for (int i=0; i<n; i++){
            old[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int i=0; i<n; i++){
            if (!ranked.containsKey(sorted[i])){
                ranked.put(sorted[i],rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            sb.append(ranked.get(old[i])).append(" ");
        }

        System.out.print(sb);
    }
}