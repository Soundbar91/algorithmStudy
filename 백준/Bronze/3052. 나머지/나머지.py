Rest_List = []
Ok_List = []
Cnt = 0

for i in range(0, 10) :
    Num = eval(input())
    Rest_List.append(Num % 42)

for rest in Rest_List :
    if rest not in Ok_List:
        Ok_List.append(rest)

print(len(Ok_List))