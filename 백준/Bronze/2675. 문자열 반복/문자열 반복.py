Num = eval(input())
Out_String = []

for i in range(Num) :
    Repeat_Num, Repeat_String= input().split()
    Repeat_Num = int(Repeat_Num)
    
    result = ""
    for j in range(len(Repeat_String)) :
        result += Repeat_String[j] * Repeat_Num

    Out_String.append(result)
    
for i in range(Num) :
    print(Out_String[i])