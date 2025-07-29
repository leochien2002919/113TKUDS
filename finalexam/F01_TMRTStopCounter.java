import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIndex = i;
            }
            if (stops[i].equals(end)) {
                endIndex = i;
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIndex - startIndex) + 1);
        }
    }
}

/* 
 * Time Complexity: O(n)
 * 只對輸入的 n 個站點進行一次掃描以找出 start 與 end 的位置，時間複雜度為 O(n)。
 */
