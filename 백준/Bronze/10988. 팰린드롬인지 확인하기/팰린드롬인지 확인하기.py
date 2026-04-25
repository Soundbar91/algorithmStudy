Input_String = input()

for i in range(0, len(Input_String) // 2) :
    if Input_String[i] != Input_String[(len(Input_String) - 1) - i] :
        print("0")
        exit()

print("1")