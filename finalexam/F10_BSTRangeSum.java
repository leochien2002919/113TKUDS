import java.util.*;

public class F10_BSTRangeSum {
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

        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
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

    public static int rangeSum(TreeNode node, int L, int R) {
        if (node == null) return 0;

        int sum = 0;

        if (node.val > L) {
            sum += rangeSum(node.left, L, R);
        }

        if (node.val >= L && node.val <= R) {
            sum += node.val;
        }

        if (node.val < R) {
            sum += rangeSum(node.right, L, R);
        }

        return sum;
    }
}
