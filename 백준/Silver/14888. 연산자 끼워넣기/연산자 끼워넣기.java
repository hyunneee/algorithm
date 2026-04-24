import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = Integer.MIN_VALUE; //최댓값
    public static int MIN = Integer.MAX_VALUE; //최솟값
    public static int[] operation = new int[4]; //연산자 개수
    public static int[] num; //숫자
    public static int n; //숫자 개수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++){
            operation[i] = Integer.parseInt(st.nextToken());
        }
        dfs(num[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int number,int idx){
        if(idx==n){
            MAX = Math.max(MAX,number);
            MIN = Math.min(MIN,number);
            return;
        }
        for (int i=0;i<4;i++){
            if(operation[i]>0){
                operation[i]--;
                switch(i){
                    case 0: dfs(number+num[idx],idx+1); break;
                    case 1: dfs(number-num[idx],idx+1); break;
                    case 2: dfs(number*num[idx],idx+1); break;
                    case 3: dfs(number/num[idx],idx+1); break;
                
                }
                operation[i]++;
            }

        }
    }
    
}
