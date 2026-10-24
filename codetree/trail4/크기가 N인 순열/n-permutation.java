import java.util.Scanner;
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n+1];
        choose(0);
    }

    public static void choose(int i){
        if(i == n){
            printNum();
            return ; 
        }

        for(int k=1;k<=n;k++){
            if(visited[k]) continue;
            visited[k] = true;
            arr[i] = k;
            choose(i+1);
            visited[k] = false;
        }
    }

    public static void printNum(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return ;
    }
}