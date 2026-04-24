# 도영이가 만든 맛있는 음식
from itertools import combinations
n = int(input())
sb_list = [list(map(int,input().split(" "))) for i in range(0,n)]
# print(n)
# print(sb_list)
# print()
sb_min = 1e90
for j in [combinations(sb_list,i) for i in range(1,n+1)]:
    for k in j:
        muls = 1
        plusb = 0
        for sk,bk in k:
            muls *= sk  
            plusb += bk
            sb_min = min(sb_min,abs(muls-plusb))
            # print("sb_min",sb_min)
print(sb_min)