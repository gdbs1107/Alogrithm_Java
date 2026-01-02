package or.sopt.week1;

import java.util.*;
import java.io.*;


public class 패션왕_2트_9375 {

    /**
     * 결국 하나의 옷 카테고리 하위에 몇개의 옷이 존재하는지가 포인트인거임
     * -> 결국결국 Map의 내부 메서드인 containsKey()를 활용해야함
     *
     * 옷을 입을 수 있는 경우의 수는 옷의 개수+(각 경우의 수*각 경우의 수)
     * */

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){

            int result=1;
            int M = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j=0; j<M; j++){

                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();

                // 이미 존재하면 기존의 카테고리에 +1을 한다
                if (map.containsKey(category)){
                    map.put(category,map.get(category)+1);
                }else {

                    // 존재하지 않던 카테고리라면 1을 넣는다
                    map.put(category,1);
                }
            }

            for (int val:map.values()){
                result *= (val+1);
            }

            result = result -1;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

}
