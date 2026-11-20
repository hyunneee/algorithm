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

// 종료 조건 
// 현재 idx가 numbers.length 이면서 
// 만약 target 이면 cnt++
// 아니면 return ; 
// 현재 현재 sum이 target을 넘어가면 return 

// 맨날 가져가야 하는건 sum, 현재 idx 