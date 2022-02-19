import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class Node {
        int r;
        int c;
        Node parent;
        
        Node (int r, int c, Node parent) {
            this.r = r;
            this.c = c;
            this.parent = parent;
        }
    }
    
    static void dfs(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid) {
        Stack<Node> stack = new Stack();
        Stack<Node> path = new Stack();
        ArrayList<Node> explored = new ArrayList<Node>();
        boolean[][] visited = new boolean[r][c];
        Node goal = null;
        
        Node init = new Node(pacman_r, pacman_c, null);
        stack.push(init);        
        
        while(!stack.isEmpty()) {       
            Node curr = stack.pop();            
            visited[curr.r][curr.c] = true;
            explored.add(curr);
            
            if(grid[curr.r].charAt(curr.c) == '.') {
                goal = curr;
                break;
            }     
            
            if(curr.r-1 >= 0 && !visited[curr.r-1][curr.c] && grid[curr.r-1].charAt(curr.c) != '%') {
                Node newNode = new Node(curr.r-1, curr.c, curr);
                visited[curr.r-1][curr.c] = true;
                stack.push(newNode);                
            }
            if(curr.c-1 >= 0 && !visited[curr.r][curr.c-1] && grid[curr.r].charAt(curr.c-1) != '%') {
                Node newNode = new Node(curr.r, curr.c-1, curr);
                visited[curr.r][curr.c-1] = true;
                stack.push(newNode);                
            }
            if(curr.c+1 < c && !visited[curr.r][curr.c+1] && grid[curr.r].charAt(curr.c+1) != '%') {
                Node newNode = new Node(curr.r, curr.c+1, curr);
                visited[curr.r][curr.c+1] = true;
                stack.push(newNode);                
            }
            if(curr.r+1 < r && !visited[curr.r+1][curr.c] && grid[curr.r+1].charAt(curr.c) != '%') {
                Node newNode = new Node(curr.r+1, curr.c, curr);
                visited[curr.r+1][curr.c] = true;
                stack.push(newNode);                
            }
        }
        
        Node curr = goal;
        while(curr != null) {
            path.push(curr);
            curr = curr.parent;
        }
        
        System.out.println(explored.size());
        for(Node node : explored) {
            System.out.println(node.r + " " + node.c);
        }
        System.out.println(path.size() - 1);
        while(!path.isEmpty()) {
            curr = path.pop();
            System.out.println(curr.r + " " + curr.c);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();

        int food_r = in.nextInt();
        int food_c = in.nextInt();

        int r = in.nextInt();
        int c = in.nextInt();
    
        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        dfs( r, c, pacman_r, pacman_c, food_r, food_c, grid);
    }
}
