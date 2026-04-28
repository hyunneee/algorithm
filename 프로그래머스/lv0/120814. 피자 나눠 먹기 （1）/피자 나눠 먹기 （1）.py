def solution(n):
    answer = 0
    if(n%7): # True 나머지 있는 경우
        answer = (n//7) + 1
    else: # False 나머지 없는 경우
        answer = (n/7)
    return answer