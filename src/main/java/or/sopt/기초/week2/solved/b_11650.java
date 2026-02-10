package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

public class b_11650 {

    static class Pos{
        int x;
        int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Pos p = new Pos(x,y);
            arr[i] = p;
        }


        Arrays.sort(arr,new Comparator<Pos>(){
            @Override
            public int compare(Pos p1, Pos p2){
                if (p1.x==p2.x){
                    // 둘이 같으면 y가 증가하는순
                    return p1.y-p2.y;
                }

                return p1.x-p2.x;
            }
        });

        for (int i=0; i<n; i++){
            Pos p = arr[i];
            System.out.println(p.x+" "+p.y);
        }
    }
}
