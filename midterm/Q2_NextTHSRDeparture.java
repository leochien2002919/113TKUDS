 //* Time Complexity : O(log n)
 //* Space Complexity: O(n)

public class Q2_NextTHSRDeparture {

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min  = Integer.parseInt(parts[1]);
        return hour * 60 + min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] timeStrs = new String[n];
        int[] timeMins = new int[n];

        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.nextLine();
            timeMins[i] = toMinutes(timeStrs[i]);
        }

        String queryStr = sc.nextLine();
        int queryMin = toMinutes(queryStr);

        sc.close();

        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (timeMins[mid] > queryMin) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrs[left]);
        }
    }
}