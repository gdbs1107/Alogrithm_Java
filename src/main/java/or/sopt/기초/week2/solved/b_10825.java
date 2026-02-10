package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

public class b_10825{

    public static class Person{
        String name;
        int korean;
        int english;
        int math;

        Person(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Person p = new Person(name, korean, english, math);

            arr[i] = p;
        }

        /**
         * compareTo 메서드는 뭘까?
         *
         * 내가 직접 구현하려한 이름의 사전순을 비교해주는 String의 내부 메서드임
         * */
        Arrays.sort(arr, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                if (p1.korean == p2.korean){
                    // 영어는 오름차순
                    if (p1.english == p2.english){
                        // 수학은 내림차순
                        if (p1.math == p2.math){
                            return p1.name.compareTo(p2.name);
                        }
                        return p2.math - p1.math;
                    }
                    return p1.english - p2.english;
                }
                // 국어는 내림차순
                return p2.korean - p1.korean;
            }
        });

        for (int i=0; i<n; i++){
            Person p = arr[i];
            System.out.println(p.name);
        }

    }
}