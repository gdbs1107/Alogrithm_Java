package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b7662 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> q = new LinkedList<>();

            for (int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String method = st.nextToken();
                int tar = Integer.parseInt(st.nextToken());

                // I면 insert
                if (method.equals("I")){

                    // peek보다 작으면 앞에 넣기
                    if (q.isEmpty() || q.peek()<=tar) q.add(tar);
                    else q.addFirst(tar);

                }else if(method.equals("D")){
                    // D면 삭제
                    if (q.isEmpty()) continue;
                    if (tar==1) q.pollLast();
                    else q.poll();
                }
            }

            if (q.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(q.pollLast()+" "+q.poll());
            }
        }
    }
}
