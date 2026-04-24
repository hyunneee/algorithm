import java.io.*;
import java.util.*;

public class Main {
	public static class minHeap {
		private ArrayList<Integer> heap;
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); //insert idx 0 to start from 1
		}
		public void insert(int val) {
			heap.add(val);
			int p =heap.size()-1;
			// heap size-1 이 1보다 작아질 때까지 진행 -> root 로 이동 
			while(p>1 && heap.get(p/2) > heap.get(p)) {
				int tmp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, tmp);
				p=p/2; //p는 부모 값으로 변경 
			}
		}
		public int del() {
			//힙 사이즈-1 이 1보다 작으면 0 리
			if(heap.size()-1<1) {
				return 0;
			}
			//삭제할 노드는 루트노드 
			int delItem = heap.get(1);
			//루트에가장마지막 값 넣고 마지막 값 삭제 
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while((pos*2)<heap.size()){
				int min = heap.get(pos*2);
				int minpos = pos *2;
				if(((pos*2+1)<heap.size()) && min > heap.get(pos*2+1)) {
					min = heap.get(pos*2+1);
					minpos = pos*2+1;
				}
				
				if(heap.get(pos) < min)
					break;
				
				//부모 자식노드 교환
				int tmp =heap.get(pos);
				heap.set(pos, heap.get(minpos));
				heap.set(minpos, tmp);
				pos=minpos;
			}
			return delItem;	
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		minHeap heap = new minHeap();
		
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) 
				System.out.println(heap.del());
			else
				heap.insert(x);
		}
	}
}
		
		

