

import java.io.*;

class TreeApp
{

	public static void main(String[] args) throws IOException
	{
		int choice, value;
		BST theTree = new BST();

		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);
		theTree.insert(33);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97);
		
		do
		{
			System.out.print("\nEnter a letter: \n\n quit program (q) \n show tree (s) \n ");
			System.out.print("insert (i) \n find (f) \n delete (d) \n traverse (t) \n\t\t --> ");
			choice = getChar();
			//to see how switch statements in java work, see:
			// http://www.cafeaulait.org/course/week2/42.html
			switch(choice)
			{
				case 's':
					theTree.displayTree();
					break;
				case 'i':
					System.out.print("\nEnter value to insert: ");
					value = getInt();
					theTree.insert(value);
					break;
				case 'f':
					System.out.print("\nEnter value to find: ");
					value = getInt();
					BSTNode found = theTree.find(value, theTree.root);
					if(found != null)
					{
						System.out.print("\nFound: ");
						found.displayNode();
						System.out.print("\n");
					}
					else 
					{
						System.out.print("\nCould not find ");
						System.out.print("" + value + '\n');
					}
					break;
				case 'd':
					System.out.print("\nEnter value to delete: ");
					value = getInt();
					if(theTree.delete(value) != null)
						System.out.print("\nDeleted " + value + '\n');
					else 
					{
						System.out.print("\nCould not delete ");
						System.out.print("" + value + '\n');
					}
					break;
				case 't':
					System.out.print("\nEnter a letter: preorder (p), inorder (i), or postorder (t) --> ");
					char letter = getChar();
					theTree.traverse(letter);
					break;
				
				case 'q':
					System.out.println("\nGoodbye.");
					break;
				default:
					System.out.print("\nNot a valid entry.\n");
			}  // end switch
		} while(choice != 'q');
		
	}  // end main()
	// -------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	// -------------------------------------------------------------
}  // end class TreeApp
////////////////////////////////////////////////////////////////

