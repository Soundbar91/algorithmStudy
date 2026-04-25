String_Arr = [list(input()) for i in range(5)]

for i in range(15) :
    for j in range(5) :
        if i < len(String_Arr[j]) : print(String_Arr[j][i], end = "")