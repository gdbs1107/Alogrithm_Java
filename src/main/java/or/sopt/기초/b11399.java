package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b11399 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        int temp = 0;
        for (int i=0; i<n; i++){

            temp += arr[i];
            /**
             * 1,2,3 이라고 가정해보면
             * result 는 1분+3분+6분이 걸려서 총 10분이 걸려야함
             * 저 점화식에 넣어보면
             *
             * 0=0+0+1
             * 1=1+1+2
             * 4=4+4+6 -> 14가 결국 나오네요
             *
             * 점화식이 틀렸다는거임
             * result = result + temp
             * temp = temp+arr[i]
             * */
            result = result + temp;
        }

        System.out.print(result);
    }
}
