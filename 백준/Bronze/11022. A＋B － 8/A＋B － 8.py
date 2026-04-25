Count_Num = int(input())
Num_A = []
Num_B = []
Num_Sum = []

for i in range(0, Count_Num) :
    n1, n2 = map(int, input().split())
    Num_A.append(n1)
    Num_B.append(n2)
    Num_Sum.append(n1 + n2)

for i in range(0, Count_Num) : 
    print("Case #{}: {} + {} = {}".format(i+1, Num_A[i], Num_B[i], Num_Sum[i]))