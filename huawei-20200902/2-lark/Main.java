import java.util.*;

public class Main{
    public static void dfs(char[][] p, int i, int j, int m, int n, int[][] q){
        //up
        if(i>=1 && p[i-1][j]=='S' && q[i-1][j]!=1){
            q[i-1][j]=1;
            dfs(p,i-1,j,m,n,q);
        }
        //left
        if(j>=1 && p[i][j-1]=='S' && q[i][j-1]!=1){
            q[i][j-1]=1;
            dfs(p,i,j-1,m,n,q);
        }
        //down
        if(i<m-1 && p[i+1][j]=='S' && q[i+1][j]!=1){
            q[i+1][j]=1;
            dfs(p,i+1,j,m,n,q);
        }
        //right
        if(j<n-1 && p[i][j+1]=='S' && q[i][j+1]!=1){
            q[i][j+1]=1;
            dfs(p,i,j+1,m,n,q);
        }
        return;
    }
    public static int find(char[][] p,int m, int n){
        if(p==null || m<=0 || n<=0) return 0;
        int[][] q = new int[m][n]; 
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(p[i][j]=='S' && q[i][j]!=1){
                    q[i][j]=1;
                    count++;
                    dfs(p,i,j,m,n,q);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] mn = in.nextLine().split(",");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        if(m<=0||n<=0) return;
        char[][] p = new char[m][n];
        for(int i =0; i<m; i++){
            String s = in.nextLine();
            for(int j=0; j<n; j++){
                p[i][j]=s.charAt(j);
            }
        }
        // for(int i =0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.println(p[i][j]);
        //     }
        // }
        System.out.println(find(p,m,n));
    }
}