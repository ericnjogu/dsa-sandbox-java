package com.harmony.sandbox.dsa.prep2022;

import java.util.List;
import java.util.ArrayList;

class Tree {
	public static void main (String[] args) {
		Node root = new Node(1);
		root.addChild(new Node(3)).addChild(new Node(4).addChild(new Node(7)));
		Node nodeTwo = new Node(2);
		root.addChild(nodeTwo);
		nodeTwo.addChild(new Node(6)).addChild(new Node(5));
		
		System.out.println(root);
	}
}

record Node(List<Node> children, int data) {
	Node addChild(Node child) {
		children.add(child);
		return this;
	}
	
	Node(int data) {
		this(new ArrayList<>(), data);
	}
}