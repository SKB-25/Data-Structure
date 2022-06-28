package Trees.Binary;

import java.util.Scanner;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class MorrisTraversal {
  static Scanner sc = null;

  public static void main(String args[]){
    TreeNode root = createTree();
    // inOrder(root);
    System.out.println();
    morrisTraversal(root);
  }

    public static TreeNode createTree(){
        sc = new Scanner(System.in);
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        TreeNode root = new TreeNode(data);
        System.out.println("Enter left of :" + data);
        root.left = createTree();
        System.out.println("Enter right of :" + data);
        root.right = createTree();
        
        return root;
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    } 

    public static void morrisTraversal(TreeNode root){
        
        TreeNode curr = root;
        TreeNode pre = null;
        if(root == null){
            return;
        }
        while(curr!=null){
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                pre = curr.left;
                while(pre.right!= null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }
    }

    

}
