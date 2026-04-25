a, b, c, d, e, f = map(int, input().split())

x = (c * e - f * b) // (a * e - d * b)
y = (a * f - d * c) // (a * e - d * b)

print(x, y)