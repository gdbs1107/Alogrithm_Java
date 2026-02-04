package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

// 아 지금 이건 크로아티아 글자만 센거고, 일반 알파벳 개수가 없네
// 심지어 알파벳의 종류인가봐 시~팔
public class b_2941 {

    static String[] words = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 배열을 만드는거지 boolean 배열
        boolean[] arr = new boolean[input.length()];
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<input.length()-1; i++){
            char a = input.charAt(i);
            char b = input.charAt(i+1);

            // n-1번째와 n번째 char를 조합해서 temp를 만들고 이걸 이용해서 words에 있는지 파악한다.
            String temp = ""+a+b;

            for (int k =0; k<words.length; k++){
                if (temp.equals(words[k]) && !list.contains(temp)){
                    cnt++;
                    arr[i] = true;
                    arr[i+1] = true;
                    list.add(temp);
                }

            }

        }

        for (int i=0; i<input.length()-2; i++){

            char a = input.charAt(i);
            char b = input.charAt(i+1);
            char c = input.charAt(i+2);

            // n-1번째와 n번째 char를 조합해서 temp를 만들고 이걸 이용해서 words에 있는지 파악한다.
            String temp = ""+a+b+c;

            if (temp.equals("dz=") && !list.contains(temp)) {
                cnt++;
                arr[i] = true;
                arr[i+1] = true;
                arr[i+2] = true;
                list.add(temp);
            }


        }

        for (int i=0; i<input.length(); i++){

            // 알파벳의 종류도 같으면 pass 인거임
            if (!arr[i] && !list.contains(String.valueOf(input.charAt(i)))) {
                cnt++;
                list.add(String.valueOf(input.charAt(i)));
            }
        }




        System.out.print(cnt);

    }

}
