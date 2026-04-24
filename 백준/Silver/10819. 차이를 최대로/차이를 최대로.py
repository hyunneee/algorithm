
from itertools import permutations
import sys
input = sys.stdin.readline

n=int(input()) #n 입력 
nums=list(map(int,input().split())) #nums 입력
per=permutations(nums) #조합 저장 
max=0 #최댓값 저장 

for nlist in per: #리스트마다 
    #print(nlist)
    sum=0
    for j in range(len(nlist)-1):
        sum+=abs(nlist[j]-nlist[j+1])#빼고 절댓값 씌운 값을 더해준다. 
    if sum>max: #만약 max보다 크면 갱신 
        max=sum
    #print(sum)
print(max) #max 구하기


