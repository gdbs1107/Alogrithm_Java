package or.sopt.기초.week1.solved;

import java.io.*;

// replace()를 이용하여 해당 문자열을 모두 A로 바꾼후 A의 개수를 세어버린 문제...
public class b_2941_replace {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] croatiaAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for(String val : croatiaAlphabet) {
            s = s.replace(val, "A");
        }
        System.out.println(s.length());
    }
}
