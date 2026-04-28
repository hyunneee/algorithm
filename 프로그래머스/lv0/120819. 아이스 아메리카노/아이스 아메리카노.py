def solution(money):
    answer = []
    ame = (money//5500)
    answer.append(ame)
    money = money%5500
    answer.append(money)
    return answer