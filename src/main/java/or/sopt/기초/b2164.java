package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2164 {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            queue.offer(i+1);
        }

        while (true){

            // queue의 길이가 1이면 stop
            if (queue.size()==1) {
                System.out.print(queue.poll());
                break;
            }

            queue.poll();
            queue.offer(queue.poll());
        }
    }
}
