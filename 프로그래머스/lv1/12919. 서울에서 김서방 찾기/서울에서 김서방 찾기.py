def solution(seoul):
    answer = ''
    # x = [i for i in range(len(seoul)) if seoul[i] == 'Kim']
    # answer = f'김서방은 {x[0]}에 있다'
    for idx, val in enumerate(seoul):
        if val == 'Kim':
            answer = f"김서방은 {idx}에 있다"
    return answer