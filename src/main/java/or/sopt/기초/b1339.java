package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1339 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] alpha = new String[n];

        int max = 0;
        for (int i=0; i<n; i++){
            alpha[i] = br.readLine();
            max = Math.max(alpha[i].length(), max);
        }

        Map<Character, Integer> map = new HashMap<>();
        int num = 9;
        for (int i=0; i<max; i++){
            for (String var: alpha){

                // ㅁㅏㄴ약 var<i 라면 continue
                if (var.length()<=i) continue;

                /**
                 * charAt(i)가 Map에 존재한다면 skip
                 * 존재하지 않는다면 num--
                 *
                 * 아 근데 이게 문제가
                 * 2
                 * GCF
                 * ACDEB
                 * 입력값이 이거일때 i=0부터 max까지하면 내 의도대로면 AC가 남아야하는데, EB가 남아버리네
                 * 그러면
                 * */
                char c = var.charAt(i);
                if (map.containsKey(c)){
                    continue;
                }else{
                    map.put(c,num);
                    num--;
                }
            }
        }

        int result = 0;
        for (String var: alpha){

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<var.length(); i++){
                sb.append(map.get(var.charAt(i)));
            }

            result += Integer.parseInt(sb.toString());
        }

        System.out.print(result);
    }
}
