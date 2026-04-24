nanj=list()
for i in range(9):
    nanj.append(int(input()))
sum_list=sum(nanj)
fin=0
for i in range(0,10):
    num=sum_list
    num-=nanj[i]
    for j in range(i+1,9):
        if(num-nanj[j]==100):
            idx_i=i
            idx_j=j
            fin=-1
            break
        else:
            continue
    if(fin==-1):
        break
fake_a=nanj[idx_i]
fake_b=nanj[idx_j]
nanj.remove(fake_a)
nanj.remove(fake_b)      
nanj.sort()
for i in nanj:
    print(i)