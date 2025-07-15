// * Time Complexity : O(n)
// * Space Complexity: O(n)

import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ps = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int result = sc.nextInt();
            ps[i] = ps[i - 1] + result;
        }

        int k = sc.nextInt();
        sc.close();

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}