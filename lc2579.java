import java.time.Period;

class LC2579 {
    public long coloredCells(int n) {
        long prevcells = 1;
        for (int i = 0; i < n; ++i) {
            prevcells += 4 * i;
        }
        System.out.println(prevcells);
        return prevcells;

    }

    public static void main(String[] args) {
        LC2579 solution = new LC2579();
        solution.coloredCells(1);
        solution.coloredCells(2);
        solution.coloredCells(3);
        solution.coloredCells(4);

    }
}
