list = []
while (True) :
    num1, num2, num3 = map(int, input().split())
    if num1 == num2 == num3 == 0 : break
    
    if not num1 < (num2 + num3) or not num2 < (num1 + num3) or not num3 < (num1 + num2) :
        list.append("Invalid")
    elif num1 == num2 == num3 : list.append("Equilateral")
    elif num1 == num2 or num2 == num3 or num1 == num3 : list.append("Isosceles")
    elif num1 != num2 != num3 : list.append("Scalene")

for i in range(len(list)) : print(list[i])