package or.sopt.기초;

import java.util.*;
import java.io.*;

public class b1764_hash {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> listen = new HashMap<>();
        for (int i = 0; i < n; i++) listen.put(br.readLine(), i);

        Map<String, Integer> see = new HashMap<>();
        for (int i = 0; i < m; i++) see.put(br.readLine(), i);

        List<String> ans = new ArrayList<>();
        for (String name : listen.keySet()) {
            if (see.containsKey(name)) ans.add(name);
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (String s : ans) sb.append(s).append('\n');
        System.out.print(sb);
    }
}
