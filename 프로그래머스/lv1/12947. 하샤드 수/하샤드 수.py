def solution(x):
    answer = True
    sum = 0
    x_val = x
    while x_val>0:
        sum += x_val%10
        print(sum)
        x_val = x_val // 10
    if x%sum==0:
        answer = True
    else:
        answer = False
    return answer