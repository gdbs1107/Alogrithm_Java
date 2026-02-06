package or.sopt.기초.week1.solved;

import java.io.*;

public class b_1475{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 9를 모두 6으로 바꾼다 -> replace는 리턴값이 있다
        input = input.replace('9','6');

        // 배열을 만드는데 배열은 1~8까지만 있으면 됨
        int[] arr = new int[9];

        for (int i=0; i<input.length(); i++){
            int n = Integer.parseInt(input.charAt(i)+"");
            arr[n]++;
        }

        int res = 0;
        int flag = 0;
        for (int i=0; i<arr.length; i++){

            // 만약 res가 arr[i]보다 크다면 -> res 값을 갱신하고 i 인덱스를 저장
            // 왜 배열의 length는 함수형이 아닐까? length는 JVM 내부적으로 다루는 필드임 그래서. legth하는거임
            if (res<arr[i]){
                if (i==6) continue;
                res = arr[i];
                flag = i;
            }
        }

        int six = (arr[6]+1)/2;
        System.out.print(Math.max(six,res));
    }

}