Input_Num = eval(input())
Acm_Number = []

for i in range(Input_Num) :
    Acm_H, Acm_W, Acm_P = map(int, input().split())

    Cnt = 0

    for j in range(1, Acm_W + 1) :
        for k in range(1, Acm_H + 1) :
            if Cnt == Acm_P : 
                Acm_H = k - 1
                break
            else : Cnt += 1

        if Cnt == Acm_P :
            Acm_W = j 
            Cnt = 0
            break

    Acm_Number.append(Acm_W + Acm_H * 100)

for i in range(Input_Num) : print(Acm_Number[i])