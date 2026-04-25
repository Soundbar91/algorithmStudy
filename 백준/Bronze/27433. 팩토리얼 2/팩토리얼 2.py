def Factorial(Num):
    if Num < 2:
        return 1
    else:
        return Num * Factorial(Num-1)

print(Factorial(int(input())))