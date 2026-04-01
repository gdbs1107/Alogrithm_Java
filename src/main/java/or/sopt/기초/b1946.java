package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자를 뽑는다
 * 말 좆같이 써놓은거 보소
 * 그러니까 본인보다 서류와 면접에서 더 잘본 사람이 있다면 붙이지 않겠다 라는거 아님?
 * 둘 중 하나라도 누군가보다 잘 봤다면 붙는다는 것이지
 *
 * 그냥 다 돌면서 본인보다 큰 사람있는지 확인하면 되는거 아니야?
 * 아니지 그러니까 "본인보다 서류도 높고 면접도 높은 사람이 있다면 떨어진다"
 *
 * ----
 *
 * 이 로직의 문제는 사실상 이중반복 풀스캔이라는 점이었고
 * 이를 해결하기 위해서 면접 점수의ㅊ 최솟값을 계속 업데이트하는 방법이 있었음
 *
 * 1등은 점검 할 필요가 없기 때문에 1등의 면접점수를 최소로 초기화하고
 * 이를 기반으로 계속 올려가는거임
 *
 * */
public class b1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++){
            int n = Integer.parseInt(br.readLine());
            // 서류/면접 점수
            int[][] mem = new int[n][2];

            for (int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                mem[j][0] = Integer.parseInt(st.nextToken());
                mem[j][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 점수를 기반으로 우선 정렬을 합니다
            Arrays.sort(mem, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            int res = 1;
            int min = mem[0][1];
            for (int j=1; j<n; j++){

                if (mem[j][1]<min){
                    res++;
                    min = mem[j][1];
                }

            }

            System.out.println(res);
        }
    }
}
