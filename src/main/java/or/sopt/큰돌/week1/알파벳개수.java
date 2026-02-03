package or.sopt.큰돌.week1;

import java.io.*;
import java.util.*;

public class 알파벳개수{


    /**
     * String 기반의 counting 이 필요할때는 Map을 이용하고
     * Integer 기반의 counting 이 필요할때는 Array를 이용하자
     *
     * 아스키코드 065가 A이다.
     * 그 다음부터는 알아서 셀 수 있지?
     * */
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];

        // 0~25 의 인덱스를 가지는 배열을 만들었음
        for(int i=0;i<26;i++){
            alphabet[i]=0;
        }

        // 인덱스의 문자열을 가져와서 96을 뺀다 -> 그러면 만약 a라면 96-96=0 이므로 첫번째 인덱스가 됨
        // a 97임 병2신아
        for (int i=0; i<input.length();i++){
            char target = input.charAt(i);
            alphabet[target-'a']++;
        }

        print(alphabet);
    }


    private static void print(int[] alphabet){
        for (int i = 0; i < alphabet.length; i++){
            System.out.print(alphabet[i]+" ");
        }
    }
}