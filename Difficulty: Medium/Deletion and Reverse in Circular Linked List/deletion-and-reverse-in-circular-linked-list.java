//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if(head==null)
        return null;
        Node prev=null,curr=head;
        while(curr!=null){
            Node succ=curr.next;
            curr.next=prev;
            prev=curr;
            curr=succ;
        }
        return prev.next;
    }
    
    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        boolean flag=true;
        Node temp=head,prev=null;
        Set<Node> nodes=new HashSet<>();
        while(!nodes.contains(temp)){
            nodes.add(temp);
            if(flag && temp.data==key){
                if(prev==null)
                head=temp.next;
                else
                prev.next=temp.next;
                flag=false;
            }
            prev=temp;
            temp=temp.next;
        }
        if(head.data==key && prev.data==key)
        return null;
        prev.next=head;
        return head;
    }
}