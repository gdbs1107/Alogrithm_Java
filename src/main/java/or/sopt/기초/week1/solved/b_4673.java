package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

// 딱 본인 직전의 한 번만 체크하면 된다 -> 범위를 반드시 체크하라
public class b_4673 {
    static boolean[] arr = new boolean[10001];
    static int n = 10000;

    public static void main(String[] args) throws IOException{

        // 다 돌면서 본인이 생성할 수 있는 d(n)을 체크함
        for (int i=0; i<n; i++){
            cal(i);
        }

        for (int i=0; i<n; i++){
            if (!arr[i]) System.out.println(i);
        }

    }

    static void cal(int in){
        ArrayList<Integer> list = new ArrayList<>();
        int result = in;

        // 각 자릿수를 리스트에 넣음
        String input = String.valueOf(in);
        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            list.add(Integer.parseInt(String.valueOf(c)));
        }

        // 리스트에서 각 자릿수를 result에 더함
        for (int i=0; i<list.size(); i++){
            result += list.get(i);
        }

        if (result>n) return;
        // result값을 방문처리
        if (!arr[result]) arr[result]=true;
    }
}
