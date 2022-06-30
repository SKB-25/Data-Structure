package Trees.Binary;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree{
    static Scanner sc = null;

    //Main Function
    public static void main(String args[]) throws IOException{
        sc = new Scanner(System.in);
        Node root = createTree();
        printTree(root);
        System.out.println();

        printInorder(root);
        System.out.println();

        printPostOrder(root);
        System.out.println();

        levelOrder(root);
        
    }
    //Print Binary Tree in Pre-order
    public static void printTree(Node root){
     if(root == null){
         return;
     }
     System.out.print(root.data + " ");
     printTree(root.left);
     printTree(root.right);

    }
    //Print Binary Tree in In-Order
    public static void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    //Print Binary Tree in Post-Order
    public static void printPostOrder(Node root){
        if(root == null){
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    
    //Print Binary Tree in level Order
    static void levelOrder(Node root){

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            Node front = q.poll();
               
            System.out.print(front.data + " ");

            if(front.left!=null){
                q.add(front.left);
            }

            if(front.right!=null){
                q.add(front.right);
            }

        }
    }
     
    //Create function for Binary Tree
    public static Node createTree(){
        Node root = null;
        System.out.print("Enter data  : ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        root = new Node(data);
        System.out.println("Enter left node of " + data + ":");  
        root.left = createTree();
        
        System.out.println("Enter right node of " + data + ":");
        root.right = createTree();

        return root;

    }
}