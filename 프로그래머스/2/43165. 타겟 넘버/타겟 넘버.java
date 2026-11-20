class Solution {
    public int[] values; 
    public int goal = 0, answer = 0;

    public int solution(int[] numbers, int target) {
        values = numbers;
        goal = target;
        
        bfs(0,0);
        return answer;
    }
    
    public void bfs(int idx, int sum){
        if(idx == values.length){
            if(sum == goal){
                answer++;
            }
            return ;
        }
        
        bfs(idx+1, sum + values[idx]);
        bfs(idx+1, sum - values[idx]);
    }
}