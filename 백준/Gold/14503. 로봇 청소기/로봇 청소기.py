# 로봇청소기
N,M = list(map(int,input().split(" ")))
r,c,d = list(map(int,input().split(" ")))
rc = [list(map(int,input().split(" "))) for n in range(N)]
dr = [-1,0,1,0]
dc = [0,1,0,-1]

cnt = 0 
notfound = True
while(notfound):
    if rc[r][c] == 0:
        rc[r][c] = -1
        cnt += 1
    cleaned = False
    for i in range(4):
        d = (d-1) % 4
        nr = r + dr[d]
        nc = c + dc[d]
        if (rc[nr][nc] == 0) or (nr == N-1 and nc==M-1):
            r = nr
            c = nc
            cleaned = True
            break
    
    if not cleaned:
        r = r+dr[d]*(-1)
        c = c+dc[d]*(-1)
        if rc[r][c] == 1 or (r == N-1 and c==M-1):
            notfound = False
            break
print(cnt)