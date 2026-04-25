Num_Arr = list(map(int, input().split()))
Ascending_Arr = [1, 2, 3, 4, 5, 6, 7, 8]
Descending_Arr = [8, 7, 6, 5, 4, 3, 2, 1]

if Num_Arr == Ascending_Arr : print("ascending")
elif Num_Arr == Descending_Arr : print("descending")
else : print("mixed")