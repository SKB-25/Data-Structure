package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstTraversal {
    
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        int[][] adjMatrix = new int[vertices][vertices];

        for(int i=0; i<edges; i++){
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();
            adjMatrix[val1][val2] = 1;
            adjMatrix[val2][val1] = 1;
        }
        bfsTraversal(adjMatrix);
    }

    private static void bfsTraversal(int[][] adjMatrix) {
        Queue<Integer> pending = new LinkedList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        visited[0] = true;
        pending.add(0);
        while(!pending.isEmpty()){
            int temp = pending.poll();
            System.out.print(temp + " ");

            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[temp][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
