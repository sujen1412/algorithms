package datastructures.trees;

public class InorderSuccessor {

	public static void main(String[] args) {
		Node n2 = new Node(2, null, null);
		Node n4 = new Node(4, null, null);
		Node n3 = new Node(3, n2, n4);
		Node n6 = new Node(6, null, null);
		Node root = new Node(5, n3, n6);
		
		System.out.println(inorderSuccessor(root, root).data);
	}
	
	static Node inorderSuccessor(Node root, Node key){
		if(root == null){
			return null;
		}
		if(key.rightChild!=null){
			return getLeftMost(root.rightChild);
		}
		int data = key.data;
		Node succ = null;
		while(root!=null){
			if(root.data>data){
				succ = root;
				root = root.leftChild;
			}
			else if(root.data<data){
				root = root.rightChild;
			}
			else
				break;
		}
		return succ;
	}
	
	static Node getLeftMost(Node root){
		if(root == null)
			return null;
		while(root.leftChild!=null){
			root = root.leftChild;
		}
		return root;
	}
}
