//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



  /* Function to print linked list */
   public static void printList(Node head)
    {
        
        while (head!= null)
        {
           System.out.print(head.data+" ");
           head = head.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
			Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
			
			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1,head2);
			printList(head);
			
			t--;
			
         }
    }
}

// } Driver Code Ends

/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    Node sortedMerge(Node head1, Node head2) {
        if(head1==null)
        return head2;
        if(head2==null)
        return head1;
        Node h1=head1,h2=head2,temp=null,res;
        while(h2!=null && h2.data<=h1.data){
            temp=h2;
            h2=h2.next;
        }
        if(temp!=null){
            temp.next=h1;
            res=head2;
        }
        else
        res=head1;
        while(h2!=null){
            while(h1!=null && h1.data<=h2.data){
                temp=h1;
                h1=h1.next;
            }
            if(h1==null){
                temp.next=h2;
                break;
            }
            temp.next=h2;
            h2=h2.next;
            temp.next.next=h1;
            temp=temp.next;
        }
        return res;
   } 
}
