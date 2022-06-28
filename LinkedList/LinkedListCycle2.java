package LinkedList;

import java.io.IOException;
import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}

public class LinkedListCycle2 {
    
    static Scanner sc = null;

    public static void main(String args[]) throws IOException{
       Node head1 = createNode();
    //    printList(head1);
       System.out.println();
       Node head2 = createNode();
    //    printList(head2);
       System.out.println();
    //    Node cycle = cycle(head1, head2);
    //    Node slow = detectCycle(cycle);
    //    System.out.print(slow.data);

        Node result = addTwoList(head1, head2);
        printList(result);
    }


    
    public static Node cycle(Node head1 , Node head2){
        
        Node curr2 = head2;

        while(curr2.next!=null){
            curr2 = curr2.next;
        }

        Node curr1 = head1;
        Node prev = null;
        while(curr1.next.next!=null){
            prev = curr1;
            curr1 = curr1.next;
        }

        curr1.next = head2;
        curr2.next = prev;


        return head1;

    }
    

    //linkedList reverse function
    public static Node reverse(Node head){

        if(head == null){
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node nextptr = null;

        while(curr!=null){
            nextptr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextptr;
        }

        return prev;
    }
    

    //insert new node at tail
    public static Node  insert(Node head , Node tail , int val){
        System.out.println("ara hai");
        Node temp = new Node(val);
       

        if(head == null){
            head = temp;
            tail = temp;
           printList(head);
            return head;
        }
        else{
            tail.next = temp;
            tail = temp;
           }
         return head;
    }


    //Solve function for addition of two linkedlist data
    public static Node solve(Node temp1 , Node temp2){
       
        Node ansHead = null;
        Node tailHead = null;
        int carry = 0;
        
        while(temp1!=null || temp2!=null || carry!=0){

            int val1 =0;
            if(temp1!=null){
                val1 = temp1.data;
            }
            int val2 = 0;
            if(temp2!=null){
                val2 = temp2.data;
            }

            

            int sum = val1 + val2 + carry;
            int digit = sum%10;
            
           
            
            if(ansHead==null){
            ansHead = new Node(digit);
            tailHead = ansHead;
            }
            else{
                tailHead.next = new Node(digit);
                tailHead = tailHead.next; 
            }
            printList(ansHead);
           
            carry = sum/10;

            if(temp1!=null){
                temp1 = temp1.next;
            }

            if(temp2!=null){
                temp2 = temp2.next;
            }
        }
        
        return ansHead;
    }


    //Addition of two LinkedList function
    public static Node addTwoList(Node list1 , Node list2){

       
        Node temp1 = reverse(list1);
       
        Node temp2 = reverse(list2);
       
        Node result = solve(temp1, temp2);

        Node ans = reverse(result);
        

        return ans;
    }

    //Create function for Linkedlist
    public static Node createNode(){
        sc = new Scanner(System.in);

        System.out.println("Enter Node data :");
        int data = sc.nextInt();
        
        if(data == -1){  
         return null;
        }
        
        Node head = new Node(data);
        head.next = createNode();

        return head;
    }
   

    //Print function 
    public static void printList(Node head){
        System.out.println("print me aya tha");
        if(head == null){
            return;
        }

        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }

    public static Node detectCycle(Node head){
        
        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return slow;
            }
        }
        
        return null;
    }

}
