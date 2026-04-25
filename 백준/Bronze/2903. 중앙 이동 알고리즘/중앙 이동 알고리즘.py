Input_Num = int(input())
Sum_Dot = 4

for i in range(1, Input_Num + 1) :
    Sum_Dot += ((2 ** (i - 1)) * (2 + 2 ** i)) + (4 ** (i - 1))

print(Sum_Dot)