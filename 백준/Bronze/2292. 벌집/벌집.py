Input_Num = int(input())
idx = 0
Min_Num = 2
Max_Num = 7

while (True) :
    if Input_Num == 1 : break

    if not Min_Num <= Input_Num <= Max_Num :
        idx += 1
        Min_Num += 6 * idx
        Max_Num += 6 * (idx + 1)
    else : 
        idx += 1
        break

print(idx + 1)