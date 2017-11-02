/**
 * InvertBinaryTree.java
 * 
 * @author mimibar
 * @date Sep 12, 2015
 * @link https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {
    TreeNode temp;

    public TreeNode invertTree(TreeNode root) {

	goDownTree(root);

	return root;

    }

    public void goDownTree(TreeNode current) {

	if (current != null && (current.left != null || current.right != null)) {// if not empty and has children

	    temp = current.left;
	    current.left = current.right;
	    current.right = temp;

	    goDownTree(current.left);
	    goDownTree(current.right);
	}
    }

    public static void printNextTreeNode(TreeNode node) {
	System.out.print(node.val);

	if (node.left != null || node.right != null) {
	    if (node.left != null)
		printNextTreeNode(node.left);
	    else
		System.out.print(" ");

	    if (node.right != null)
		printNextTreeNode(node.right);
	    else
		System.out.print(" ");

	}

    }

    static void runTest(TreeNode tree) {
	System.out.print("input:\t");
	printNextTreeNode(tree);
	System.out.println();

	InvertBinaryTree ibt = new InvertBinaryTree();
	TreeNode invertedTree = ibt.invertTree(tree);
	System.out.print("output:\t");
	printNextTreeNode(invertedTree);
	System.out.println(".");
	System.out.println();
    }

    public static void main(String[] args) {
	TreeNode myTree;
	// [4,2,1,3,7,6,9]
	myTree = new TreeNode(4);
	myTree.left = new TreeNode(2);
	myTree.left.left = new TreeNode(1);
	myTree.left.right = new TreeNode(3);
	myTree.right = new TreeNode(7);
	myTree.right.left = new TreeNode(6);
	// myTree.right.right = new TreeNode(9);
	runTest(myTree);

	// Test Case 6/68 [1,2] -> [1,null,2]
	myTree = new TreeNode(1);
	myTree.left = new TreeNode(2);
	runTest(myTree);

	// Test Case 10/68 [1,null,2] -> [1,2]
	myTree = new TreeNode(1);
	myTree.right = new TreeNode(2);
	runTest(myTree);

	// Test Case 32 / 68 [2,3,null,1] -> [2,null,3,null,1]
	myTree = new TreeNode(2);
	myTree.left = new TreeNode(3);
	myTree.left.right = new TreeNode(1);

	runTest(myTree);
    }
}
