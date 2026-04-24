n=int(input()) #n 입력 
graph=[]
for i in range(n): #0,1 graph에 입력 
    graph.append(list(map(int,input())))

num=[] #각 단지 내 개수 넣어줄 리스트
cnt=0 #단지 내 개수 세기 
dx=[0,0,1,-1] #위아래좌우 
dy=[1,-1,0,0]

 
def dfs(x,y):
    global cnt
    if x<0 or x>=n or y<0 or y>=n:
        return False
    if graph[x][y]==1:
        cnt+=1
        graph[x][y]=0
        for i in range(4):
            dfs(x+dx[i],y+dy[i])
        return True
    
for i in range(n):
    for j in range(n):
        if dfs(i,j)==True: 
            num.append(cnt) #cnt num에 넣어주기 
            cnt=0
            
print(len(num)) #num 총 개수 
num.sort() #오름차순 정렬 
for i in num:
    print(i) # 단지 내 개수 세기 
