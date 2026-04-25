num1, num2 = map(int, input().split())
list = []

for i in range(1, num1 + 1) :
    if num1 % i == 0 : list.append(i)

if len(list) < num2 : print("0")
else : print(list[num2 - 1])