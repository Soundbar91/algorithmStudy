x1 = [0] * 1001
y1 = [0] * 1001

for i in range(3) :
    num1, num2 = map(int, input().split())
    x1[num1] += 1
    y1[num2] += 1

x = 0
y = 0

for i in range(1001) :
    if x1[i] == 1 : x = i
    if y1[i] == 1 : y = i

print(x, y)