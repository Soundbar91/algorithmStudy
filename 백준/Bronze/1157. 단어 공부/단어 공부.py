Input_String = input()
Num_Arr = [0] * 26

for i in range(len(Input_String)) :
    Num_Arr[ord(Input_String[i].upper()) - 65] += 1

Max_Num = 0
Max_Index = 0
Cnt = 0

for i in range(0, len(Num_Arr)) :
    if Max_Num < Num_Arr[i] : 
        Max_Num = Num_Arr[i]
        Max_Index = i

for i in range(0, len(Num_Arr)) :
    if i != Max_Index and Max_Num == Num_Arr[i] : Cnt = 1

if Cnt == 1 : print("?")
else : print(chr(Max_Index + 65))