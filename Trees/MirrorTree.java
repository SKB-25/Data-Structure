package Trees;


import java.util.ArrayList;
import java.util.Scanner;

class Node<T>{
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MirrorTree {
    
    static Scanner sc = null;

    public static Node<Integer> createTree(){
         sc = new Scanner(System.in);
         
         
         int rootData = sc.nextInt();

         if(rootData == -1){
            return null;
         }

         Node<Integer> root = new Node<Integer>(rootData);
         System.out.print("Enter Left child Of " + rootData + " : ");
         root.left = createTree();
         System.out.print("Enter right child Of " + rootData + " : ");
         root.right = createTree();

         return root;
    }

    public static void print(Node<Integer> root){
          if(root == null){
            return;
          }
          System.out.print(root.data + ":");
          if(root.left != null){
            System.out.print("L - " + root.left.data);
          }
          if(root.right != null){
            System.out.print(", R - " + root.right.data);
          }
          System.out.println();
          print(root.left);
          print(root.right);
    }

    public static Node<Integer> mirror(Node<Integer> root){

        if( root == null){
            return root;
        }

        mirror(root.left);
        mirror(root.right);
        Node<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static ArrayList<Integer> InorderTraversal(Node<Integer> root){

        ArrayList<Integer> result = new ArrayList<Integer>();
        Node<Integer> curr , prev ;

        if(root == null){
            return result;
        }

        curr = root;
        while(curr!=null){
            if(curr.left == null){
                 result.add(curr.data);
                 curr = curr.right;
            }
            else{
                prev = curr.left;
                while(prev.right != null && prev.right!= curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
          
        Node<Integer> root = createTree();
        System.out.println();
        print(root);
        System.out.println();
        System.out.print("InOrder Traversal : ");
        ArrayList<Integer> result = InorderTraversal(root);
        for(int val : result){
            System.out.print(val + " ");
        }
        Node<Integer> temp = mirror(root);
        System.out.println();
        print(temp);
        System.out.println();
        System.out.print("InOrder Traversal : ");
        ArrayList<Integer> result1 = InorderTraversal(temp);
        for(int val : result1){
            System.out.print(val + " ");
        }

    }
    
}
