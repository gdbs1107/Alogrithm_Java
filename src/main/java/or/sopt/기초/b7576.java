package or.sopt.기초;

import java.util.*;
import java.io.*;

/**
 * depth를 구하는 문제인데, 토마토가 사방향에 있는 토마토를 1로 만든다
 * 그러면 dfs인 것 같긴한데
 *
 * 1인 지점부터 시작해서 어느곳도 갈 수 없게 될 때까지의 depth를 구하고
 * 근데 최솟값을 구해야하는거니까 머리가 좀 아프긴하네
 * depth를 파라미터로 갖고가서 결국 어디도 갈 수 없게 되었을 때를 가정해야하는건데...그러면 각자의 map을 지녀야하니까 그건 아니고
 *
 * 일단 일반적인 bfs아님 근데? 어찌보면 최단거리 문제긴 함.
 * 가는 블록이 1이라면 그냥 감
 * 0이면 1로 만들고 감
 * -1이면 안감
 *
 * 아니지 그냥 depth만 가져가면
 * */
public class b7576 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

}
