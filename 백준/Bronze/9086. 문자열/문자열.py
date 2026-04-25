Num = eval(input())
Arr_String = []

for i in range(Num) :
    In_String = input()
    
    Arr_String.append(In_String[0])
    Arr_String.append(In_String[len(In_String) - 1])

for i in range(0, Num * 2, 2) :
    print(Arr_String[i], end="")
    print(Arr_String[i + 1])