Input_Num = eval(input())
Input_String = []
Cnt = 0
Cnt1 = 0
stack = []
stack1 = []

for i in range(Input_Num) :
    Input_St = input()
    Input_String.append(Input_St)

for i in range(Input_Num) :

    for ch in Input_String[i] : 

        if not stack :
            stack.append(ch)

        else :
            ch1 = stack.pop()

            if ch == ch1 :
                stack.append(ch)
                stack.append(ch1)

            else : 
                if ch1 in stack1 : 
                    Cnt1 += 1
                    break
                else :
                    stack1.append(ch1)
                    stack.clear()
                    stack.append(ch)

    if stack :
        for j in stack :
            if j in stack1 : 
                Cnt1 += 1

    if Cnt1 != 0 : Cnt1 = 0
    else : Cnt += 1

    stack.clear()
    stack1.clear()

print(Cnt)