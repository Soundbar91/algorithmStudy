Input_String = input()
Clock_Arr = [3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7,7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10]
Cnt = 0

for i in range(len(Input_String)) :
    Cnt += Clock_Arr[ord(Input_String[i]) - 65]

print(Cnt)