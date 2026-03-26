package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2343 {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int high = 0;
        int low = 0;

        st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
            low = Math.max(low, arr[i]);
        }

        while (low<high){
            int mid = (low+high)/2;
            int count = 1;

            int temp=0;
            for (int i = 0; i < n; i++) {

                // temp+그 다음 영상이 들어왔을때 mid보다 크다면 블루레이 분리해야함
                if (temp + arr[i] > mid) {
                    count++;
                    temp = arr[i];
                } else {

                    // 그게 아니면 그냥 더하기
                    temp += arr[i];
                }
            }

            if (count<=m){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        System.out.print(low);
    }

}
