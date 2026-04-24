def moving(diir,d,x,y,m):
    if diir<0 or diir>3:
        diir=diir%4
    if diir==0: #방향이 0이면 x+
        x+=d
        #print(x,y)
    elif diir==1: #방향이 1이면 y+
        y+=d
        #print(x,y)
    elif diir==2: #방향이 2이면 x-
        x-=d
        #print(x,y)
    elif diir==3: #방향이 3이면 y-
        y-=d
        #print(x,y)
    if(x>m or y>m or x<0 or y<0): #m의 범위에 1개라도 넘어가면 -1 반환, 끝내기 
            print("-1")
            sys.exit()
    return x,y #평소에는 x,y 반환해주기 


import sys

m,n=map(int,input().split()) #m,n 입력
diir=0
x=0
y=0
for i in range(n): #n만큼의 명령어 입력 받기 위한 반복문 
    order=input().split() #명령어 입력
    if order[0]=='MOVE': #명령어가 move일때 
        x,y=moving(diir,int(order[1]),x,y,m)
    elif order[0]=='TURN': #명령어가 turn일때 
        if order[1]=='0':
            diir+=1 #방향 바꾸기 
        elif order[1]=='1':
            diir-=1 #방향 바꾸기 
print(x,y)
