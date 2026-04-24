//11723 집합

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		boolean sbool[] = new boolean[21]; //true가 디폴트 없음 
		Arrays.fill(sbool,true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int j;
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	String input = st.nextToken();
			switch(input) {
				case "add" :
					j= Integer.parseInt(st.nextToken());
					sbool[j]=false; //있음
					break;
				case "remove" :
					j= Integer.parseInt(st.nextToken());
					sbool[j]=true; //없음 
					break;
				case "check": 
					j= Integer.parseInt(st.nextToken());
					if(sbool[j]==true) {
						//없음 0 
						sb.append("0\n");
					}
					else if(sbool[j]==false) {
						sb.append("1\n");
						//System.out.println(sbool[j]); // 있음 1
					}
					break;
				case "toggle": 
					j= Integer.parseInt(st.nextToken());
					if(sbool[j]==true) {
						//없음
						sbool[j]=false; // 추가 
					}else {
						sbool[j]=true; //제거 
					}
					break;
				case "all":
					for(j=1;j<=20;j++) {
						sbool[j]=false; //있음 
					}
					break;
				case "empty": 
					for(j=1;j<=20;j++) {
						sbool[j]=true; //없음 
					}
					break;
			}
			
		}
        
        System.out.print(sb.toString());
        br.close();
        
	}
}
