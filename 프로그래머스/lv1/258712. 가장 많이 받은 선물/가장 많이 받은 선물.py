def solution(friends, gifts):
    cur_list =  []
    gift_score = []
    next_year = [0] * len(friends)
    dict1 = {}
    for idx, values in enumerate(friends):
            dict1[values] = idx
            cur_list.append([0] * len(friends))
            gift_score.append([0,0])
    
    for i in gifts:
        give = dict1[i.split(" ")[0]]
        take = dict1[i.split(" ")[1]]
        
        cur_list[give][take] = cur_list[give][take] + 1
        
        gift_score[give][0] += 1
        gift_score[take][1] += 1
    
    for i in range(0,len(friends)):
        for j in range(i+1,len(friends)):
            if (cur_list[i][j] > cur_list[j][i]): # i가 j에게 선물을 더 많이 줌 i->j
                next_year[i] += 1
            elif cur_list[i][j] < cur_list[j][i]: # j가 i에게 선물을 더 많이 줌 j->i
                next_year[j] += 1
            else:
                sc_i = (gift_score[i][0] - gift_score[i][1])
                sc_j = (gift_score[j][0] - gift_score[j][1])
                if sc_i > sc_j :
                    next_year[i] += 1
                elif sc_i < sc_j :
                    next_year[j] += 1
                else:
                    pass
    return max(next_year)