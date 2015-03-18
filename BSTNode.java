public class BSTNode{
	//Instance variables:
	public int key;
	public BSTNode left;
	public BSTNode right;
	public BSTNode parent;
	
	/** Creates a node with null references to its element and next node. */
	public BSTNode(int k, BSTNode lc, BSTNode rc, BSTNode p){		//characters are being held in the Nodes ([{<>}])
		key = k;
		left = lc;
		right = rc;
		parent = p;
		
	}
	//Accessor methods:
	public int getKey(){
		return key;
	}
	public BSTNode getLeft(){
		return left;
	}
	
	public BSTNode getRight(){
		return right;
	}

	public BSTNode getParent(){
		return parent;
	}
	//Modifier methods:
	public void setElement(char newKey) {
		key = newKey;
	}
	
	public void setLeft(BSTNode newLeft){
		left = newLeft;
	}
	
	public void setRight(BSTNode newRight){
		right = newRight;
	}

	public void setParent(BSTNode newParent){
		parent = newParent;
	}
	
	public void displayNode(){
		System.out.println(key);
	}
}
