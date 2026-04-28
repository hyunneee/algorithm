def solution(n):
    answer = 0
    list = []
    while(n>0):
        list.append(n%10)
        n = (n//10)
    list.sort()
    ten = 1
    for i in list:
        answer += (i * ten)
        ten *= 10
    return answer