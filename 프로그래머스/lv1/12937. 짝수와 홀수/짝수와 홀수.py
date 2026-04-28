def solution(num):
    answer = ''
    if num%2: # 홀수 
        answer = 'Odd'
    else: # 짝수 나누어 떨어짐
        answer = 'Even'
    return answer