Input_Num = eval(input())
OX_Quiz = []
OX_Score = []

for i in range(Input_Num) :
    Input_Ox = input()
    OX_Quiz.append(Input_Ox)

for i in range(Input_Num) :
    Cnt = 0
    Score = 0

    for j in range(len(OX_Quiz[i])) :
        if OX_Quiz[i][j] == 'O' :
            Cnt += 1
            Score += Cnt
        
        elif OX_Quiz[i][j] == 'X' : Cnt = 0

    OX_Score.append(Score)

for i in range(Input_Num) : print(OX_Score[i])