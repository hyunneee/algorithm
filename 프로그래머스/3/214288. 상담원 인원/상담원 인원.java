import java.util.*;
import java.io.*;

class Solution {
    public static int minWaitTime = Integer.MAX_VALUE;
    public static int[] dist;
    public int solution(int k, int n, int[][] reqs) {
        dist = new int[k+1];
        backtrack(k,1,n,reqs);
        return minWaitTime;
    }
    
    public void backtrack(int k, int typeIdx, int remain,int[][] reqs){
        if(typeIdx == k+1){
            // for(int i=1;i<=k;i++){
            //     System.out.print(distribution[i]);                
            // }
            // System.out.println();
            int totalTime = calcul(k,dist,reqs);
            minWaitTime = Math.min(minWaitTime, totalTime);
            return ;
        }
        
        // [마지막 유형 처리] 마지막은 남은 인원을 다 몰아줘야 함
        if (typeIdx == k) {
            dist[typeIdx] = remain;
            backtrack(k, typeIdx + 1, 0,reqs);
            return;
        }
        
        int maxForThisType = remain - (k - typeIdx);
        
        for(int i=1;i<=maxForThisType;i++){
            dist[typeIdx] = i;
            backtrack(k,typeIdx + 1, remain - i,reqs);
        }
    }
    
    public int calcul(int k, int[] dist,int[][] reqs){
        int totalWaitTime = 0;
        PriorityQueue<Integer>[] pqs = new PriorityQueue[k+1];
        for(int i=1;i<=k;i++){
            pqs[i] = new PriorityQueue<>();
            for(int j=0;j<dist[i];j++){
                pqs[i].add(0);
            }
        }
        
        for(int[] req : reqs){
            int start = req[0];
            int duration = req[1];
            int type = req[2];
            
            int earlyft = pqs[type].poll();
            
            if(earlyft <= start){
                pqs[type].add(start+duration);
            } else{
                int wait = earlyft - start;
                totalWaitTime += wait;
                pqs[type].add(earlyft+duration);
            }
        }
        return totalWaitTime;
    }
}