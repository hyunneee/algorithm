def solution(array):
    answer = 0
    middle = len(array)//2
    array.sort()
    answer = array[middle]
    return answer