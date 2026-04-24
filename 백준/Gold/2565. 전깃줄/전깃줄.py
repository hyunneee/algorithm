num = int(input())
lines = [ list(map(int,input().split(" "))) for i in range(num)]
lines.sort(key=lambda x:x[0])
B = [b for _,b in lines]

dp = [1] * num
for i in range(num):
    for j in range(i):
        if B[j] < B[i]:
            dp[i] = max(dp[i],dp[j]+1)
print(num - max(dp))