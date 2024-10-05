package tree;

import java.util.ArrayList;

public class BinaryTree {
	
	BinaryNode root;
	
	// I arbitrarily chose -1
	// You can really use any number you want for a NULL_NODE,
	// Just make sure it's negative (so it does not interfere with tests)
	final BinaryNode NULL_NODE = new BinaryNode(-1); 
	
	public BinaryTree() {
		root = NULL_NODE;
	}
	
	/*
	 * Given a binary tree, this method should return the total
	 * number of occurrences of the digit '7' throughout the
	 * entire tree. 
	 * 
	 * This must be implemented using tree recursion and should
	 * run in O(n) time, where n is the number of nodes in the tree.
	 * Hint: you can convert the numbers to strings.
	 */
	public int countSevensInTree() {
		// TODO: Implement me!
		return -1;
	}
	
	/**
	 * You may safely assume this will ALWAYS be called on a BST.
	 * You may NOT assume the item will be in the tree.
	 * 	- If this occurs, you SHOULD return the empty list.
	 *  - The tree SHOULD be mutated even if the item is not found.
	 *  - (You are carving a path of destruction)
	 * 
	 * As you traverse down to find the target item in this tree,
	 * you will "destroy" every branch that you do not walk down.
	 * 
	 * You don't have to worry about moving any nodes up to replace
	 * the deleted one, you can simply get rid of the subtree.
	 * 
	 * You are to report back all of the nodes you deleted via
	 * the data the "root" of the subtree had.
	 * 
	 * So if I have a tree that looks like:
	 * 
	 *                 52
	 *               /    \
	 *              13    58
	 *                   /  \
	 *                  54   59
	 *                 /  \
	 *                53  55
	 * 
	 * And my target was 59, I would return an ArrayList like:
	 * 	[13, 54]
	 * Note that it does NOT include 54's children.
	 * 
	 * This should run in O(height(T)) - namely, you walk 1 path.
	 * 
	 * @param target:
	 * 	the number you are to traverse to while destroying
	 * 	the rest of the tree.
	 */
	public ArrayList<Integer> pathOfDestruction(int target) {
		// TODO: Implement me!
		return new ArrayList<>();
	}
	
	/**
	 * HARD PROBLEM - Read carefully!
	 * 
	 * This method will originally be called on a BST, though
	 * the nodes I will ask you to insert may not necessarily
	 * end in this tree being a BST.
	 * 
	 * In this problem, any time that you reach a NULL_NODE on
	 * the original tree you start with, you will insert the
	 * new nodes containing the data provided in nodesToInsert
	 * in a "flying v" formation. 
	 * 
	 * The middle item of the AL will ALWAYS be your root node of this new subtree
	 * 
	 * As an example, if I were to give you the list
	 * 	[14, 17, 22, 15, 23]
	 * It would generate this structure:
	 * 
	 *                     22
	 *                    /  \
	 *                   17  15
	 *                  /      \
	 *                 14      23
	 * 
	 * If the list provided is not an odd length, place the
	 * extra node on the left:
	 * 	[1, 2, 3, 4, 5, 6]
	 * 
	 *                     4
	 *                    / \
	 *                   3   5
	 *                  /     \
	 *                 2       6
	 *                /
	 *               1
	 *               
	 * Also, note that the list I give you may not be sorted.
	 * That's OK, but you must maintain the order that they are passed in.
	 * 
	 * So if I initially have the tree:
	 * 
	 *                    25
	 *                   /  \
	 *                  21   31
	 *                 /  \
	 *                17  23
	 * 
	 * And I give you the list: [1, 2]
	 * The resulting tree would look like:
	 * 
	 *                          25
	 *                      /         \
	 *                 21                 31
	 *             /        \            /   \
	 *         17              23       2     2
	 *        /  \            /  \     /     / 
	 *       2    2          2    2   1     1
	 *      /    /          /    /
	 *     1    1          1    1
	 * 
	 * @param nodesToInsert
	 * 	An ArrayList containing the nodes you are to insert
	 *  in the event you reach a NULL_NODE in the original tree.
	 *  You may assume this never includes a negative number
	 *  (so your null nodes are safe)
	 */
	public void addFlyingVs(ArrayList<Integer> itemsInV) {
		// TODO: Implement me!
	}
	
	// ---------------- Testing Methods -------------------
	
	// Methods utilized by the tests:
	public void insert(int item) {
		root = root.insert(item);
	}
	
	public int height() {
		return root.height();
	}
	
	public int size() {
		return root.size();
	}
	
	// This will give you an in-order traversal of the tree,
	// if you would like to use it in order to debug.
	@Override
	public String toString() {
		return this.toArrayList().toString();
	}
	
	public ArrayList<Integer> toArrayList() {
		ArrayList<Integer> list = new ArrayList<>();
		root.toArrayList(list);
		return list;
	}
	
	// ------------------- BINARY NODE ----------------------
	
	public class BinaryNode {
		public int data;
		public BinaryNode left;
		public BinaryNode right;
		
		public BinaryNode(int element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}
		
		// TODO: Add your methods you may need here
		
		// ... method 1 ...
		
		// ----------- Testing Methods ---------------
		
		public BinaryNode insert(int element) {
			if (this == NULL_NODE) {
				return new BinaryNode(element);
			} else if (element < data) {
				left = left.insert(element);
			} else if (element > data) {
				right = right.insert(element);
			} else {
				// Duplicate case shouldn't happen (search tree), but who knows?
			}
			return this;
		}
		
		public int height() {
			if (this == NULL_NODE) {
				return -1;
			}
			return Math.max(left.height(), right.height()) + 1;
		}
		
		public int size() {
			if (this == NULL_NODE) {
				return 0;
			}
			return left.size() + right.size() + 1;
		}
		
		public void toArrayList(ArrayList<Integer> list) {
			if (this == NULL_NODE) {
				return;
			}
			left.toArrayList(list);
			list.add(this.data);
			right.toArrayList(list);
		}
	}
	
}
