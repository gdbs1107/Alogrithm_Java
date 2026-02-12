package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

public class b_2789{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        String cam = "CAMBRIDGE";

        for (int i=0; i<cam.length(); i++){
            list.add(cam.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length(); i++){
            if (!list.contains(input.charAt(i))){
                System.out.print(input.charAt(i));
                sb.append(input.charAt(i));
            }
        }

        System.out.print(sb);
    }
}