import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) ->
			Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1,o2) : Integer.compare(Math.abs(o1),Math.abs(o2)));
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) 
				
				System.out.println(queue.size()==0? 0:queue.poll());
			else
				queue.add(x);
		}
	}
}