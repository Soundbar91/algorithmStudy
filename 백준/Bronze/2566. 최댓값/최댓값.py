Col = 9

Num_Arr = [list(map(int, input().split())) for _ in range(Col)]
Num_Max = Num_Arr[0][0]
Col_Max = 0
Row_Max = 0

for i in range(Col) :
    for j in range(len(Num_Arr[0])) :
        if Num_Max < Num_Arr[i][j] :
            Num_Max = Num_Arr[i][j]
            Col_Max = i
            Row_Max = j

print(Num_Max)
print(Col_Max + 1, end = " ")
print(Row_Max + 1, end = "")