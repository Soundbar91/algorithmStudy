Test_Number = eval(input())
Test_Score = list(map(int, input().split()))
Score_Max = Test_Score[0]
Score_Sum = 0

for i in range(1, len(Test_Score)) :
    if Score_Max < Test_Score[i] : Score_Max = Test_Score[i]

for i in range(len(Test_Score)) :
    Test_Score[i] = Test_Score[i] / Score_Max * 100
    Score_Sum += Test_Score[i]

print(Score_Sum / Test_Number)