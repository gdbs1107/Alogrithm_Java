package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b7662_2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> min = new PriorityQueue<>();
            Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer,Integer> map = new HashMap<>();

            for (int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String method = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // map에 num을 넣는다
                if (method.equals("I")){
                    if (map.containsKey(num)){
                        map.put(num,map.get(num)+1);
                    }else{
                        map.put(num,0);
                    }
                    max.offer(num);
                    min.offer(num);
                }

                // map에서 num을 뺸다
                if (method.equals("D")){

                    if(map.isEmpty()) continue;
                    if (num==1) {
                        // max에서 숫자를 제거한다
                        int temp = max.poll();
                        map.put(temp, map.get(temp) - 1);
                    }else{
                        // max에서 숫자를 제거한다
                        int temp = min.poll();
                        map.put(temp, map.get(temp) - 1);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (map.isEmpty()) System.out.println("EMPTY");
            else {
                sb.append(max.poll()).append(" ").append(min.poll());
                System.out.println(sb);
            }
        }
    }
}
