package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b7795 {

    /**
     * b를 정렬한다
     * 그리고 투포인터를 쓸 수도 있는데, 그냥 이분탐색 같아지긴 하겠는데?
     *
     * 이분탐색으로 Upper-Lower 의 값이 되겠다.
     * 그럼 tc별로
     * 배열 a는 target 모음
     * 배열 b는 대상값들의 ㅇ모음
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a =new int[n];
            int[] b =new int[m];

            int result = 0;

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            for (int j=0; j<n; j++){
                int target = a[j];
                int l = lower(b, target);

                result += (l);
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }


    // upper니까 mid==target일때 low=mid+1이 되어야함
    static int upper(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int lower (int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
