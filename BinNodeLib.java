public class BinNodeLib 
{
	/**
	 * returns true if the given cross is a leaf.
	 * @param
	 * @author Amit
	 */
	public static boolean isLeaf(BinNode<?> cross)
	{
		if (cross == null)
			return false;
		return !cross.hasLeft() && !cross.hasRight();
	}
	
	/**
	 * returns true if the given cross has two sons.
	 * @param
	 * @author Amit
	 */
	public static boolean hasTwoSons(BinNode<?> cross)
	{
		return cross.hasLeft()&&cross.hasLeft();
	}
	
	/**
	 * returns the number of the sons of a given cross.
	 * @param
	 * @author Amit
	 */
	public static int numOfSons(BinNode<?> cross)
	{
		if(!cross.hasLeft() && !cross.hasRight())
			return 0;
		if((cross.hasLeft() && !cross.hasRight()) || (cross.hasRight() && !cross.hasLeft()))
			return 1;
		return 2;
	}
	
	/**
	 * returns the number of leaves in a given tree.
	 * @param
	 * @author Amit
	 */
	public static int numOfLeaves(BinNode<?> tree)
	{
		// 
		if(tree == null)
			return 0;
		if(isLeaf(tree))
			return numOfLeaves(tree.getLeft()) + numOfLeaves(tree.getRight()) + 1; 
		return numOfLeaves(tree.getLeft()) + numOfLeaves(tree.getRight());
	}
	
	/**
	 * returns the number of leaves that are on the last level of a tree. <br>
	 * needs to be called first with the same instance of a the tree.
	 * @param
	 * @return
	 */
	public static int numOfLastLeaves(BinNode<Integer> tree, BinNode<Integer> leaf)
	{
		if(leaf == null)
			return 0;
		
		if(isLeaf(leaf) && getNodeLevel(tree, leaf) == treeHeight(tree))
			return numOfLastLeaves(tree, leaf.getLeft()) + numOfLastLeaves(tree, leaf.getRight()) + 1; 
		
		return numOfLastLeaves(tree, leaf.getLeft()) + numOfLastLeaves(tree, leaf.getRight());
	}
	
	/**
	 * returns the number of crosses in a given tree.
	 * @param
	 * @author Amit
	 */
	public static int numOfCross(BinNode<?> tree)
	{
		if(tree == null)
			return 0;
		if (hasTwoSons(tree))
			return numOfCross(tree.getRight()) + numOfCross(tree.getLeft()) + 1;
		return numOfCross(tree.getRight()) + numOfCross(tree.getLeft());
	}
	
	/**
	 * returns true if a number is in a given tree.
	 * @param
	 * @author Amit
	 */
	public static boolean isInTree(BinNode<Integer> tree, int num)
	{
		if (tree == null)
			return false;
		if (tree.getValue() == num)
			return true;
		return isInTree(tree.getLeft(), num) || isInTree(tree.getRight(), num);
	}
	
	/**
	 * returns true if a given cross is a descendant of a tree. <br>
	 * the cross isn't null.
	 * @param 
	 * @author Amit
	 */
	public static boolean isDescendant(BinNode<?> tree, BinNode<?> cross)
	{
		if(tree == null || isLeaf(tree))
			return false;
		if(tree.getLeft() == cross || tree.getRight() == cross)
			return true;
		return isDescendant(tree.getLeft(), cross) || isDescendant(tree.getRight(), cross);
	}
	
	/**
	 * return the youngest daddy of the two given crosses.
	 * @param 
	 * @author Amit
	 */
	public static BinNode<?> youngestDaddyInTown(BinNode<?> tree, BinNode<?> cross1, BinNode<?> cross2)
	{
		boolean leftFlag = true, rightFlag = true;
		
		if(tree.hasLeft())
			leftFlag = isDescendant(tree.getLeft(), cross1) && isDescendant(tree.getLeft(), cross2);
		
		if(tree.hasRight())
			rightFlag = isDescendant(tree.getRight(), cross1) && isDescendant(tree.getRight(), cross2);
		
		if(!leftFlag && !rightFlag)
			return tree;
		
		if(leftFlag)
			return youngestDaddyInTown(tree.getLeft(), cross1, cross2);
		
		return youngestDaddyInTown(tree.getRight(), cross1, cross2);
	}
	
	/**
	 * return the height of a given tree.
	 * @param 
	 * @author Amit
	 */
	public static int treeHeight(BinNode<?> tree)
	{
		if (tree == null)
			return -1;
		if (isLeaf(tree))
			return 0;
		return Math.max(treeHeight(tree.getLeft()), treeHeight(tree.getRight())) +1;
	}
	
	/**
	 * returns the level that a given cross in a tree.
	 * @param 
	 * @author Amit
	 */
	public static int getNodeLevel(BinNode<?> tree, BinNode<?> cross)
	{
		if(tree == cross)
			return 0;
		if(tree.hasLeft() && tree.getLeft() == cross)
			return 1;
		if(tree.hasRight() && tree.getRight() == cross)
			return 1;
		if(isDescendant(tree.getLeft(), cross))
				return getNodeLevel(tree.getLeft(), cross) + 1;
		return getNodeLevel(tree.getRight(), cross) + 1;
	}
	
	/**
	 * prints the given tree.
	 * @param
	 * @author Amit
	 */
	public static void printTree(BinNode<?> tree)
	{
		// 
		if(tree != null)
		{
			System.out.print(tree.getValue()+" ");
			printTree(tree.getLeft());
			printTree(tree.getRight());
		}
	}
	
	/**
	 * preOrder function.
	 * @param
	 * @author Amit
	 */
	public static void preOrder(BinNode<?> tree)
	{
		if (tree!=null)
		{
			System.out.print(tree.getValue()+" ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}	
	
	/**
	 * inOrder function.
	 * @param
	 * @author Amit
	 */
	public static void inOrder(BinNode<?> tree)
	{
		if (tree!=null)
		{
			inOrder(tree.getLeft());
			System.out.print(tree.getValue()+" ");
			inOrder(tree.getRight());
		}
	}
	
	/**
	 * postOrder function.
	 * @param
	 * @author Amit
	 */
	public static void postOrder(BinNode<?> tree)
	{	
		if (tree!=null)
		{
			inOrder(tree.getLeft());
			inOrder(tree.getRight());
			System.out.print(tree.getValue()+" ");
		}
	}
	
	public static boolean fullTree(BinNode<Integer> t)
	{
		if (t == null)
			return true;
		if (numOfSons(t) == 1)
			return false;
		return fullTree(t.getLeft()) && fullTree(t.getRight());
	}
	
	public static boolean completeTree(BinNode<Integer> t)
	{
		return numOfLastLeaves(t, t) == numOfLeaves(t);
	}

	public static boolean perfectTree(BinNode<Integer> t)
	{
		return completeTree(t) && fullTree(t);
	}
	
	public static boolean AVLtree(BinNode<Integer> t)
	{
		if(t == null)
			return true;;
		if(t.hasLeft() && !t.hasRight())
			return isLeaf(t.getLeft());
		if(!t.hasLeft() && t.hasRight())
			return isLeaf(t.getRight());
		if(hasTwoSons(t) && Math.abs(treeHeight(t.getLeft()) - treeHeight(t.getRight())) 	> 1)
			return false;
		return AVLtree(t.getLeft()) && AVLtree(t.getRight());
	}
	
	public static boolean sortedSerach(BinNode<Integer> t, int num) // Special trees..
	{
		if (t == null) 
			return false;
		if (t.getValue() == num) 
			return true;
		if (t.getValue() > num)
			return sortedSerach(t.getLeft(),num);
		return sortedSerach(t.getRight(),num);
	}
	
	public static void insertSorted(BinNode<Integer> t, int num) // Special trees..
	{
		if(t==null)
		{
			t = new BinNode<Integer>(num);
			return;
		}
		else if(t.getValue() > num)
		{
			if(t.hasLeft())
				insertSorted(t.getLeft(), num);
			else
				t.setLeft(new BinNode<Integer>(num));
		}
		else
		{
			if(t.hasRight())
				insertSorted(t.getRight(), num);
			else
				t.setRight(new BinNode<Integer>(num));
		}
	}
	
	public static void printByLevel(BinNode<Integer> t)
	{
		Queue<BinNode<Integer>> q = new Queue<>();
		q.insert(t);
		while(!q.isEmpty())
		{
			System.out.println(q.head().getValue());
			if(q.head().hasLeft())
				q.insert(q.head().getLeft());
			if(q.head().hasRight())
				q.insert(q.head().getRight());
			q.remove();
		}
	}

	public static void printLevel(BinNode<Integer> t, int i)
	{
		Queue<BinNode<Integer>> q = new Queue<>();
		q.insert(t);
		while(!q.isEmpty())
		{
			if(getNodeLevel(t, q.head()) == i)
				System.out.println(q.head().getValue());
			if(q.head().hasLeft())
				q.insert(q.head().getLeft());
			if(q.head().hasRight())
				q.insert(q.head().getRight());
			q.remove();
		}
	}
	
	public static int treeDiameter(BinNode<Integer> t)
	{
		int[] diameters = new int[treeHeight(t)];
		
		Queue<BinNode<Integer>> q = new Queue<>();
		q.insert(t);
		while(!q.isEmpty())
		{
			if(q.head().hasLeft())
				q.insert(q.head().getLeft());
			if(q.head().hasRight())
				q.insert(q.head().getRight());
			diameters[getNodeLevel(t, q.head())]++;
			q.remove();
		}
		
		int max = diameters[0];
		for (int i = 1; i < diameters.length; i++) 
			if(diameters[i] > max)
				max = diameters[i];
		return max;
	}
	
	public static int maxInTree(BinNode<Integer> t,int max)
	{
		if(t == null)
			return max;
		if(t.getValue() > max);
			max = t.getValue();
		return Math.max(maxInTree(t.getLeft(), max), maxInTree(t.getRight(), max));
	}
	
	public static int shows(BinNode<Integer> t, int x)
    {
        if (t == null)
        {
            return 0;
        }
        if (t.getValue() == x)
        {
            return 1 + shows(t.getLeft(), x) + shows(t.getRight(), x);
        }
        return shows(t.getLeft(), x) + shows(t.getRight(), x);
    }
}
