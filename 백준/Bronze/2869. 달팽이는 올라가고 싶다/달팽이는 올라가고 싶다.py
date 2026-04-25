Up_M, Down_M, Final_M = map(int, input().split())
Day = (Final_M - Up_M) // (Up_M - Down_M) if (Final_M - Up_M) % (Up_M - Down_M) == 0 else ((Final_M - Up_M) // (Up_M - Down_M)) + 1

print(Day + 1)