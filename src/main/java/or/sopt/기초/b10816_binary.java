package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b10816_binary {

    /**
     * 이분탐색은 어떻게 진행되는 거였지?
     *
     * low가 High보다 작을때를 기준으로 합니다.
     * 만약 우리가 정렬된 인덱스의 배열을 기준으로 원하는 값을 찾는 경우라고 생각을 해보면 아래의 코드가 나올 수 있습니다.
     *
     * while (low<=high) {
     *     int mid = (low+high)/2;
     *
     *     if (arr[mid]==target){
     *         return mid;
     *     }else if (arr[mid]>taget){
     *         // 타겟이 미드보다 아래에 있으니 high=mid-1이 되어야합니다
     *         high = mid-1;
     *     }else{
     *         // 타겟이 미드보다 위에 있으니 low=mid+1
     *         low = mid+1;
     *     }
     * }
     *
     * 그럼 이 수식을 참고했을때 우린 이 문제를 풀기 위해서 우선적으로 배열을 정렬하고
     * 각 값에 대한 이분탐색을 진행합니다.
     * 그러면 기본적으로 저 이분탐색은 lower로 시작하는 인덱스를 먼저 찾고, 그 인덱스를 갖는 개수를 찾아넣으면 되는 거 아니야?
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            int temp = Integer.parseInt(st.nextToken());
            int low = lowerBound (num,temp);
            int high = upperBound (num,temp);

            sb.append(high-low).append(" ");
        }

        System.out.print(sb);
    }


    static int lowerBound(int[] arr, int target){

        int high = arr.length;
        int low = 0;

        while (low<high){
            int mid = (high+low)/2;

            if (arr[mid]<target){
                low = mid+1;
            }else {
                high = mid;
            }
        }

        return low;
    }

    static int upperBound(int[] arr, int target){

        int high = arr.length;
        int low = 0;

        while (low<high){
            int mid = (high+low)/2;

            if (arr[mid]<=target){
                low = mid+1;
            }else {
                high = mid;
            }
        }

        return low;
    }
}
