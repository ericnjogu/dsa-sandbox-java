package com.harmony.sandbox.dsa.legacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
 
class BinaryTree {
	void inorderTraversal(Node root, List<Integer> visited) {
		if (Objects.nonNull(root)) {
			inorderTraversal(root.left(), visited);
			visited.add(root.data());
			inorderTraversal(root.right(), visited);
		}
	}
	
	void preorderTraversal(Node node, List<Integer> visited) {
		if (Objects.nonNull(node)) {
			visited.add(node.data());
			preorderTraversal(node.left(), visited);
			preorderTraversal(node.right(), visited);
		}
	}
	
	void postorderTraversal(Node node, List<Integer> visited) {
		if (Objects.nonNull(node)) {
			postorderTraversal(node.left(), visited);
			postorderTraversal(node.right(), visited);
			visited.add(node.data());
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1, 
			new Node(2, new Node(4, null, null), new Node(5, null, null)), 
			new Node(3, new Node(6, null, null), new Node(7, null, null)));
		
		BinaryTree tree = new BinaryTree();
		List<Integer> visited = new ArrayList<>();
		
		tree.inorderTraversal(root, visited);
		System.out.printf("inorder: %s\n", visited);
		
		visited.clear();
		tree.preorderTraversal(root, visited);
		System.out.printf("preorder: %s\n", visited);
		
		visited.clear();
		tree.postorderTraversal(root, visited);
		System.out.printf("postorderTraversal: %s\n", visited);
		
	}

	record Node(Integer data, com.harmony.sandbox.dsa.legacy.BinaryTree.Node left, com.harmony.sandbox.dsa.legacy.BinaryTree.Node right) {}
}