import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nodes = sc.nextLine().split(" ");
        TreeNode root = buildTree(nodes);

        int target = sc.nextInt();

        int closest = closestValue(root, target);
        System.out.println("Closest: " + closest);
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode current = root;

        while (current != null) {
            int currVal = current.val;
            int diffCurrent = Math.abs(currVal - target);
            int diffClosest = Math.abs(closest - target);

            if (diffCurrent < diffClosest || (diffCurrent == diffClosest && currVal < closest)) {
                closest = currVal;
            }

            if (target < currVal) {
                current = current.left;
            } else if (target > currVal) {
                current = current.right;
            } else {
                break;
            }
        }

        return closest;
    }
}
