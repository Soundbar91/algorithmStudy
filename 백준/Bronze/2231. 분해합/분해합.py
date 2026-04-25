Input_Num = eval(input())
Num = Input_Num
Out_List = []

while (Input_Num > 1) :
    Input_Num -= 1
    List = list(str(Input_Num))
    Sum = 0

    for i in range(len(List)) :
        Sum += int(List[i])

    if Sum + Input_Num == Num : Out_List.append(Input_Num)
    else : Sum = 0

if len(Out_List) == 0 : print("0")
else : print(min(Out_List))