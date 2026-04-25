Input_Num = eval(input())
Cnt = []

for i in range(1001) :
    for j in range(1001) :
        if 3 * i + 5 * j == Input_Num : Cnt.append(i+j)

if len(Cnt) == 0 : print(-1)
else : print(min(Cnt))