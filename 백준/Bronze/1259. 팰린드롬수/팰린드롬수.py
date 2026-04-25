Input_String = ""
List = []
cnt = 0

while (-1) :
    Input_String = input()
    if Input_String == "0" : break

    for i in range(0, len(Input_String) // 2) :
        if Input_String[i] != Input_String[(len(Input_String) - 1) - i] :
            List.append("no")
            cnt = 1
            break

    if cnt == 0 : List.append("yes")
    else : cnt = 0

for ch in List : print(ch)