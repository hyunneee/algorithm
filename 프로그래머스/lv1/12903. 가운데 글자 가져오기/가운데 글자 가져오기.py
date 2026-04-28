def solution(s):
    answer = ''
    middle = len(s)//2
    if(len(s)%2):
        answer = s[middle]
    else:
        answer = s[middle-1:middle+1]
    return answer