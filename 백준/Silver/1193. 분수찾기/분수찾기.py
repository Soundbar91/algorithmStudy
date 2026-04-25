Input_Num = int(input())
idx = 1
Min_Num = 2
Max_Num = 3

while (True) :
    if Input_Num == 1 : break

    if not Min_Num <= Input_Num <= Max_Num :
        Min_Num += idx + 1
        Max_Num += idx + 2
        idx += 1
    else : 
        idx += 1
        break

if Input_Num == 1 : 
    Numerator = 1
    Denominator = 1

elif idx % 2 == 0 :
    Numerator = 1 + (Input_Num - Min_Num)
    Denominator = idx - (Input_Num - Min_Num)

else :
    Numerator = idx - (Input_Num - Min_Num)
    Denominator = 1 + (Input_Num - Min_Num)
print(Numerator, end = "")
print("/", end = "")
print(Denominator, end = "")