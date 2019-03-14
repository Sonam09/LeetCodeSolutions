import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Solution1 {
    public int orangesRottingWithQ(int[][] grid) {
        int fresh = 0, mins = -1;
        ArrayDeque<int[]> q = new ArrayDeque<int[]>();

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    ++fresh;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) { return 0; }

        while (!q.isEmpty()) {
            ++mins;
            int size  = q.size();
            for (int i = 0; i < size; ++i) {
                int[] indx = q.poll();

                fresh -= rot(grid, q,indx[0]-1, indx[1]) + rot(grid, q,indx[0]+1, indx[1]) +
                         rot(grid, q,indx[0], indx[1]-1) + rot(grid, q,indx[0], indx[1]+1);
            }
        }

        if (fresh > 0) { return -1; }

        return mins;
    }

    public int orangesRotting(int[][] grid) {
        int fresh = 0, mins = 0;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1)
                    ++fresh;


        for (int oldFresh = fresh; fresh > 0; ++mins, oldFresh = fresh) {
            for (int i = 0; i < grid.length; ++i)
                for (int j = 0; j < grid[0].length; ++j)
                    if (grid[i][j] == mins + 2)
                        fresh -= rot(grid, i - 1, j, mins) + rot(grid, i + 1, j, mins) +
                                rot(grid, i, j - 1, mins) + rot(grid, i, j + 1, mins);

            if (oldFresh == fresh)
                return -1;
        }
        return mins;
    }

    private int rot(int[][] grid, int i, int j, int mins) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = mins+3;
        return 1;
    }

    private int rot(int[][] grid, ArrayDeque q, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        q.add(new int[]{i, j});
        return 1;
    }
}

public class RottenOranges {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        String ip = input.substring(1, input.length()-2);
        String[] parts = ip.split("],");
        if (parts.length == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[parts.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stringToIntegerArray(parts[i] + "]");
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new Solution1().orangesRotting(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}