package offer;

import java.util.*;

public class demo66机器人的运动范围 {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;
        int[] pos = {0, 0};
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(pos);
        set.add(Arrays.toString(pos));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pos = q.poll();
                if (pos[0] > 0) join(new int[]{pos[0] - 1, pos[1]}, threshold, set, q);
                if (pos[0] < rows - 1) join(new int[]{pos[0] + 1, pos[1]}, threshold, set, q);
                if (pos[1] > 0) join(new int[]{pos[0], pos[1] - 1}, threshold, set, q);
                if (pos[1] < cols - 1) join(new int[]{pos[0], pos[1] + 1}, threshold, set, q);
            }
        }
        return set.size();
    }

    public int cal(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public void join(int[] pos, int threshold, Set<String> set, Queue<int[]> q) {
        String key = Arrays.toString(pos);
        int val = cal(pos[0]) + cal(pos[1]);
        if (val <= threshold && !set.contains(key)) {
            q.offer(pos);
            set.add(key);
        }
    }


    public static void main(String[] args) {
        System.out.println(new demo66机器人的运动范围().movingCount(18, 50, 50));
        System.out.println(new demo66机器人的运动范围().movingCount(0, 0, 0));
        System.out.println(new demo66机器人的运动范围().movingCount(18, -1, 2));
        System.out.println(new demo66机器人的运动范围().movingCount(18, 50, 50));
        System.out.println(new demo66机器人的运动范围().movingCount(18, 50, 50));
    }

}
