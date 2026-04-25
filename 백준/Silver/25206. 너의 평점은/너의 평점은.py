Score_List = []
Rank_List = []
Rank_Value = {'A+' : 4.5, 'A0' : 4.0, 'B+' : 3.5, 'B0' : 3.0, 'C+' : 2.5, 'C0' : 2.0, 'D+' : 1.5, 'D0' : 1.0, 'F' : 0.0}

for i in range(20) :
    Object_Name, Object_Score, Object_Rank = input().split()
    Score_List.append(float(Object_Score))
    Rank_List.append(Object_Rank)

Sum1 = 0.0
Sum2 = 0.0

for i in range(20) :
    ch = Rank_List[i]
    if ch == 'P' : continue
    Sum1 += Score_List[i] * Rank_Value[ch]

for i in range(20) :
    if Rank_List[i] == 'P' : continue
    else : Sum2 += Score_List[i]

print(Sum1 / Sum2)