cnt = 0
n,m = map(int,input().split()) #듣도 n 보도 m 입력받기
nset = set()
mset = set()

for i in range(n):
    nset.add(input())

for j in range(m):
    mset.add(input())

result = sorted(list(nset & mset))

print(len(result))
for i in result:
    print(i)
