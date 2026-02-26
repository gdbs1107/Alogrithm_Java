package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b10816 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> N = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            N.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        int[] M = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            M[i] = Integer.parseInt(st.nextToken());
        }

        // m을 돌면서 m의 숫자가 N에 있는지 찾는다
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            int cnt = 0;
            for (int temp : N){

                // 해당 원소가 포함되어 있지 않으면 바로 continue
                if (!N.contains(M[i])){
                    continue;
                }

                // 리스트에서 같은걸 찾으면 cnt를 올리고 해당 원소 삭제
                if (temp==M[i]){
                    cnt++;
                }
            }

            sb.append(cnt).append(" ");
        }

        System.out.print(sb);
    }
}
