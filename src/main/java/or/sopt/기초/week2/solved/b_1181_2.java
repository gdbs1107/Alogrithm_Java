package or.sopt.기초.week2.solved;

import java.util.*;
import java.io.*;

// https://st-lab.tistory.com/112
public class b_1181_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        /**
         * sort(인자, 정렬방법)을 의미한다.
         *
         * 기본적인 compare 메서드는
         * 기본적으로 양수일경우 Arrays.sort()에서 정렬 알고리즘에 의해 위치를 바꾸고, 0 이나 음의 정수인 경우는 두 객체의 위치는 바뀌지 않는다.
         *
         * 예로들어 { 2, 1, 3 } 이라는 배열이 있고, public int compare(int a1, int a2) { return a1 - a2 } 가 있다고 가정해보자.
         * 그렇다면 맨 처음 a1 은 2 가 될테고, a2 는 1이 된다. 즉, 2 - 1 = 1 이므로 양수가 반환되기 때문에 a1 과 a2, 즉 2 와 1 의 위치가 서로 바뀌게 된다. 그러면 { 1, 2, 3 } 이 되겠다.
         *
         *
         *
         * 우린 다른 정렬방식을 사용해야하기 때문에 메서드를 오버라이딩 해줘야한다
         * 그걸 아래에 정의하면 됨
         *
         *
         * 1. 근데 저게 대체 무슨 문법일까?
         * 왜 new 메서드 뒤에 구현부가 붙는걸까 -> 어나니머스 클래스
         * 따로 클래스선언 -> 객체생성 및 호출 의 프로세스를 따라가지 않고
         * 직접 클래스선언 및 구현체 호출을 한 번에 할 수 있도록 구현하는거임
         *
         *
         * 2. 어떻게 Comparator 내부의 compare 메서드가 바로 호출 될 수 있는걸까?
         * 우선
         * Arrays.sort(T[] a, Comparator<? super T> c)
         * 이게 sort의 메서드 스펙임
         * 그러니까 두 번째 인자엔 Comparator가 들어가고 내부엔 제네릭 클래스를 명명해야함
         *
         *
         * 이게 sort 내부의 mergeSort 구현체임
         * 보면 c.compare를 호출하고 있는 것을 알 수 있다
         *
         * private static void mergeSort(Object[] src,
         *                                   Object[] dest,
         *                                   int low, int high, int off,
         *                                   Comparator c) {
         *         int length = high - low;
         *
         *         // Insertion sort on smallest arrays
         *         if (length < INSERTIONSORT_THRESHOLD) {
         *             for (int i=low; i<high; i++)
         *                 for (int j=i; j>low && c.compare(dest[j-1], dest[j])>0; j--)
         *                     swap(dest, j, j-1);
         *             return;
         *         }
         *
         *         // Recursively sort halves of dest into src
         *         int destLow  = low;
         *         int destHigh = high;
         *         low  += off;
         *         high += off;
         *         int mid = (low + high) >>> 1;
         *         mergeSort(dest, src, low, mid, -off, c);
         *         mergeSort(dest, src, mid, high, -off, c);
         *
         *         // If list is already sorted, just copy from src to dest.  This is an
         *         // optimization that results in faster sorts for nearly ordered lists.
         *         if (c.compare(src[mid-1], src[mid]) <= 0) {
         *            System.arraycopy(src, low, dest, destLow, length);
         *            return;
         *         }
         *
         *         // Merge sorted halves (now in src) into dest
         *         for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
         *             if (q >= high || p < mid && c.compare(src[p], src[q]) <= 0)
         *                 dest[i] = src[p++];
         *             else
         *                 dest[i] = src[q++];
         *         }
         *     }
         * */
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                // 단어 길이가 같을 경우
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                // 그 외의 경우
                else {
                    return s1.length() - s2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append('\n');

        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
