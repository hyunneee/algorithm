import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));            StringTokenizer st=new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<String>();

        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int[][] arr = new int[2001][2001];
        int cnt=0;
        //bw.write(a+" "+b+"\n");
            
            
        for(int i=x;i<=y;i++){
            for(int j=0;j<i;j++){
                int temp;
                int a=i,b=j;
                while(b!=0){
                    temp = a%b;
                    a=b;
                    b=temp;
                }                    
                if(arr[j/a][i/a]==0){
                    cnt++;
                    arr[j/a][i/a]=1;
                }
                //String str=j/a+"/"+i/a;
                //set.add(str);
                //bw.write(set+"\n");
            }
        } 
        bw.write(cnt+"\n");           
        //bw.write(set.size()+"\n");
        bw.flush();
        br.close();
        bw.close();        
        }
}
