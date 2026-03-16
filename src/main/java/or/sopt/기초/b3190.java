package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b3190 {

    static boolean flag = true;
    static int n;
    static ArrayList<int[]> apples;
    static String[] dir;
    static Queue<int[]> snake = new LinkedList<>();

    static int next_y;
    static int next_x;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());
        apples = new ArrayList<>();
        StringTokenizer st;
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y =Integer.parseInt(st.nextToken());
            int x =Integer.parseInt(st.nextToken());

            apples.add(new int[]{y,x});
        }
        dir = new String[]{"+x", "-y", "-x", "+y"};
        int cur_dir = 0;
        int result = 0;

        int tc = Integer.parseInt(br.readLine());
        for (int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            if (direction.equals("D")){
                cur_dir += 1;
                // 범위 처리
                if (cur_dir>3) cur_dir = 0;
            }else{
                cur_dir -= 1;
                // 범위 처리
                if (cur_dir<0) cur_dir = 3;
            }

            int temp = move(dir[cur_dir], result);
            if (!flag){
                result = temp;
                break;
            }

            result = temp;
        }

        System.out.print(result);

    }


    static int move(String dir, int depth){
        int[] now = snake.peek();
        int now_y = now[0];
        int now_x = now[1];

        if (dir.equals("+x")){
            next_y = now_y;
            next_x = next_x + 1;
        }else if (dir.equals("-y")){
            next_y = next_y - 1;
            next_x = now_x;
        }else if (dir.equals("-x")){
            next_y = now_y;
            next_x = next_x - 1;
        }else {
            next_y = next_y + 1;
            next_x = now_x;
        }

        // 벽에 닿는 경우: n이 벽의 length니까 n-1보다 큰 경우 -> 그냥 기존의 depth return하고 flag false
        if (next_y>n-1 || next_x>n-1){
            flag = false;
            return depth;
        }

        // 사과인 경우: queue에 다음 next 좌표 넣고 depth+1해서 return
        if (apples.contains(new int[]{next_y, next_x})){
            snake.offer(new int[]{next_y, next_x});
            return depth+1;
        }

        // 본인 몸인 경우 depth 그대로 리턴
        if (snake.contains(new int[]{next_y, next_x})){
            flag = false;
            return depth;
        }

        // 아무것도 해당되지 않는 경우 큐에서 하나 빼고 새로운거 넣기
        snake.poll();
        snake.offer(new int[]{next_y, next_x});
        return depth+1;
    }
}
