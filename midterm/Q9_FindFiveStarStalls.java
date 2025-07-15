import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] == 5) count++;
        }

        if (count == 0) {
            System.out.println("None");
        } else {
            int[] idx = new int[count];
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5) {
                    idx[j++] = i;
                }
            }
            for (int i = 0; i < count; i++) {
                System.out.print(idx[i]);
                if (i < count - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}