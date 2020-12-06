public class backtrack {
    public static void main(String[] args) {
        printNumbers(50, 100);
        TreeNode node = new TreeNode(1);
        printLeaf(node);
    }

    private static void printNumbers(int low, int high) {
        if(low > high)
            return;
        System.out.println(high);
        printNumbers(low, high - 1);
    }

    private static void printLeaf(TreeNode node) {
        if(node.left == null && node.right == null)
            System.out.println(node.val);
        printLeaf(node.left);
        printLeaf(node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
