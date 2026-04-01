package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1026 {

    /**
     * 큰 수는 가장 작은 수와 붙어야함
     * 작은 수는 가장 큰 수와 붙어야하고
     *
     * 그럼 두 개를 역순으로 비교하면서 곱해서 나가는거 아니야?
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;

        for (int i =0; i<n; i++){
            sum += a[i]*b[(n-1)-i];
        }

        System.out.print(sum);
    }

}
