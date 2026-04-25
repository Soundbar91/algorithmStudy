Output_List = []
while True :
    try :
        num1, num2 = map(int, input().split())
        if num2 % num1 == 0 : Output_List.append("factor")
        elif num1 % num2 == 0 : Output_List.append("multiple")
        else : Output_List.append("neither")
    except :
        break

for i in range(len(Output_List)) :
    print(Output_List[i])