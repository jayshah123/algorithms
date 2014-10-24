package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ds.BinarySearchTree.Node;

/*
 * This is a binary tree which supports : generics, heights, parents, counts, ranks, predecessor, successor, ancestor
 * 											searching, insertion, rotation(AVL), deletion and pretty printing.
 */

public class BinarySearchTree<Item extends Comparable<Item>> {

	Node startNode;

	boolean AVLMode = false;

	class Node {
		int height;// path length(edges) from this node to leaf. 0 for leafs
		Node left;
		Node right;
		Item item;
		Node parent;
		int balanceFactor; // -1 for left heavy, 0 for balanced, 1 for right heavy.
		int count;// no. of nodes in this subtree including this one. should be
					// updated on insert

		public Node(Item item) {
			super();
			this.item = item;
			this.count = 1;
		}

		public Node() {
			this.left = null;
			this.right = null;
			this.height = 0;
			this.parent = null;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "item = " + this.item+" cnt = "+count+" h = "+height;
		}

	}

	/*
	 * returns the other child of parent than the one passed in
	 */
	Node otherSibling(Node parent, Node first){
		if(parent.left != first && parent.right != first){
			throw new IllegalStateException(" node passed should be either left or right child");
		}
		if(parent.left==first)
			return parent.right;
		else
			return parent.left;
	}
	
	/*
	 * Cut the parent and assign child to grandparent
	 */
	Node assignToParent(Node grandParent, Node child){
		
		return null;
	}
	
	/*
	 * return item that is max in subtree rooted at root
	 */
	Node max(Node root) {
		Node r = root;
		if (root == null)
			return null;
		while (r.right != null) {
			r = r.right;
		}
		return r;
	}

	/*
	 * return item that is min in subtree rooted at root
	 */
	Node min(Node root) {
		Node l = root;
		if (root == null) {
			return null;
		}
		while (l.left != null) {
			l = l.left;
		}
		return l;
	}

	int rank(Item item) {
		return rank(startNode, item);
	}

	/*
	 * return no. of nodes having item value less than item passed
	 */
	int rank(Node root, Item item) {
		if (root == null)
			return 0;
		int compareResult = compare(root.item, item);
		if (compareResult < 0) {
			return rank(root.left, item);
		} else if (compareResult > 0) {
			return 1 + size(root.left) + rank(root.right, item);
		} else if (compareResult == 0) {
			return size(root.left);
		}
		return 0;
	}

	void inOrder() {
		inOrder(startNode);
	}

	/*
	 * Perform inorder traversal of subtree rooted at node root
	 */
	void inOrder(Node root) {
		if (root == null)
			return;

		// print left subtree
		inOrder(root.left);

		// this
		if (root != null) {
			System.out.println(root);
		}

		// print right subtree
		inOrder(root.right);
	}

	Node search(Item item) {
		return search(item, startNode);
	}

	/*
	 * return reference to item searched in subtree rooted at node root
	 */
	Node search(Item item, Node root) {
		Node n = root;

		System.out.println(" search got item = " + item + " rppt = " + root);

		if (root == null) {
			return null;
		}

		int compareResult = compare(item, root.item);
		if (compareResult < 0) {
			return search(item, n.left);
		} else if (compareResult > 0) {
			return search(item, n.right);
		} else if (compareResult == 0) {
			return n;
		}
		return n;
	}

	/*
	 * return -1,0,-1 if i1 is lessthan, equal or greater than i2
	 */
	int compare(Item i1, Item i2) {
		// System.out.println(" i1 ="+i1+"i2 = "+i2);
		return ((Comparable<Item>) i1).compareTo((Item) i2);
	}

