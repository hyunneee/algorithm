def solution(s):
    answer = 0
    plus = 1
    for idx, i in enumerate(s):
        if(i == '-'):
            plus = -1
        elif(i == '+'):
            plus = 1
        else:
            s_s = int(i) * (10 ** (len(s)-1-idx))
            answer += s_s
    answer *= plus
    return answer