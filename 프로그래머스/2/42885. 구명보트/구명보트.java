import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                // 두명 태워보낼 수 있음 
                left++;
                right--;
            } else {
                // 두명 못태움 무거운 애 한명 보냄 
                right--;
            }
            answer++;
        }
        return answer;
    }
}