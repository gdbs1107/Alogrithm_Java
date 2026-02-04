package or.sopt.기초.week1.solved;

import java.io.*;

public class b_1152 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int cnt = 0;

        for (int i=0; i<input.length(); i++){
            if (input.charAt(i) == ' '){

                if (i == 0){
                    continue;
                }
                if (i==input.length()-1){
                    continue;
                }

                cnt++;
            }
        }

    }
}
