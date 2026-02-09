package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

public class b_1181 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        // 50개의 리스트를 만든다
        for (int i=0; i<50; i++){
            list.add(new ArrayList<String>());
        }

        // 글자의 길이를 세서 그 길이에 있는 리스트에 단어를 넣는다
        for (int i=0; i<n; i++){
            String input = br.readLine();
            int len = input.length();

            // 중복제거
            if (list.get(len).contains(input)){
                continue;
            }

            list.get(len).add(input);
        }

        // 모든 리스트를 정렬한다
        for (int i=0; i<50; i++){
            Collections.sort(list.get(i));
        }

        for (int i=0; i<50; i++){
            ArrayList<String> temp = list.get(i);
            for (int j=0; j<temp.size(); j++){
                System.out.println(list.get(i).get(j));
            }
        }
    }
}
