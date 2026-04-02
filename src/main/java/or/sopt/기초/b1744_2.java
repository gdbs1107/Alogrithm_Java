/*
package or.sopt.기초;

import java.io.*;
import java.util.*;

public class b1744_2 {

    */
/**
     * 우선 배열을 정렬하고
     * 양수 배열은 그냥 뒤에서부터 다 두개씩 곱해서 result에 더하고
     * 음수도 그냥 두개씩 곱해서 더하는거지
     *
     * 그럼 어떻게 할 수 있을까
     * 숫자를 받을때 양수면 양수배열에
     * 음수면 음수배열에 받고
     *
     * for (int i=p.length; i>=0; i--){
     *
     *      if (i==0) result += arr[i];
     *      break;
     *
     *     int now = i;
     *     int next = i-1;
     *
     *     if (next==0){
     *         result+=arr[i];
     *         i--;
     *         continue;
     *     }
     *
     *     result += (arr[now]*arr[next]);
     *     // i를 두개 건너뛰어야하니까 한 번 더 --해주기
     *     i--;
     * }
     *
     * 아 근데 양수음수 배열을 만들기보단 그냥 하나의 배열에서 관리하는게 낫겠는데,
     * 0이면 건너 뛰어버리고 그냥
     * 근데 음수는 앞에서부터 곱해야하는데...
     *
     * 아니면 리스트로 두고 써야하나
     * int[] temp = new int[2];
     * for (int var: plus){
     *
     *      if (var==0) {
     *          continue;
     *      }
     *
     *     if (temp[0]==0) {
     *         temp[0] = var;
     *     }else if (temp[1]==0){
     *         temp[1] = var;
     *     }else{
     *         result += temp[0]*temp[1];
     *         temp[0] = 0;
     *         temp[1] = 0;
     *     }
     * }
     * *//*

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for (int i=0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            if (temp>=0) plus.add(temp);
            else minus.add(minus);
        }

        Collections.sort(plus);
        Collections.sort(minus);
        int result = 0;
        int[] temp = new int[2];

        for (int var: plus){
            if (var==0) continue;

            if (temp[0]==0){
                temp[0] = var;
            }else if (temp[1]==0){
                temp[1] = var;
            }else {
                result += temp[1]*temp[2];
                temp[0] = 0;
                temp[1] = 0;
            }
        }
    }
}
*/
