package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 단순 반복하면 시간초과 발생함
 * 그러니까 해결방법이 뭐냐면 -> Hash 탐색을 하는게 베스트임
 * 그냥 num을 Map으로 만드는거지
 * */
public class b1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> num = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num.put(Integer.parseInt(st.nextToken()),i);
        }

        int m = Integer.parseInt(br.readLine());
        int[] tar = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            tar[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++){
            if (num.containsKey(tar[i])){
                System.out.println(1);
                continue;
            }else{
                System.out.println(0);
            }
        }
    }
}
