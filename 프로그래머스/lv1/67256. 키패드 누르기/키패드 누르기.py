def solution(numbers, hand):
    answer = ''
    cur_l = [0,3]
    cur_r = [2,3]
    dict1 = {1:[0,0], 2:[1,0], 3:[2,0],
             4:[0,1], 5:[1,1], 6:[2,1],
             7:[0,2], 8:[1,2], 9:[2,2],
             0:[1,3]
            }
    for i in numbers:
        # print(i)
        if i in [1,4,7]:
            cur_l[0] = dict1[i][0]
            cur_l[1] = dict1[i][1]
            # print(dict1[i][0],dict1[i][1])
            answer += 'L'
            # print("left",i)
        elif i in [3,6,9]:
            cur_r[0] = dict1[i][0]
            cur_r[1] = dict1[i][1]
            answer += 'R'
            # answer.append('R')
            # print("right",i)
        else:
            gab_l = abs(cur_l[0] - dict1[i][0]) + abs(cur_l[1] - dict1[i][1])
            gab_r = abs(cur_r[0] - dict1[i][0]) + abs(cur_r[1] - dict1[i][1])
            if  gab_l > gab_r :
                answer += 'R'
                cur_r[0] = dict1[i][0]
                cur_r[1] = dict1[i][1]
            
                # answer.append('R')
            elif gab_l < gab_r:
                answer += 'L'
                cur_l[0] = dict1[i][0]
                cur_l[1] = dict1[i][1]
                # answer.append('L')
            else:
                if hand == "left":
                    answer += 'L'
                    cur_l[0] = dict1[i][0]
                    cur_l[1] = dict1[i][1]
            
                else:
                    answer += 'R'
                    cur_r[0] = dict1[i][0]
                    cur_r[1] = dict1[i][1]
            
            # print("middle",i)
    return answer