def solution(price):
    answer = 0
    if(price > 0 and price < 100000):
        answer = price
    elif(price<300000):
        answer = price * 0.95
    elif(price < 500000):
        answer = price * 0.90
    else:
        answer = price * 0.80
    answer = (answer//1)
    return answer