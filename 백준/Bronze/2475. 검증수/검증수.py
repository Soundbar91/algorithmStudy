num1, num2, num3, num4, num5 = input().split()

num1 = eval(num1) ** 2
num2 = eval(num2) ** 2
num3 = eval(num3) ** 2
num4 = eval(num4) ** 2
num5 = eval(num5) ** 2

print((num1 + num2 + num3 + num4 + num5) % 10)