package or.sopt.큰돌.week3.문제;

import java.io.*;
import java.util.*;


/**
 * 백트래킹이 뭐냐면 ->
 * 1. 특정 A선택을 하고 재귀
 * 2. 다시 돌아와서 다른선택하고 끝까지 정상적으로 재귀
 * 3. 이걸 모든 경우의 수에서 재귀하는 로직인거임
 * */
// 아예 아이디어도 떠오르지 않았음 백트래킹+dfs
public class b_F_16637 {

    static int ans;
    static ArrayList<Character> ops;
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        ops = new ArrayList<>();
        nums = new ArrayList<>();

        // ops와 ans를 서로 다른 리스트에 저장합니다
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                continue;
            }
            nums.add(Character.getNumericValue(c));
        }

        ans = Integer.MIN_VALUE;
        // 0번 숫자와 연산자부터 로직 시작
        DFS(nums.get(0), 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 연산
    public static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }

    // DFS, 백트래킹 활용.
    public static void DFS(int result, int opIdx) {
        // 주어진 연산자의 개수를 초과하였을 경우.
        if (opIdx >= ops.size()) {
            ans = Math.max(ans, result);
            return;
        }

        // 괄호가 없는 경우: 이전까지 계산한 값과 연산자, 그리고 그 뒤의 값을 연산합니다
        int res1 = calc(ops.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);

        // 이게 실행되는 때는 위의 로직이 끝까지 실행되고 조건에 걸렸을때 멈추는거임ㅌ₩
        // 괄호가 있는 경우
        if (opIdx + 1 < ops.size()) {
            // result의 오른쪽에 있는 값을 연산함.
            int res2 = calc(ops.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));

            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            DFS(calc(ops.get(opIdx), result, res2), opIdx + 2);
        }
    }

}
