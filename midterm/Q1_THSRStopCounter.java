 //* Time Complexity : O(n)
 //* Space Complexity: O(n)


import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        String start = sc.next();
        String end   = sc.next();
        sc.close();

        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end))   endIdx   = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
            return;
        }

        int stopCount = Math.abs(startIdx - endIdx) + 1;
        System.out.println(stopCount);
    }
}
