import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            truck.offer(Integer.parseInt(st.nextToken()));   
        }
        int t=0;
        int bridgew=0;
        Queue<Integer> Bridge = new LinkedList<>();
        for(int i=0;i<w;i++){
            Bridge.add(0);
        }
        while(Bridge.size()!=0){
            t++;
            bridgew-=Bridge.poll();
            if(truck.size()!=0){
                if(bridgew+truck.peek()<=l){
                    bridgew+=truck.peek();
                    Bridge.offer(truck.poll());
                }else
                    Bridge.offer(0);
            }
        }
        System.out.println(t);
        br.close();
    }
}