package or.sopt.week1;

import java.util.*;
import java.io.*;

public class 포켓몬마스터_1620 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1번부터 N번까지의 포켓몬 이름을 받는다
        // 문제의 갯수 M을 받는다
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N+1];
        String[] problems = new String[M+1];


        // N개의 포켓몬을 입력받는다
        for (int i=1; i<N+1; i++){
            String name = br.readLine();
            names[i] = name;
        }


        // M개의 문제를 입력받는다
        for (int j=1; j<M+1; j++){
            String problem = br.readLine();
            problems[j] = problem;
        }


        // 문제에 대한 답을 출력한다


    }
}
