import java.util.*;

public class F06_ArraySecondLargest {
    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
    }

    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair p1 = findSecondMax(arr, left, mid);
        Pair p2 = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (p1.max > p2.max) {
            max = p1.max;
            second = Math.max(p1.second, p2.max);
        } else {
            max = p2.max;
            second = Math.max(p2.second, p1.max);
        }

        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 整個陣列透過分治法拆解與合併，每個元素只會參與一次，總共進行 n-1 次，整體時間複雜度為 O(n)。
 */
