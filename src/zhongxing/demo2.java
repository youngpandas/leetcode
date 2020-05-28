package zhongxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo2 {

    int reputationOfExperiencedEmployees(int employeesCount, int[] employeeIDs, int[] employeeReputations,
                                         int numberOfLinks, ArrayList<Integer> empHierarchy) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < employeeIDs.length; i++) {
            map.put(employeeIDs[i], employeeReputations[i]);
        }
        boolean[] isInnerNode = new boolean[empHierarchy.size()];
        for (int i = empHierarchy.size() - 1; i >= 0; i--) {
            if (empHierarchy.get(i) == -1) {
                isInnerNode[i] = true;
                continue;
            }
            int pos = i;
            pos = (pos - 1) / 2;
            while (pos > 0) {
                if (isInnerNode[pos]) break;
                isInnerNode[pos] = true;
                pos = (pos - 1) / 2;
            }
        }

        int res = 0;
        for (int i = isInnerNode.length - 1; i >= 0; i--) {
            if (isInnerNode[i]) continue;
            if (i % 2 == 0) continue;
            int id = empHierarchy.get(i);
            res += map.get(id);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] k = new int[]{1, 2, 3, 4, 5, 6, 7, -1, -1, -1, 8, -1, -1, 9, -1};
        ArrayList<Integer> res = new ArrayList<>();
        for (int e : k) res.add(e);

        System.out.println(new demo2().reputationOfExperiencedEmployees(
                9, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{20, 9, 49, 5, 12, 23, 52, 15, 50}, 15, res
        ));
    }


}
