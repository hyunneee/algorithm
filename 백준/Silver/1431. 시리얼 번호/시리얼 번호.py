
n = int(input())
num_list = list(input() for _ in range(n))
for i in range(n-1):
    for j in range(i+1,n):
        if(len(num_list[i])>len(num_list[j])):
            temp=num_list[i]
            num_list[i]=num_list[j]
            num_list[j]=temp
            #print(num_list[i],num_list[j])

        elif(len(num_list[i])==len(num_list[j])):
            cntx=0
            cnty=0
            for x,y in zip(num_list[i],num_list[j]):
                if x.isdigit():
                    cntx+=int(x)
                if y.isdigit():
                    cnty+=int(y)
            if(cntx>cnty):
                temp=num_list[i]
                num_list[i]=num_list[j]
                num_list[j]=temp
            elif(cntx==cnty):
                for x,y in zip(num_list[i],num_list[j]):
                    if(x>y):
                        temp=num_list[i]
                        num_list[i]=num_list[j]
                        num_list[j]=temp
                        break
                    elif x<y:
                        break
for i in num_list:
    print(i)
