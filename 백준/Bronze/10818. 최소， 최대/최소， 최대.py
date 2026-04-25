Arr_Size = int(input())
Arr = list(map(int, input().split()))
Min = Arr[0]
Max = Arr[0] 

for i in range(1, Arr_Size) :
    if Min > Arr[i] : Min = Arr[i]
    if Max < Arr[i] : Max = Arr[i]

print(Min,Max)