def solution(n):
    answer = 0
    gg = 10
    while(n>0):
        answer += (n%gg)
        n = n //gg
        
    return answer