Ang1 = eval(input())
Ang2 = eval(input())
Ang3 = eval(input())

if Ang1 == Ang2 == Ang3 == 60 : print("Equilateral")
elif Ang1 + Ang2 + Ang3 == 180 :
    if Ang1 == Ang2 or Ang2 == Ang3 or Ang1 == Ang3 :
        print("Isosceles")
    else : print("Scalene")
elif Ang1 + Ang2 + Ang3 != 180 : print("Error")