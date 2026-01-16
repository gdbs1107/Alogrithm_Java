package or.sopt.week2.문제;

import java.util.*;
import java.io.*;

public class 연구소_14502 {

    static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
    static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
    static int originalMap[][];
    static int n,m;
    static int maxSafeZone = Integer.MIN_VALUE; //최대값을 찾기 위한 최소값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    /**
     * map을 전부 탐색하며 벽을 하나씩 세우는데,
     * 이때 벽이 3개가 되면 bfs로직이 실행된다.
     *
     * 그러니까 결국
     * dfs - 벽세우기
     * bfs - 퍼진 바이러스 카운팅하기
     * 인거임
     *
     * 그리고 완료되면 원복한다
     * */
    static void dfs(int wallCnt) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCnt+1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        // 쭉 돌면서 바이러스가 있는 인덱스를 모두 arr에 넣음
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(originalMap[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        //원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int copyMap[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            // 배열의 clone()은 해당 배열을 그대로 복사함. 하지만 '얕은복사'임
            copyMap[i] = originalMap[i].clone();
        }

        //BFS 탐색 시작
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; // 현재 값
            int y = now.y; //

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                //연구소 범위 밖이 아니고 빈칸일 경우에만 바이러스를 퍼트린다.
                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(copyMap[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        //SafeZone 확인
        funcSafeZone(copyMap);
    }

    private static void funcSafeZone(int[][] copyMap) {
        int safeZone =0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    //Queue에 좌표값 x,y를 넣기 위함.
    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

