T = []
P = []
DP = []
n = int(input())
for _ in range(n):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)
    DP.append(p)
DP.append(0)

for i in range(n-1, -1, -1): # 뒤에서부터 가장 큰 값이 되도록 저장
    if i + T[i] > n:
        DP[i] = DP[i+1]
    else:
        DP[i] = max(DP[i+1], P[i] + DP[i+T[i]])
print(DP[0])