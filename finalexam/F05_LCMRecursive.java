import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcdBySubtraction(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    public static int gcdBySubtraction(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdBySubtraction(a - b, b);
        else return gcdBySubtraction(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 輾轉相減法在最壞情況下每次只減 1，因此最多會呼叫 max(a, b) 次遞迴，時間複雜度為 O(max(a, b))。
 */
