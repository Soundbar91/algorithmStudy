num1, num2, num3 = input().split()
num1 = eval(num1)
num2 = eval(num2)
num3 = eval(num3)

if num1 == num2 :
    if num1 == num3 :
        print(10000 + num1 * 1000)
    else : print(1000 + num1 * 100)
elif num1 == num3 : print(1000 + num1 * 100)
elif num2 == num3 : print(1000 + num2 * 100)
else : print(max(num1, num2, num3) * 100)