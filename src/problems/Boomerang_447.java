package problems;

import java.util.*;

public class Boomerang_447 {
    // #447 Numbers of Boomerangs
    // Status: Passed. 237 ms. 56.52%

    // Create HashMap for each points to store distances to each point.
    // If 2 points has same distance, then there're 2 Boomerangs (2*1)
    // If 3 points has same distance, then there're 6 Boomerangs (3*2)
    // If n points has same distance, then n * (n-1) Boomerangs.
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int j = 0; j < points.length; j++) {
                int dis = calculateDistance(p, points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int v : map.values()) {
                result += v * (v - 1);
            }
        }

        return result;
    }

    private int calculateDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] t1 = { { 0, 0 }, { 1, 0 }, { 2, 0 } };

        Boomerang_447 nb = new Boomerang_447();
        System.out.println(nb.numberOfBoomerangs(t1));
    }

}
