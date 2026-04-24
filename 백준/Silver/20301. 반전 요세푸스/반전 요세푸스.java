import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> q = new ArrayDeque<>();
        int n =sc.nextInt();
        int k =sc.nextInt();
        int m =sc.nextInt();
        int cnt=0,mcnt=0;
        boolean clock=true;
                
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()!=0){
            int val=0;
            if(clock){
                val = q.pollFirst();  
            }
            else{
                val = q.pollLast();
            }
            cnt++;
            if(cnt==k){
                cnt=0;
                mcnt++;
                System.out.println(val);
                /*
                Iterator iter = q.iterator();
                while(iter.hasNext()) 
                    System.out.print(iter.next() + " ");
                System.out.println();
                */
            }else{
                if(clock){
                     q.offerLast(val);
                }
                else{
                    q.offerFirst(val);
                }
            }
            if(mcnt==m){
                mcnt=0;
                clock=!clock;
                }
            /*Iterator iter = q.iterator(); 
            while(iter.hasNext()) 
                    System.out.print(iter.next() + " ");
                System.out.println();
            */
        }
        //System.out.println(q.poll());
    }
}