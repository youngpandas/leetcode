package leetcode;

import java.util.*;

public class demo990 {

    boolean res = true;

    public boolean equationsPossible(String[] equations) {
        int[][] edges = new int[equations.length][3];
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equations.length; i++) {
            char[] temp = equations[i].toCharArray();
            char m = temp[0], k = temp[1], n = temp[3];
            if (!map.containsKey(m)) {
                map.put(m, index++);
            }
            if (!map.containsKey(n)) {
                map.put(n, index++);
            }
            edges[i][0] = map.get(m);
            edges[i][1] = map.get(n);
            edges[i][2] = k == '=' ? 1 : -1;
        }
        int[][] matrix = new int[map.size()][map.size()];
        for (int[] e : edges) {
            if (e[0] == e[1] && e[2] == -1) return false;
            if (matrix[e[0]][e[1]] == 0) {
                matrix[e[0]][e[1]] = matrix[e[1]][e[0]] = e[2];
            } else {
                if (matrix[e[0]][e[1]] != e[2]) return false;
            }
        }

        System.out.println(Arrays.deepToString(edges));
        System.out.println(Arrays.deepToString(matrix));

        int[] visited = new int[matrix.length];
        while (true) {
            System.out.println(Arrays.toString(visited));
            if (!res) return false;
            int start = nextNode(visited);
            if (start == visited.length) break;
            dfs(matrix, start, visited, new int[matrix.length]);
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 2) visited[i] = 1;
            }
        }
        return true;
    }


    public int nextNode(int[] visited) {
        int i = 0;
        for (; i < visited.length; i++) {
            if (visited[i] == 0) break;
        }
        return i;
    }

    public void dfs(int[][] matrix, int node, int[] visited, int[] excluded) {
        if (!res) return;
        int[] children = matrix[node];
        visited[node] = 2;
        for (int i = 0; i < matrix.length; i++) {
            if (children[i] == 0) continue;
            if (children[i] == 1) {
                if (excluded[i] == 1) {
                    res = false;
                    return;
                }
                if (visited[i] == 0) {
                    dfs(matrix, i, visited, excluded);
                }
            } else {
                if (visited[i] == 2) {
                    res = false;
                    return;
                }
                excluded[i] = 1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new demo990().equationsPossible(new String[]{
                "a==b", "e==c", "b==c", "a!=e"
        }));
    }

}
