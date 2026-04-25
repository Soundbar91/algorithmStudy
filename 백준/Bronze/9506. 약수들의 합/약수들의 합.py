Input_Num = 0
list = [[] for j in range(100000)]
list_Num = []

while (True) :
    Input_Num = eval(input())
    if Input_Num == -1 : break
    else : list_Num.append(Input_Num)

    for i in range(1, Input_Num) :
        if Input_Num % i == 0 :
            list[Input_Num].append(i)


for i in range(len(list_Num)) :
    if sum(list[list_Num[i]]) == list_Num[i] :
        
        print(list_Num[i], "=", end = "")
        for j in range(len(list[list_Num[i]])) :
            print("",list[list_Num[i]][j], end = "")
            if j == len(list[list_Num[i]]) - 1 : break
            else : print(" +", end = "")
        print()

    else : print(list_Num[i], "is NOT perfect.")