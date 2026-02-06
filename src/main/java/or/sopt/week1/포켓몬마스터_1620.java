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
        List<String> result = new ArrayList<>();


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

        System.out.println(Arrays.toString(names));


        // 문제에 대한 답을 출력한다
        /**
         * M개의 문제를 돌면서 답을 확인해야한다
         * 우선 숫자일때와, 이름일때의 케이스가 분기되어야함
         *
         * 숫자일때
         * 인덱스를 통해 바로 답을 결과 배열에 추가한다
         * 첫글자는 무조건 대문자니까 65~90
         *
         * 이름일때
         * 배열을 순회하며 같은 이름을 찾는다
         * */
        for (int k=1; k<M+1; k++){

            // 숫자일때
            if (65 > problems[k].charAt(0) && 90 > problems[k].charAt(0)){
                result.add(names[Integer.parseInt(problems[k])]);

                System.out.println(result);

            } else{
                for (int h=1; h<N+1; h++){

                    if(names[h].equals(problems[k+1])){
                        result.add(String.valueOf(h));

                        System.out.println(result);
                    }
                }
            }

        }

        for (int g=0; g<5; g++){
            System.out.println(result.get(g));
        }

    }
}
