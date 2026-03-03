package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11723 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;

        for (int i=0; i<n; i++){
            String input = br.readLine();

            // all이면 새로운 리스트 만들고 1~20으로 채우기
            if (input.contains("all")){
                list = new ArrayList<>();
                for (int j=0; j<20; j++){
                    list.add(j+1);
                }
            }

            // empty면 새로운 리스트 만들기
            if (input.contains("empty")){
                list = new ArrayList<>();
            }

            if (input.contains("add")){
                st = new StringTokenizer(input);
                st.nextToken();
                int temp = Integer.parseInt(st.nextToken());

                // temp가 없을때만 add하기
                if (!list.contains(temp)){
                    list.add(temp);
                }
            }


            // remove
            if (input.contains("remove")){
                st = new StringTokenizer(input);
                st.nextToken();
                int temp = Integer.parseInt(st.nextToken());

                // temp가 있으면 그냥 패스하기
                if (!list.contains(temp)){
                    continue;
                }

                // temp가 있다면 삭제: 근데 Integer로 교체
                list.remove(Integer.valueOf(temp));
            }


            // check
            if (input.contains("check")){
                st = new StringTokenizer(input);
                st.nextToken();
                int temp = Integer.parseInt(st.nextToken());

                // List에 temp가 ㅇ벗으면 0
                if (!list.contains(temp)){
                    System.out.println(0);
                }else {
                    System.out.println(1);
                }
            }


            //toggle
            if (input.contains("toggle")){
                st = new StringTokenizer(input);
                st.nextToken();
                int temp = Integer.parseInt(st.nextToken());

                // temp가 없으면 추가
                if (!list.contains(temp)){
                    list.add(temp);
                }else {
                    list.remove(Integer.valueOf(temp));
                }
            }
        }
    }

}
