package Trees;

import java.io.IOException;
import java.util.Scanner;

class TreeNode<T>{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        left = null;
        right = null;
    }
}

class PassNode<T>{
    T head;
    T tail;
}

class Node<T>{
    T data;
    Node<T> next;


    public Node(T data){
        this.data = data;
        next = null;
    }
}

public class BstToLL{

    static Scanner sc = null;
    public static void main(String args[]) throws IOException {
        TreeNode<Integer> root = createTree();
        Node<Integer> head = constructBst(root);

        while(head!=null){
            System.out.println(head.data + " ");
            head = head.next;
        }

    }
    
    public static Node<Integer> constructBst(TreeNode<Integer> root){
        
        PassNode<Node<Integer>> passNode = constructBstHelper(root);

        return passNode.head;
        
    }

    private static PassNode<Node<Integer>> constructBstHelper(TreeNode<Integer> root) {
        if(root == null){
              return new PassNode<Node<Integer>>();
        }

        if(root.left == null && root.right == null){
            PassNode<Node<Integer>> passNode = new PassNode<>();
            passNode.head = new Node<Integer>(root.data);
            passNode.tail = null;
            return passNode;

        }

        PassNode<Node<Integer>> passNodeLeft = constructBstHelper(root.left);
        PassNode<Node<Integer>> passNodeRight = constructBstHelper(root.right);
        PassNode<Node<Integer>> passNode = new PassNode<Node<Integer>>();
        Node<Integer> newHead = new Node<Integer>(root.data);

        if(passNodeLeft.head == null){
            passNode.head = newHead;
        }
        else{
            passNode.head = passNodeLeft.head;
        }

        if(passNodeLeft.tail == null){
            passNode.head.next = newHead;
            passNode.tail = newHead;
        }
        else{
            passNodeLeft.tail.next = newHead;
            passNode.tail = newHead;
        }

        if (passNodeRight.head!=null)
        {
        	passNode.tail.next=passNodeRight.head;
            passNode.tail=passNodeRight.head;
        }
        
        if(passNodeRight.tail!=null)
        {
        	passNode.tail=passNodeRight.tail;
        }
    
        return passNode;
    }

    private static TreeNode<Integer> createTree() {
        sc = new Scanner(System.in);

        int data = sc.nextInt();

        if(data==-1){
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(data);
        System.out.println("Enter left of : " + data);
        root.left = createTree();
        System.out.println("Enter right of :" + data);
        root.right = createTree();

        return root;
    }
}