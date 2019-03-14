import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class areTreeNodesCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        int found = 0;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();

                if (t == null) { continue; }
                if (t.val == x || t.val == y) {
                    ++found;
                    if (found == 2 && (map.get(x) != map.get(y))) {
                        break;
                    }
                }
                if (t.left != null) {
                    q.add(t.left);
                    map.put(t.left.val, t.val);
                }
                if (t.right != null) {
                    q.add(t.right);
                    map.put(t.right.val, t.val);
                }
            }
            if (found > 0) {
                break;
            }
        }
        return found == 2;
    }
}
