def solution(x, n):
    answer = []
    x_val = x
    while(n!=0):
        answer.append(x_val)
        x_val+=x
        n-=1
    return answer