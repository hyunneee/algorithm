def solution(num_list):
    answer = []
    odd = 0
    even = 0
    for num in num_list:
        if(num%2): #홀수
            odd += 1 
        else: #짝수
            even += 1
    answer.append(even)
    answer.append(odd)
    return answer