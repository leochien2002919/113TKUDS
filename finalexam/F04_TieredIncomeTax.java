import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] incomes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
        }

        int totalTax = 0;
        for (int i = 0; i < n; i++) {
            int tax = calculateTax(incomes[i]);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        int avg = totalTax / n;
        System.out.println("Average: $" + avg);
    }

    public static int calculateTax(int income) {
        int[] brackets = {560000, 1260000, 2520000, 4720000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        int[] baseTax = {0, 28000, 134000, 376000, 829600};

        if (income <= brackets[0]) {
            return (int)(income * rates[0]);
        } else if (income <= brackets[1]) {
            return baseTax[1] + (int)((income - brackets[0]) * rates[1]);
        } else if (income <= brackets[2]) {
            return baseTax[2] + (int)((income - brackets[1]) * rates[2]);
        } else if (income <= brackets[3]) {
            return baseTax[3] + (int)((income - brackets[2]) * rates[3]);
        } else {
            return baseTax[4] + (int)((income - brackets[3]) * rates[4]);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 對 n 筆收入執行一次稅額計算，整體時間複雜度為 O(n)。
 */
