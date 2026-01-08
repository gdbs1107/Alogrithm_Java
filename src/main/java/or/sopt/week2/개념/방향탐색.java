package or.sopt.week2.개념;

public class 방향탐색 {

    public static void main(String[] args) {

        int x =0;
        int y =0;

        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};

        for (int i=0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            System.out.print(nx+" ");
            System.out.println(ny);
        }


        int[] dy_8 = {-1,-1,1,1,1,0,1,0,-1};
        int[] dx_8 = {-1,1,1,-1,1,0,-1,0};

        System.out.println("8방향");

        for (int i=0; i<8; i++){
            int nx = x +dx_8[i];
            int ny = y +dy_8[i];

            System.out.print(nx+" ");
            System.out.println(ny);
        }
    }
}
