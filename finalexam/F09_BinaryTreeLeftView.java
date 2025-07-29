import java.util.*;

public class F09_BinaryTreeLeftView {
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
        List<Integer> leftView = getLeftView(root);
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
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

    public static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
