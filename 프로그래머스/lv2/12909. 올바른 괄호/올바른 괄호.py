def solution(s):
    answer = True
    tmp = []
    for i in (s):
        if i == ")" and "(" in tmp:
            tmp.pop()
        else:
            tmp.append(i)
        # print(tmp)
    if len(tmp) == 0:
        answer = True
    else:
        answer = False
    return answer