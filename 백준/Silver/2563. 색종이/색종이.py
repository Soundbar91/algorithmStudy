Area_Arr = [[0 for i in range(100)] for j in range(100)]

Input_Num = eval(input())

for i in range(Input_Num) :
    Col, Row = map(int,input().split())

    for j in range(Col - 1, Col + 9) :
        for k in range(Row - 1, Row + 9) :
            if Area_Arr[j][k] != 0 : continue
            else : Area_Arr[j][k] += 1

Area_Sum = 0

for i in range(100) :
    for j in range(100) :
        Area_Sum += Area_Arr[i][j]

print(Area_Sum)