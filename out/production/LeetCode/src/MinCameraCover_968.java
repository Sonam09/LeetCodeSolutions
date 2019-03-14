import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MinCameraCover_968Solution {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        return (minCameraCoverHelper(root) < 1 ? 1 : 0) + result;
    }

    private int minCameraCoverHelper(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int lCover = minCameraCoverHelper(root.left);
        int rCover = minCameraCoverHelper(root.right);

        if (Math.min(lCover, rCover) == 0) {
            result++;
            return 1;
        } else if (lCover == 1 || rCover == 1) {
            return 2;
        }
        return 0;
    }


}

public class MinCameraCover_968 {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new MinCameraCover_968Solution().minCameraCover(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
