package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b3273 {

    /**
     * 두 개의 수를 뽑아서 X를 만들 수 있어야한다
     * 그럼 두 개의 수를 얼마나 효율적이게 뽑을 수 있을까가 주된 관심사일거고
     * 그러면 하나를 고르고 그 뒤를 모두 테스트하고...
     * 뭐 이런식으로 이중 반복으로 원시적으로 할 수 있을 것 같은데 무조건 시간초과일텐데
     *
     * 역시 시간초과. 그러면 어떻게 할 ㅜㅅ 있을까...
     * 뮤조건 똘똘한 방법이 있을 것 같아서 찾아보자
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n-1;
        Arrays.sort(num);

        while (start<end){
            int temp = num[start] + num[end];
            // temp가 x보다 작다면 숫자를 키워야한다 -> start+1
            if (temp<x) start++;
            else if (temp>x) end--;
            else {
                count++;
                start++;
                end--;
            }
        }

        System.out.print(count);
    }


}
