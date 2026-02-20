package or.sopt.기초;
import java.util.*;
import java.io.*;
public class b_2457 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i=0; i<5; i++){
            int temp = Integer.parseInt(st.nextToken());
            temp = temp*temp;
            sum += temp;
        }

        System.out.print(sum&10);
    }
}
