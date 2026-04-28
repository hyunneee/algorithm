def solution(s):
    answer = ''
    s_list = []
    s_list = s.split(' ')
    s_list = [ int(i) for i in s_list ]
    # answer = min(s_list) + " " + max(s_list)
    
    return f"{min(s_list)} {max(s_list)}"