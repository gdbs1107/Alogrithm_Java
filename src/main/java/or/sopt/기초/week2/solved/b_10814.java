package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

public class b_10814{

    public static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;

        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person p = new Person(age,name);

            arr[i] = p;
        }

        Arrays.sort(arr, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){
                if (p1.age==p2.age){
                    return 0;
                }else{
                    return p1.age - p2.age;
                }
            }
        });

        for (int i=0; i<n; i++){
            Person p = arr[i];
            System.out.println(p.age + " " + p.name);
        }
    }
}