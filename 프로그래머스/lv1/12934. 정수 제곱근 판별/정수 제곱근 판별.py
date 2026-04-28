import math
def solution(n):
    answer = 0
    an = int(math.sqrt(n))
    if an**2 == n:
        answer = (an+1)** 2
    else:
        answer = -1
    return answer