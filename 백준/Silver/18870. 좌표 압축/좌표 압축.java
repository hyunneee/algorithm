import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] sort = new int[n];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());
        }
		Arrays.sort(sort);
		Map<Integer, Integer> hashmap = new HashMap<>();
		int idx=0;
		for(int k : sort) {
			if(!hashmap.containsKey(k)) {
				hashmap.put(k,idx);
				idx++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int key : arr) {
			int rank = hashmap.get(key);
			sb.append(rank).append(' ');
		}
		System.out.println(sb);
		}
}
