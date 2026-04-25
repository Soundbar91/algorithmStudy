num = eval(input())
sum = list(range(num))

for i in range(0, num) :
    num1, num2 = input().split()
    num1, num2 = eval(num1), eval(num2)
    sum[i] = num1 + num2

for i in range(0, num) : print(sum[i])