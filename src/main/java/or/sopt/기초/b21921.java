package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b21921 {

    /**
     * 이것도 n까지의 순회를 돈다
     * 근데 M까지의 합이 시작되는 순간 슬라이딩 윈도우를 진행한다
     *
     * n이 1인경우가 커버가 안돼서 틀렸나
     * n이 1인 경우는 그날이 최대니까 바로 출력하면 되잖아
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;
        int count=0;

        for (int i=0; i<n; i++){
            sum += num[i];

            // m-1과 같아야함
            if (i==m-1){
                max = sum;
                count = 1;
            }

            if (i>=m) {
                sum -= num[i-m];
                if (sum>max){
                    count = 1;
                    max = sum;
                }else if (max==sum){
                    count++;
                }
            }
        }

        if (max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