	/*
	 * return reference to successor node to the node present at root
	 */
	Node successor(Node root) {
		if (root == null) {
			return null;
		}
		if (root.right != null) {
			return min(root.right);
		}
		// following logic does not need parent pointers
		// but we need to search from the start node
		Node node = startNode, successor = null;
		while (node != null) {
			int compareResult = compare(root.item, node.item);
			if (compareResult < 0) {
				successor = node;
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return successor;
	}

	/*
	 * return reference to the predecessor node to the node present at root
	 */
	Node predecessor(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			return max(root.left);
		}
		// following logic does not need parent pointers
		// but we need to search from the start node
		Node node = startNode, predecessor = null;
		while (node != null) {
			int compareResult = compare(root.item, node.item);
			if (compareResult > 0) {
				predecessor = node;
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return predecessor;
	}

	int height() {
		return height(startNode);
	}

	int height(Node root) {
		if (root == null) {
			return -1;
		} 
		return root.height;
	}

	void update_height(Node root){
		root.height = 1 + Math.max(height(root.left), height(root.right));
	}
	
	int size() {
		return size(startNode);
	}

	/*
	 * return no. of nodes in subtree at root(including root)
	 */
	int size(Node root) {
		if (root == null)
			return 0;
		return root.count;
	}

	
	/*
	 * right rotate the tree rooted at node root
	 */
	Node right_rotate(Node root){
		//the left child will be new root and the old root will be new root's right child
		return null;
	}
	
	/*
	 * right rotate the tree rooted at node root
	 */
	Node left_rotate(Node root){
		// the right child will be new root and the old root will be new root's left child
		return null;
	}
	
	
	/*
	 * default insert inserts from root
	 */
	Node insert(Item item) {
		return insert(startNode, item);
	}

	/*
	 * return item that is max in subtree rooted at root
	 */
	Node insert(Node root, Item item) {
		// System.out.println("node = "+root);

		// there is no tree, so start it
		if (root == null) {
			Node node = new Node(item);
			if (startNode == null) {
				System.out.println("strtnode null");
				startNode = node;
			}
			return node;
		}

		if (AVLMode == true) {
			// do AVL balancing stuff
		}

		// insert node from tree rooted at root
		int compareResult = compare(item, root.item);
		if (compareResult < 0) {
			root.left = insert(root.left, item);
			root.left.parent = root;
		} else if (compareResult > 0) {
			root.right = insert(root.right, item);
			root.right.parent = root;
		} else if (compareResult == 0) {
			root.item = item;
		}
		root.count = size(root.left) + size(root.right) + 1;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	/*
	 * delete an item in binary tree
	 */
	Node delete(Item item) {
		return delete(startNode, item);
	}

	void updateCountsAndHeights(Node parent){
		Node p = parent;
		while(p!=null){
			p.count -= 1;
			update_height(p);
			p = p.parent;
		}
		
	}
	
	/*
	 * return item that is max in subtree rooted at root
	 */
	Node delete(Node root, Item item) {

		Node foundItem;
		foundItem = search(item);

		if (foundItem == null) {
			return null;
		}

		// case 1 : No child
		if (foundItem.right == null && foundItem.left == null) {
			if (foundItem.parent.left == foundItem) {
				foundItem.parent.left = null;
			}
			if (foundItem.parent.right == foundItem) {
				foundItem.parent.right = null;
			}
			
			updateCountsAndHeights(foundItem.parent);
			
			foundItem = null;
			return foundItem;
		}

		// case 2 : single child : either left or right
		if ((foundItem.right != null && foundItem.left == null)) {
			if (foundItem.parent.right == foundItem) {
				foundItem.parent.right = foundItem.right;
				foundItem.right.parent = foundItem.parent;
				updateCountsAndHeights(foundItem.parent);
				foundItem = null;
				return foundItem;
			} else if (foundItem.parent.left == foundItem) {
				foundItem.parent.left = foundItem.right;
				foundItem.right.parent = foundItem.parent;
				updateCountsAndHeights(foundItem.parent);
				foundItem = null;
				return foundItem;
			}
		}
		if ((foundItem.left != null && foundItem.right == null)) {
			if (foundItem.parent.right == foundItem) {
				foundItem.parent.right = foundItem.left;
				foundItem.left.parent = foundItem.parent;
				updateCountsAndHeights(foundItem.parent);
				foundItem = null;
				return foundItem;
			} else if (foundItem.parent.left == foundItem) {
				foundItem.parent.left = foundItem.left;
				foundItem.left.parent = foundItem.parent;
				updateCountsAndHeights(foundItem.parent);
				foundItem = null;
				return foundItem;
			}
		}

		// case 3 : two children
		if (foundItem.right != null && foundItem.left != null) {
			Node successor = successor(foundItem);
			foundItem.item = successor.item;
			
			//successor has one child
			if(successor.right!=null){
				//TODO handle this case
				Node child = successor.right;
				if(successor.parent.left == successor){
					successor.parent.left = child;
				} else {
					successor.parent.right = child;
				}
				child.parent = successor.parent;
			} else { //successor has no children
				if(successor.parent.left == successor){
					successor.parent.left = null;
				}
				if(successor.parent.right == successor){
					successor.parent.right = null;
				}
			}
			updateCountsAndHeights(successor.parent);
			successor = null;
		}

		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(new Integer(5));
		bst.insert(new Integer(15));
		bst.insert(new Integer(3));
		bst.insert(new Integer(-2));
		bst.insert(new Integer(8));
		bst.insert(new Integer(100));
		bst.insert(new Integer(101));

		System.out.println(" " + bst.search(new Integer(100)));
		// System.out.println(" -1 lessthan 1"+bst.compare(new Integer(2), new
		// Integer(1)));

		System.out.println(" max = " + bst.max(bst.startNode));
		System.out.println(" min = " + bst.min(bst.startNode));

		bst.inOrder();
		System.out.println("left = " + bst.startNode.left + " val = "
				+ bst.startNode + " right = " + bst.startNode.right);
		System.out.println(" bst count =  " + bst.size());

		System.out.println(" bst height  = " + bst.height());
		System.out.println(" start node pred = "
				+ bst.predecessor(bst.startNode.right.left));
		System.out.println(" start node succ = "
				+ bst.successor(bst.startNode.left));
		System.out.println(" root left parent = " + bst.startNode.left.parent
				+ " root right parent = " + bst.startNode.right.parent);

		bst.delete(new Integer(3));
		bst.delete(new Integer(100));
		bst.delete(new Integer(8));
		bst.delete(new Integer(101));
		bst.delete(new Integer(13));
		bst.delete(new Integer(5));
		
		System.out.println(bst.startNode.left);
		bst.inOrder();

		//TODO write aggressive correctness and performance test case
		
	}

}

