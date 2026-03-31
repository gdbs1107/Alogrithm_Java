package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 이걸 만약에 그리디로 풀어야한다면, 내가 생각한 로직이 정답이 되어야한다는 것인가?
 * 그러면... 저 값이 최소가 되는 경우 무조건 "- 뒤를 최대한 크게 만들어야한다?"
 *
 * -가 나오고 그 뒤가 또 -가 나오기 전까지의 수를 모두 묶어버리면 가장 작은 값이 나오지 않을까?
 * 그럼 일단 String으로 입력값을 받아
 *
 * 숫자배열과 연산자 배열을 묶는다? 이렇게 하면 뭘 어떻게 해
 * 아니면 map으로 value를 저장하고 인덱스와 값을 묶는다?
 *
 * 아 접근도 못하겠음
 *
 * ------
 *
 * ㅇㅏ이디어는 맞았음
 * -로 묶인 데이터들을 모두 더해서 각각 빼면 되는거임
 * 그리고 -로 묶인 애들을 묶어서 다 더함
 * */
public class b1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;

        // hasMoreTokens(): 해당 ㅌ크나이저가 변수를 ㅏㄱ지고 있는지를 반환하는 메서드
        while (st.hasMoreTokens()){
            // -를 기준으로 파싱한 값을 지속적으로 반환해야함
            int temp = 0;
            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
            while (add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if (sum==Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -=   temp;
            }
        }

        System.out.print(sum);
    }
}
