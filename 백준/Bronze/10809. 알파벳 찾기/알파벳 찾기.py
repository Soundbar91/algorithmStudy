Input_String = input()
Arr_String = [-1] * 26

for i in range(len(Input_String)) :
    Num = ord(Input_String[i]) - 97
    if Arr_String[Num] != -1 : continue
    else : Arr_String[Num] = i

for i in range(len(Arr_String)) :
    print(Arr_String[i], end = " ")