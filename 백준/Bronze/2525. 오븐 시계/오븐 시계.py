H, M = input().split()
H, M = eval(H), eval(M)
Need_M = eval(input())

M += Need_M

if M >= 60 :
    H += M // 60
    M %= 60
if H >= 24 :
    H -= 24

print(H,M)