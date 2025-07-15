// * Time Complexity : O(n)
// * Space Complexity: O(1)


public class Q4_TieredElectricBill {

    private static double calcCost(int kWh) {
        double cost = 0;

        if (kWh <= 120) {
            cost += kWh * 1.68;
        } else if (kWh <= 330) {
            cost += 120 * 1.68;
            cost += (kWh - 120) * 2.45;
        } else if (kWh <= 500) {
            cost += 120 * 1.68;
            cost += 210 * 2.45;
            cost += (kWh - 330) * 3.70;
        } else if (kWh <= 700) {
            cost += 120 * 1.68;
            cost += 210 * 2.45;
            cost += 170 * 3.70;
            cost += (kWh - 500) * 5.04;
        } else if (kWh <= 1000) {
            cost += 120 * 1.68;
            cost += 210 * 2.45;
            cost += 170 * 3.70;
            cost += 200 * 5.04;
            cost += (kWh - 700) * 6.24;
        } else { // >1000
            cost += 120 * 1.68;
            cost += 210 * 2.45;
            cost += 170 * 3.70;
            cost += 200 * 5.04;
            cost += 300 * 6.24;
            cost += (kWh - 1000) * 8.46;
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long total = 0;
        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = (int) Math.round(calcCost(kWh)); 
            total += bill;
            System.out.println("Bill: $" + bill);
        }
        sc.close();

        long average = Math.round(total / (double) n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);
    }
}