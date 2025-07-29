import java.util.*;

public class F02_YouBikeNextFull {
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static String minutesToTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = timeToMinutes(sc.nextLine());
        }

        int query = timeToMinutes(sc.nextLine());

        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ans = times[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(minutesToTime(ans));
        }
    }
}

/* 
 * Time Complexity: O(log n)
 * 用二分搜尋找出第一個晚於查詢時間的時刻，時間複雜度為 O(log n)。
 */
