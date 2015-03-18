import java.util.*; //built in stack class

public class BST{
	private int size; // field that holds size of the tree
	public BSTNode root; // field that holds the root o the tree
		
	/**
	 *Constructor
	*/
	public BST(){
		size = 0;
		root = null;
	}// end BST()
	
	/**
	 *Recursively inserts if a new BSTNode with key k in the correct 
	 *postion as the child of BSTNode v.
	 *		@param: the key to be added to the tree
	 *		@param: the parent of the new node
	*/
	private void recInsert(int k, BSTNode v){
		if (k > v.key){ //if new key is larger than current key
			if (v.right == null){ //if v has no right child
				v.right = new BSTNode(k,null,null,v); //add new node as right child
			}
			else {
				recInsert(k, v.right); //call recInsert on right child
			}
		}
		else if (k <= v.key){ //if new key is smaller or the same size as current key
			if (v.left == null){ //if v has no left child
				v.left = new BSTNode(k,null,null,v); //add new node as left child
			}
			else{
				recInsert(k,v.left); //call recInsert on left child
			}
		}
	}//end recInsert

	/**
	 *Inserts a node with key k into the tree.
	 *		@param: key to be added to the tree
	 */
	public void insert(int k){
		if (root == null){ // if tree is empty
			root = new BSTNode(k,null,null,null); //add new node as root
		}
		else{
			recInsert(k,root); //call recInsert on the root
		}
	}//end insert

	/**
	 *Finds and returns a node with key k, returns null if key is not found
	 *		@param: key to be found
	 *		@param: root of tree to search for key in
	 *		@return: the BSTNode if found, null otherwise
	*/
	public BSTNode find(int k, BSTNode v){
		if (v==null){//if key isn't found
			return null;
		}
		else if (v.key==k){
			return v;
		}
		else if (v.key>k){
			return find(k,v.left);//call find on left child
		}
		else {
			return find(k,v.right);//call find on right child
		}
	}//end find
	
	/**
	 *Replaces one node and its contents with another node.
	 *		@param: node to be swapped
	 *		@param: node to be swapped
	 */
	public void replace(BSTNode v, BSTNode w){
		if (v==root){//if v is root
			root = w;
			if (w!=null){
				w.parent = null;
			}
		}
		else{
			if(v.parent.right == v){//if v is right child
				v.parent.right = w;
			}
			else {//if v is left child
				v.parent.left = w;
			}
			if (w!=null){
				w.parent = v.parent;
			}
		}
	}//end replace
	
	/**
	 *Returns the minimum of the subtree rooted at BSTNode v.
	 *		@param: node that subtree is rooted at.
	 *		@return: minimum node
	 */
	public BSTNode getMin(BSTNode v) {
		if(v.left != null) // if v has no left child
			return getMin(v.left);//call getMin on left child
		else
			return v;
	}//end getMin
	
	/**
	 *Returns the maximum of the subtree rooted at v.
	 *		@param: node that subtree is rooted at
	 *		@return: maximum node
	 */
	public BSTNode getMax(BSTNode v) {
		if(v.right != null)//if v has no right child
			return getMax(v.right);//call getMax on right child
		else
			return v;
	}

	/**
	 *Deletes and returns a node with the inputted key k, returns null if key
	 *is not found.
	 *		@param: key of node to be deleted
	 *		@return: node that is deleted
	 */
	public BSTNode delete(int k){
		BSTNode v = find(k,root);//find the node with key k
		if (v!=null){
			if (v.left == null && v.right == null){ // if v has no children
				if (v == root){ //if v is the root
					root = null;
				}
				else if (v.parent.left == v){//if v is left child
					v.parent.left = null;
				}
				else{//if v is right child
					v.parent.right = null;
				}
			}
			else if (v.right != null && v.left != null){
				int i = (int)(Math.random() * 2);
				//generate random number between 0 and 2
				if(i == 0) {
					BSTNode min = getMin(v.right);//call getMin
					v.key = min.key;
					replace(min, min.right);//replace min with right child
				}
				else {
					BSTNode max = getMax(v.left);//call getMax
					v.key = max.key;
					replace(max, max.left);//replace max with left child
				}
				
			}
			else{
				if(v.left != null){//if v has no left chikl
					replace(v, v.left);//replace v with left child
				}
				else{//if v has no right child
					replace(v, v.right);//replace v with right child
				}
			}		
		}
		return v;
	}//end delete
	
	/**
	 *Displays the tree.
	 */
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = (BSTNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}  // end displayTree()
	
	/**
	 *Traverses the tree in the specified traversal method.
	 *		@param: letter of type of traversal
	 */
	public void traverse(char traverseType)
	{
		switch(traverseType)
		{
			case 'p': System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
			case 'i': System.out.print("\nInorder traversal:  ");
				inOrder(root);
				break;
			
			case 't': System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
			
		}
		System.out.println();
	}
	
	/**
	 *Prints the contents of the tree in preorder.
	 *		@param: node that tree is rooted at
	 */
	public void preOrder(BSTNode v){
		System.out.print(v.key + ", ");
		if(v.left != null)
			preOrder(v.left);
		if(v.right != null)
			preOrder(v.right);
	}//end preOrder
	
	/**
	 *Prints the contents of the tree in postorder.
	 *		@param: node that tree is rooted at
	 */
	public void postOrder(BSTNode v){
		if(v.left != null)
			postOrder(v.left);
		if(v.right != null)
			postOrder(v.right);
		System.out.print(v.key + ", ");
	}//end postOrder
	
	/**
	 *Prints the contents of the tree in inorder.
	 *		@param: node that tree is rooted at
	 */
	public void inOrder(BSTNode v){
		if(v.left != null)
			inOrder(v.left);
		System.out.print(v.key + ", ");
		if(v.right != null)
			inOrder(v.right);
	}
		
}//end class
