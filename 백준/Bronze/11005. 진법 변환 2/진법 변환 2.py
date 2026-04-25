Input_Num, Input_Change = map(int, input().split())
String_Num = []

while (Input_Num > Input_Change - 1) :
    String_Num.append(Input_Num % Input_Change)
    Input_Num = Input_Num // Input_Change

if Input_Num != 0 : String_Num.append(Input_Num)

for i in range(len(String_Num)) :
    if String_Num[i] >= 10 :
        String_Num[i] = chr(String_Num[i] + 55)

String_Num.reverse()
for i in range(len(String_Num)) : print(String_Num[i], end = "")