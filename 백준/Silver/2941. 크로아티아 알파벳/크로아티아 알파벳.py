Input_String = input()
stack = []
Cnt = 0

for ch in Input_String :

    if ch in "cdlnsz" : 
        stack.append(ch)

    elif ch in "=-j" :
        if stack:
            ch1 = stack.pop()

        else :
            Cnt += 1
            continue

        if (ch == "=" and ch1 == "z" and stack and stack[-1] == "d") :
            stack.pop()
            Cnt += 1 + len(stack)
            stack.clear()

        elif (ch == "=" and ch1 == "c") or \
            (ch == "-" and ch1 == "c") or \
            (ch == "-" and ch1 == "d") or \
            (ch == "j" and ch1 == "l") or \
            (ch == "j" and ch1 == "n") or \
            (ch == "=" and ch1 == "s") or \
            (ch == "=" and ch1 == "z"): 
            Cnt += 1 + len(stack)
            stack.clear()

        else : 
            Cnt += 2 + len(stack)
            stack.clear()

    else : Cnt += 1

if stack :
    Cnt += len(stack)
    stack.clear()

print(Cnt)