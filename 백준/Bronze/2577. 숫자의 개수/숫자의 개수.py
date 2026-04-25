Sum_Num = 1
Arr_Num = [0] * 9
Zero_Cnt = 0

for i in range(0, 3) :
    Input_Num = eval(input())
    Sum_Num *= Input_Num

for i in range(len(str(Sum_Num))) :
    if str(Sum_Num)[i] == "0" : Zero_Cnt += 1
    else : Arr_Num[int(str(Sum_Num)[i]) - 1] += 1

print(Zero_Cnt)
for i in range(len(Arr_Num)) :
    print(Arr_Num[i])