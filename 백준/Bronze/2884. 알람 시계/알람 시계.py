H, M = input().split()
H, M = eval(H), eval(M)

M -= 45
if M < 0 :
    M += 60
    H -= 1
if M > 60 :
    H += M // 60
    M -= 1
if H < 0 :
    H += 24

print(H,M)