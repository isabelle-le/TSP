package TSP;

import java.util.Scanner;
import java.util.Stack;
import com.sun.xml.internal.bind.v2.util.StackRecorder;

/**
 * This is travelling salesman problem TSP apply Greedy algorithm
 * Loading input: get from users input
 * 
 * @author Le Thu Huong
 * Reference site:http://www.sanfoundry.com/java-program-implement-traveling-salesman-problem-using-nearest-neighbour-algorithm/
 */

public class TSP {

	public static void main(String[]arg) {
		
		// Loading inputs and get preparations
		int n;
		System.out.println("Enter the number of nodes: ");
        Scanner scan = new Scanner(System.in);
        n =scan.nextInt();
        int matrix[][] = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=n;j++){
        		if(i!=j){
		        System.out.print("Enter weight of "+(i)+" to "+(j)+":=>");
		        matrix[i][j]=scan.nextInt();
        		}
        	}
        }
               
        System.out.println("###################################");
        System.out.println("Starting node is assumed at node 1");
        System.out.println("The citys are visited as follows:");
        
        scan.close();
      
        
        
        
        /**
         * Travelling salesman algorithm starts
         */
        
        //initialise all variable
        final int INFINITY = 1000; 
        int[] visited = new int[n+1];
        Stack<Integer> stack = new Stack<Integer>();
        int element;
        int nextNode = 0;
        boolean minFlag = false;
        
        /**
         * STEP 1 :  starting node is assumed at 1
         */
        visited[1] = 1; 
        stack.push(1);
        System.out.print(1 + "\t");
        
        while (!stack.isEmpty()){
            element = stack.peek();
            int min = INFINITY;
            
            
            /**
             * STEP 2 :find a way to reach node
        	 * if the node is reachable (positive weight and not visited)
        	 * if distance( between  the element and node c) is smaller than infinity, so we update this new value
        	 * remember the node c
        	 * Keep doing it with all the assigned node as user inputs
        	 */
            for(int c = 1; c <= n; c++){
            
                if (matrix[element][c] > 1 && visited[c] == 0){ 
                    if (min > matrix[element][c]){
                        min = matrix[element][c]; 
                        nextNode = c;
                        minFlag = true;
                    }
                }
                
            }
            
            
            /**
             * STEP 3,4:
             * Set current node as visited and pushed it onto top of the stack 
             * if all the edge are visited, then terminate
             */
            if (minFlag){
                visited[nextNode] = 1;
                stack.push(nextNode);
                System.out.print(nextNode + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        
        // TSP ended
	}
}






/**
 * Testing
 * 
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.println(i+"," +j+" || "+ matrix[i][j]);
                	  System.out.println();
            }
            System.out.println();
        }
        
*/
