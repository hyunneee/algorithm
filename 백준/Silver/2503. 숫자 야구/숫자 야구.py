# 숫자 야구
from itertools import permutations
perm = list(permutations(['1','2','3','4','5','6','7','8','9'],3))
# print(perm)
# print(len(perm))
# print(type(perm))
N = int(input())
S = []
B = []
nlist = []
for i in range(0,N):
    n, s,b = list(map(int,input().split(" ")))
    nlist.append(list(str(n)))
    S.append(s)
    B.append(b)
# print(S,B,n)
# print(S,B)
# print(nlist)
result = 0 
for p in perm:
    # perm 1,2,3~9,8,7까지
    # print("perm",p)
    for i in range(len(nlist)):
        # 입력받은 nlist 
        # print("i",i)
        strike = 0
        ball = 0
        for k in range(3):
            if str(p[k]) == nlist[i][k]:
                strike+=1
            elif nlist[i][k] in str(p):
                ball += 1
        if strike != S[i] or ball != B[i]:
            break
        if i == (len(nlist)-1):
            # print(p)
            result+=1
    # break
print(result)