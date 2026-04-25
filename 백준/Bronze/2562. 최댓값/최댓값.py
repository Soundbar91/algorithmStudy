Arr = []
Max_Num = int(0)
Max_Index = 0

for i in range(0, 9) :
    Arr.append(eval(input()))
    if Arr[i] > Max_Num : 
        Max_Num = Arr[i]
        Max_Index = i

print(Max_Num)
print(Max_Index + 1)