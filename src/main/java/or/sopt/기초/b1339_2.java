package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 빈도수를 알아야한다는게 뽀인트임
 * 자릿수를 저장하고 그 자릿수만큼 정렬해서 수를 부여한다
 * 그럼 우선 다 정렬하고, 모든 수를 돌아가면서 가중치를 더해간다: Map<Character, Integer>
 *
 * 그리고 가중치를 기준으로 정렬을 해야하는데 하.....Map 정렬은 좀 빡센데
 * 그럼 정렬을 어떻게 해야할까.......
 * 아니면 이중배열로 해볼까
 * alpha[a] = n 아니 걍 단일 배열로도 되겠는데?
 * */
public class b1339_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];
        String[] input = new String[n];
        for (int i=0; i<n; i++){
            String temp = br.readLine();
            input[i] = temp;
            // 만약 인풋이 ABCD면 A에 가중치 1000이 들어가야하고, 그러면 10*3이 되어야하고 그러면 length()-j-1
            for (int j=0; j<temp.length(); j++){
                alpha[temp.charAt(j)-'A'] += (int) Math.pow(10,temp.length()-j-1);
            }
        }

        // 지금 여기까지해서 alphabet을 숫자로 바꾸는 것까진 함
        Arrays.sort(alpha);
        int i=0;
        int num = 9;
        while (alpha[i]>0){
            alpha[i] = num;
            i++;
            num--;
        }

        int result = 0;
        // 이제 알파벳을 숫자로 바꿔야함
        for (String var: input){
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<var.length(); j++){
                char c = var.charAt(j);
                sb.append(alpha[c-'A']);
            }

            result += Integer.parseInt(sb.toString());
        }

        System.out.print(result);
    }
}
