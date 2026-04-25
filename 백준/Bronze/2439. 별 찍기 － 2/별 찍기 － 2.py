High = int(input())

for i in range(1, High + 1) :
    
    for j in range(High, i, -1) :
        print(" ", end = "")
    
    for k in range(1, i + 1) :
        print("*", end = "")
    
    print()