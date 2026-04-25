Input_N, Input_M = map(int, input().split())
list_N = list(map(int, input().split()))
list_Sum = []
list_Out = []

for i in range(Input_N - 2) :
    for j in range(i + 1, Input_N - 1) :
        for k in range(j + 1, Input_N) :
            list_Sum.append(list_N[i] + list_N[j] + list_N[k])

for i in range(len(list_Sum)) :
    if list_Sum[i] <= Input_M :
        list_Out.append(list_Sum[i])

print(max(list_Out))