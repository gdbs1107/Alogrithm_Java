package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b2805 {

    static int[] tree;
    static int n;
    static long m;
    static int res;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        tree = new int[n];
        int max=0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i]>max){
                max = tree[i];
            }
        }
        search(0,max);
        System.out.print(res);


    }

    public static void search (int low, int high){

        if (low > high) return;

        long result = 0;
        int mid  = (low+high)/2;

        for (int len:tree){
            if (mid<len){
                result = result+(len-mid);
            }
        }

        /*if (result>m){
            search(mid+1,high);
        }
        if (result<m){
            search(low, mid-1);
        }
        if (result==m){
            res = mid;
        }*/

        if (result >= m) {
            res = mid;
            search(mid + 1, high);
        } else {
            search(low, mid - 1);
        }

    }

}
