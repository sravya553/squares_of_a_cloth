import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] points = new int[n][2];
        HashSet<String> set = new HashSet<>();

        // Input
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            set.add(points[i][0] + "," + points[i][1]);
        }

        int minPointsNeeded = 3;

        // Try all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                // First square
                int x3 = x1 - dy;
                int y3 = y1 + dx;
                int x4 = x2 - dy;
                int y4 = y2 + dx;

                int count1 = 0;
                if (!set.contains(x3 + "," + y3)) count1++;
                if (!set.contains(x4 + "," + y4)) count1++;

                // Second square
                int x5 = x1 + dy;
                int y5 = y1 - dx;
                int x6 = x2 + dy;
                int y6 = y2 - dx;

                int count2 = 0;
                if (!set.contains(x5 + "," + y5)) count2++;
                if (!set.contains(x6 + "," + y6)) count2++;

                minPointsNeeded = Math.min(minPointsNeeded, Math.min(count1, count2));
            }
        }

        // Edge case
        if (n == 1) {
            System.out.println(3);
        } else {
            System.out.println(minPointsNeeded);
        }
    }
}