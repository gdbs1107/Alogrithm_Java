package or.sopt.기초.week1.solved;

import java.util.*;
import java.io.*;

public class b_25206 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double point = 0.0;
        double gpa = 0.0;
        double result = 0f;

        for (int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String sub = st.nextToken();
            double temp_point = Double.parseDouble(st.nextToken());
            String temp_gpa = st.nextToken();

            if (temp_gpa.equals("P")) continue;
            point += temp_point;
            gpa += temp_point*cal(temp_gpa);
        }

        result = gpa/point;
        System.out.print(result);
    }


    static double cal(String input) {

        switch (input) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
