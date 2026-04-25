Col, Row = map(int, input().split())

Num_Arr1 = []
Num_Arr2 = []
for _ in range(Col):
    Num_Arr1.append(list(map(int, input().split())))
for _ in range(Col):
    Num_Arr2.append(list(map(int, input().split())))

Sum_Arr = []
for i in range(Col):
    Sum_Arr.append([0] * Row)

for i in range(Col) :
    for j in range(Row) :
        Sum_Arr[i][j] = Num_Arr1[i][j] + Num_Arr2[i][j]

for i in range(Col) :
    for j in range(Row) :
        print(Sum_Arr[i][j], end = " ")
    print()