Input_String = input()
Cnt = 0

for i in range(len(Input_String)) :   
    if Input_String[i] == " " and Input_String[i - 1] != " " : Cnt += 1

if Input_String[0] != " " and Input_String[len(Input_String) - 1] != " " : Cnt += 1
print(Cnt)