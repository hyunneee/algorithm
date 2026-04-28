def solution(s):
    answer = True
    p_cnt = 0
    y_cnt = 0
    for i in s:
        if(i == 'p' or i == 'P'):
            p_cnt +=1
        if(i == 'y' or i == 'Y'):
            y_cnt +=1
    return (p_cnt == y_cnt)