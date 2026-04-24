import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max_idx=0,min_idx=1000; 
        int[] arr=new int[1001];
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            arr[idx]=h;
            min_idx=Math.min(min_idx,idx);
            max_idx=Math.max(max_idx,idx);
        }
        Stack<Integer> rearr = new Stack<>();
        int height=arr[min_idx];
        for(int i=min_idx+1;i<=max_idx;i++){ //left
            if(arr[i]<height)
                rearr.push(i);
            else{
                while(rearr.size()!=0){
                    int p = rearr.pop();
                    arr[p]=height;
                }
                height=arr[i];
            }
        }
        rearr.clear();
        height=arr[max_idx];
        for(int i=max_idx-1;i>=min_idx;i--){
            if(arr[i]<height)
                rearr.push(i);
            else{
                while(rearr.size()!=0){
                    int p = rearr.pop();
                    arr[p]=height;
                }
                height=arr[i];
            }
        }
        int ans=0;
        for(int i=min_idx;i<=max_idx;i++){
            ans+=arr[i];
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}