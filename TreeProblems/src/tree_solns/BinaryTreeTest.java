package tree_solns;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	
	private BinaryTree bt;
	
	@BeforeEach
	void createTree() {
		bt = new BinaryTree();
	}

	@Test
	void testCountSevensInTree_emptyTree_shouldReturnZero() {
		assertEquals(0, bt.countSevensInTree());
	}
	
	@Test
	void testCountSevensInTree_nonEmptyTreeWithNoSevens_shouldReturnZero() {
		bt.insert(15);
		bt.insert(24);
		bt.insert(3);
		bt.insert(12);
		assertEquals(0, bt.countSevensInTree());
	}
	
	@Test
	void testCountSevensInTree_number7And17InTree_shouldReturnTwo() {
		bt.insert(13);
		bt.insert(7); // make sure we check both sides...
		bt.insert(15);
		bt.insert(16);
		bt.insert(17);
		assertEquals(2, bt.countSevensInTree());
	}
	
	@Test
	void testCountSevensInTree_number777And77And27InTreeAtFarEnds_shouldReturnSix() {
		bt.insert(365);
		bt.insert(250);
		bt.insert(125);
		bt.insert(50);
		bt.insert(27);
		bt.insert(77);
		bt.insert(14);
		bt.insert(500);
		bt.insert(625);
		bt.insert(680);
		bt.insert(654);
		bt.insert(692);
		bt.insert(777);
		assertEquals(6, bt.countSevensInTree());
	}
	
	@Test
	void testPathOfDestruction_emptyTree_expectEmptyResults() {
		ArrayList<Integer> res = bt.pathOfDestruction(0);
		assertEquals(0, bt.size());
		assertTrue(res.isEmpty());
		assertEquals("[]", bt.toString());
	}
	
	@Test
	void testPathOfDestruction_itemInTree_checkTreeSizeAndString() {
		bt.insert(52);
		bt.insert(13);
		bt.insert(58);
		bt.insert(54);
		bt.insert(53);
		bt.insert(55);
		bt.insert(59);
		
		int[] burnedNodes = {13, 54};
		ArrayList<Integer> res = bt.pathOfDestruction(59);
		assertEquals(2, res.size());
		
		for (int i = 0; i < burnedNodes.length; i++) {
			// I'm being a little lenient here with just checking that your solution
			// contains these nodes. 
			assertTrue(res.contains(burnedNodes[i]));
		}
		
		assertEquals(3, bt.size());
		assertEquals("[52, 58, 59]", bt.toString());
	}
	
	@Test
	void testPathOfDestruction_itemNotInTree_checkTreeSizeAndString() {
		bt.insert(52);
		bt.insert(13);
		bt.insert(58);
		bt.insert(54);
		bt.insert(53);
		bt.insert(55);
		bt.insert(59);
		
		ArrayList<Integer> res = bt.pathOfDestruction(17);
		// Right subtree gets burned.
		assertTrue(res.isEmpty());
		
		assertEquals(2, bt.size());
		assertEquals("[13, 52]", bt.toString());
	}
	
	@Test
	void testAddFlyingVs_emptyTree_emptyItemsInV_expectEmptyTree() {
		bt.addFlyingVs(new ArrayList<Integer>());
		assertEquals(0, bt.size());
		assertEquals("[]", bt.toString());
	}
	
	@Test
	void testAddFlyingVs_emptyTree_nonEmptyItemsInVEvenSize_expectFlyingVForm() {
		ArrayList<Integer> itemsInV = new ArrayList<>();
		itemsInV.addAll(List.of(1, 2, 3, 4));
		bt.addFlyingVs(itemsInV);
		assertEquals(4, bt.size());
		assertEquals("[1, 2, 3, 4]", bt.toString());
		// a bit of a draconian way to test it
		assertEquals(3, bt.root.data);
		assertEquals(2, bt.root.left.data);
		assertEquals(4, bt.root.right.data);
		assertEquals(1, bt.root.left.left.data);
	}
	
	@Test
	void testAddFlyingVs_emptyTree_nonEmptyItemsInVOddSize_expectFlyingVForm() {
		ArrayList<Integer> itemsInV = new ArrayList<>();
		itemsInV.addAll(List.of(2, 3, 4));
		bt.addFlyingVs(itemsInV);
		assertEquals(3, bt.size());
		assertEquals("[2, 3, 4]", bt.toString());
		// a bit of a draconian way to test it
		assertEquals(3, bt.root.data);
		assertEquals(2, bt.root.left.data);
		assertEquals(4, bt.root.right.data);
	}
	
	@Test
	void testAddFlyingVs_nonEmptyTree_emptyFlyingVs_expectSameTree() {
		bt.insert(5);
		bt.insert(3);
		bt.insert(7);
		bt.insert(10);
		
		bt.addFlyingVs(new ArrayList<>());
		assertEquals(4, bt.size());
		assertEquals("[3, 5, 7, 10]", bt.toString());
	}
	
	@Test
	void testAddFlyingVs_nonEmptyTree_nonEmptyFlyingVsEvenSizeItems_expectSizeAndStringChanges() {
		bt.insert(25);
		bt.insert(21);
		bt.insert(17);
		bt.insert(31);
		bt.insert(23);
		
		ArrayList<Integer> itemsInV = new ArrayList<>();
		itemsInV.addAll(List.of(1, 2));
		bt.addFlyingVs(itemsInV);
		assertEquals(17, bt.size());
		assertEquals("[1, 2, 17, 1, 2, 21, 1, 2, 23, 1, 2, 25, 1, 2, 31, 1, 2]", bt.toString());
	}
	
	@Test
	void testAddFlyingVs_nonEmptyTree_nonEmptyFlyingVsOddSizeItems_expectSizeAndStringChanges() {
		bt.insert(25);
		bt.insert(21);
		bt.insert(17);
		bt.insert(31);
		bt.insert(23);
		
		ArrayList<Integer> itemsInV = new ArrayList<>();
		itemsInV.addAll(List.of(1, 2, 3));
		bt.addFlyingVs(itemsInV);
		assertEquals(23, bt.size());
		assertEquals("[1, 2, 3, 17, 1, 2, 3, 21, 1, 2, 3, 23, 1, 2, 3, 25, 1, 2, 3, 31, 1, 2, 3]", bt.toString());
	}

}
