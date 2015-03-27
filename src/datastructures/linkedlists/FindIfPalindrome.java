package datastructures.linkedlists;

public class FindIfPalindrome {

	public static void main(String[] args) {
		
		int[] a={2,3,4, 3,4};
		Node head;
		Node temp = null;
		for(int i=a.length-1;i>=0;i--){
			Node n = new Node(a[i], temp);
			temp = n;
		}
		head = temp;
		//print(head);
		System.out.println(isPalindrome(head));
		System.out.println();
		//head = reverse(head);
		//print(head);
		
	}
	
	static boolean isPalindrome(Node head){
		Node runner = head;
		Node curr = head;
		while(runner.next!=null){
			if(runner.next.next==null)
				break;
			runner=runner.next.next;
			curr = curr.next;
			//System.out.println(curr.data );
		}
		//System.out.println(curr.data);
		curr.next = reverse(curr.next);
		//print(head);
		Node midway = curr.next;
		curr = curr.next;
		while(curr!=null && head!=midway){
			if(curr.data!=head.data){
				return false;
			}
			head = head.next;
			curr=curr.next;
			
		}
		
		
		return true;
	}
	
	static Node reverse(Node head){
		Node prev = null;
		Node curr = head;
		Node next = (curr.next!=null)?curr.next:null;
		while(next!=null){
			curr.next = prev;
			prev = curr;
			curr=next;
			next=next.next;
		}
		curr.next = prev;
		head = curr;
		return head;
	}
	
	static void print(Node head){
		while(head!=null){
			System.out.print(head.data);
			head = head.next;
		}
	}
	
}

