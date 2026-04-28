def solution(str1):
    str_list = list(str1.lower())
    idx = 0
    for i in range(len(str_list)):
        str_list[idx] = str_list[idx].upper()
        if str_list[i] == ' ':
            idx = i+1
    answer = ''.join(str_list)
    return answer