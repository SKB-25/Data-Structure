package Graph;

import java.util.Scanner;

public class DepthFirstTraversal { 

    static Scanner sc = null;

    public static void main(String[] args) {
         
        sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] adjMatrix = new int[v][v];
        for(int i = 0; i<e; i++){
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();
            adjMatrix[val1][val2] = 1 ;
            adjMatrix[val2][val1] = 1;
        } 
        dfsTraversal(adjMatrix);
        
    }
    public static void dfsTraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        dfsTraversal(adjMatrix , visited , 0);
    }

    private static void dfsTraversal(int[][] adjMatrix, boolean[] visited, int currIndex) {
        visited[currIndex] = true;
        System.out.println(currIndex + " ");
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currIndex][i] == 1 && !visited[i]){
                   dfsTraversal(adjMatrix,visited , i);
            }
        }
    }
}
