def solution(s):
    answer = []
    # s = list(s)
    cnt = 0
    zero_sum = 0
    while s != "1":
        zero_sum+= s.count("0")
        s_length = bin(len(s.replace("0","")))
        s = s_length.lstrip("0b")
        cnt += 1
    answer.append(cnt)
    answer.append(zero_sum)
    return answer