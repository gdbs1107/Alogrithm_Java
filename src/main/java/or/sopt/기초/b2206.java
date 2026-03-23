package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * (1,1) 에서 시작함 -> 맵을 +1씩 만들고, 탐색범위도 >1이 되어야함
 * 1은 벽이고, 0은 갈 수 있는 곳이라 0을 따라가는 (N,M)까지 가는 최단거리를 찾는거임
 *
 * ㅈㄴ 쉬운거 아니야? 일반적인 bfs인데
 * 원래는 최단 경로할때 map에 있는 값을 갱신하며 앞으로 나갔는데 얘는 그렇게는 못하겠네
 * 그럼 또 다른 map을 만들어서 계산용으로 쓴다면?
 *
 * 1. map
 * 2. calc
 * 3. min
 * 4. n
 * 5. m
 * 6. dx,dy
 * 7. visited
 *
 * 아 와 벽을 부술 수 있다고... 하나까지는....이걸 몰랐네 어쩐지 너무 쉽더라
 * 그러면 와 이건 브루트포스로 가야하나
 *
 * 벽을 만났을때의 상황은 아래와 같은거지
 * 1. 벽을 한 번 부쉈는데 벽을 만남 -> 걍 끝
 * 2. 벽을 안부쒔는데 벽을 만남 -> 벽을 부숨
 * */
public class b2206 {

    static int[][] map;
    static int[][] calc;
    static boolean[][] visited;

    static int n;
    static int m;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    static Queue<int[]> queue = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        calc = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i=1; i<=n; i++){
            String input = br.readLine();
            for (int j=1; j<=m; j++){
                map[n][m] = input.charAt(j-1);
            }
        }

        calc[1][1] = 1;
        queue.offer(new int[]{1,1});
        visited[1][1] = true;
        bfs();

        if (flag){
            System.out.print(calc[n][m]);
        }else{
            System.out.print(-1);
        }
    }

    static void bfs(){
        while (!queue.isEmpty()){

            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            System.out.println(y + " "+ x);

            for (int i=0; i<4; i++){
                int next_y = y+dy[i];
                int next_x = x+dx[i];

                // y가 1보다 작거나 x가 1보다 작으면 그러니까 0라인은 탐색할 필요가 없음
                // 현재 map은 [n+1][m+1]임. 그러니까 n,m까지 존재한다는거임
                // y가 n보다 크다면 자리를 벗어나는거라서 ArrayIndex를 넘어가는 예외가 발생함. 그러니까 이 조건은 맞는 조건인거고
                if (next_y<1 || next_x<1 || next_y>n || next_x>m) continue;
                if (!visited[next_y][next_x] && map[next_y][next_x]==0){

                    // 만약 다음 위치가 n,m이면 목표 인덱스에 값을 넣고 flag를 true 즉 탐색을 완료했다고 하고 return함
                    if (next_y==n && next_x==m){
                        calc[next_y][next_x] = calc[y][x]+1;
                        flag = true;
                        return;
                    }

                    queue.offer(new int[]{next_y,next_x});
                    visited[next_y][next_x] = true;
                    calc[next_y][next_x] = calc[y][x]+1;
                }
            }
        }
    }
}
