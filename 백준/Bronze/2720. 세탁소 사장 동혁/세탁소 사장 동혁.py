Input_Num = int(input())
Cost_Arr = [[0 for i in range(4)] for i in range(Input_Num)]

for i in range(Input_Num) :
    Cost_Cent = int(input())
    idx = 0

    for j in [25, 10, 5, 1] :
        Cost_Arr[i][idx] = Cost_Cent // j
        Cost_Cent %= j
        idx += 1
    
    idx = 0

for i in range(Input_Num) :
    for j in range(4) :
        print(int(Cost_Arr[i][j]), end = " ")
    print()