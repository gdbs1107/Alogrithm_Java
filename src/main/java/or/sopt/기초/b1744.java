package or.sopt.기초;

import java.io.*;
import java.util.*;

/**
 * 음수 배열
 * 양수 배열
 *
 * 아 정렬을 할 수가 없구나
 * 왠만하면 무조건 묶는게 값이 큰거 아닌가? 피해야하는 경우가
 * 1. 0은 묶으면 안됨
 * 2. 음수 한개만 있을땐 묶으면 안됨
 *
 * 음수가 뽀인트인 것 같은데
 * 두개씩 묶어서 더하다가
 * 1. 음수를 만남 -> 뒤가 음수면 뒤랑 묶고
 * 1-1. 뒤가 양수면 그냥 묶고
 *
 * 두 수를 더하는 로직은 어ㅓㄸㅎ게 짤까
 * for (1~n){
 *      0이면 continue
 *
 *     int now = 하나의 수를 고른다
 *     int next = 그 다음 수를 본다
 *
 *     if (now<0) {
 *         다음 수를 확인한다
 *         if (next<0) 일반적인 로직 실행
 *         else continue
 *     }
 *
 *     result += (now+next);
 *     i++;
 * }
 *
 *
 * 아 아니 위치에 상관잉 ㅓㅂㅅ네 ㅆㅂ
 * */
public class b1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        // 앞에서부터 쭉 묶어나가야하는데 이때 0이면 skip
        int result = 0;
        for (int i=0; i<n-1; i++){

            if (i==n-1){
                result += num[n-1];
                break;
            }

            int now = num[i];
            int next = num[i+1];

            if (now==0) continue;
            if (now<0 || next<0){
                if (next<0 && now<0){
                    // next가 반영되었기 때문에 i에 1을 하나 더 더해준다
                    result += (now*next);
                    i++;
                    continue;
                }
                else {
                    result += now;
                    continue;
                }
            }


            result += (now*next);
            i++;
        }



        System.out.print(result);
    }
}
