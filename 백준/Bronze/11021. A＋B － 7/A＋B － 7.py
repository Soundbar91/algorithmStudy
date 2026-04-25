import sys
Count_Num = eval(input())
Num_Sum = []

for i in range(0, Count_Num) :
    n1, n2 = map(int, sys.stdin.readline().rstrip().split())
    Num_Sum.append(n1 + n2)

for i in range(1, Count_Num + 1) : 
    print("Case #", end="")
    print(i, end="")
    print(":",Num_Sum[i - 1])