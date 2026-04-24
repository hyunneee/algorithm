import java.io.*;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    static String[][] numpan; //숫자판
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
           
        numpan = new String[5][5];
        for (int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<5;j++){
                numpan[i][j] = st.nextToken();
            } 
        }
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                dfs(numpan,i,j,0,numpan[i][j]);
            } 
        }
        
        System.out.println(list.size());
    }

    public static void dfs(String[][] num,int x,int y,int cnt,String tmp){
        if(cnt==5){
            if(!list.contains(tmp))
                list.add(tmp);
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx && nx <5 && 0<= ny && ny <5)
                dfs(num,nx,ny,cnt+1,tmp+num[nx][ny]); 
        }

    }
}