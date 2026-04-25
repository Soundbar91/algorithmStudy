Arr_Size, Std_Num = map(int, input().split())
Arr = list(map(int, input().split()))

for i in range(0, Arr_Size) : 
    if Arr[i] < Std_Num : print(Arr[i], end = " ")