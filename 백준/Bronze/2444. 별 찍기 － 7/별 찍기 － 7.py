num = eval(input())

for i in range(num) :
    for j in range(num - 1, i, -1) :
        print(" ", end = "")
    
    for k in range(-1, i) :
        print("*", end = "")

    for l in range(i) :
        print("*", end = "")
    
    print(" ",end="")
    print()

for i in range(1, num) :
    for j in range(i) :
        print(" ", end = "")
    
    for k in range(i, num) : 
        print("*", end = "")

    for l in range(num - 1, i, -1) :
        print("*", end = "")

    if i != num - 1 : print(" ", end = "")

    print()