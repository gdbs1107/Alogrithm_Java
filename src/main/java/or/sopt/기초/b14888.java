package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b14888 {

    static ArrayList<Character> operator = new ArrayList<>();
    static int n;
    static int[] num;
    static Character[] arr;
    static boolean visited[];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자를 하나의 배열에 넣어야하는데 어떻게 넣을 수 있을까
        st = new StringTokenizer(br.readLine());
        int temp = 0;
        for (int i=0; i<4; i++){
            int op = Integer.parseInt(st.nextToken());
            temp += op;

            if (i==0){
                for (int j=0; j<op; j++) operator.add('+');
            }
            if (i==1){
                for (int j=0; j<op; j++) operator.add('-');
            }
            if (i==2){
                for (int j=0; j<op; j++) operator.add('*');
            }
            if (i==3){
                for (int j=0; j<op; j++) operator.add('/');
            }
        }

        arr = new Character[temp];
        visited = new boolean[temp];

        fun(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void fun(int depth){
        if (depth==operator.size()){
            int result = num[0];
            // 값을 쭉 계산하고
            for (int i=0; i<operator.size(); i++){
                if (arr[i]=='+') result += num[i+1];
                if (arr[i]=='-') result -= num[i+1];
                if (arr[i]=='*') result *= num[i+1];
                if (arr[i]=='/') result /= num[i+1];
            }

            // min, max 계산하고
            min = Math.min(min,result);
            max = Math.max(max,result);
            return;
        }

        for (int i=0; i<operator.size(); i++){

            if (!visited[i]){
                arr[depth] = operator.get(i);
                visited[i] = true;
                fun(depth+1);
                visited[i] = false;
            }
        }
    }
}
