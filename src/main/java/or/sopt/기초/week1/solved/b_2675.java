package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

public class b_2675{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = Integer.parseInt(br.readLine());
        for (int k=0; k<temp; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(st.nextToken());
            String input = st.nextToken();

            for (int i=0; i<input.length(); i++){
                char c = input.charAt(i);

                for (int j=0; j<n; j++){
                    sb.append(c);
                }
            }

            System.out.print(sb);

        }


    }
}