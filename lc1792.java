import java.util.PriorityQueue;

class LC1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int ROWS = classes.length;

        PriorityQueue<double[]> maxheap = new PriorityQueue<>((f, l) -> Double.compare(l[0], f[0]));

        for (int r = 0; r < ROWS; ++r) {
            int passes = classes[r][0];
            int total = classes[r][1];
            maxheap.add(new double[] { getDelta(passes, total), r });
        }
        for (int i = extraStudents; i > 0; --i) {
            double[] curr = maxheap.poll();
            int npass = ++classes[(int) curr[1]][0];
            int ntotal = ++classes[(int) curr[1]][1];
            maxheap.add(new double[] { getDelta(npass, ntotal), curr[1] });
        }
        double r = 0;
        for (int[] eclass : classes) {
            r += (double) eclass[0] / eclass[1];
        }

        System.out.println(r / ROWS);

        return r / ROWS;
    }

    private double getDelta(int pass, int total) {
        double tmp = (double) (pass + 1) / (total + 1);
        double original = (double) (pass) / (total);
        return tmp - original;

    }

    public static void main(String[] args) {
        LC1792 solution = new LC1792();
        int[][] c1 = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        int[][] c2 = { { 2, 4 }, { 3, 9 }, { 4, 5 }, { 2, 10 } };
        solution.maxAverageRatio(c1, 2);
        solution.maxAverageRatio(c2, 4);

    }
}
