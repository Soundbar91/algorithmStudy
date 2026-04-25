n1, n2 = map(int, input().split())

n1_ans = (n1 // 100) + ((n1 % 10) * 100) + (((n1 % 100) // 10) * 10)
n2_ans = (n2 // 100) + ((n2 % 10) * 100) + (((n2 % 100) // 10) * 10)

print(n1_ans if n1_ans > n2_ans else n2_ans)